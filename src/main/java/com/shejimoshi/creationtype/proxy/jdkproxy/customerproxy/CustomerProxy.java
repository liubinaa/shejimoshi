package com.shejimoshi.creationtype.proxy.jdkproxy.customerproxy;


import lombok.SneakyThrows;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.List;

/**
 * 自定义实现JDK的proxy
 * @author liubin
 */
public class CustomerProxy {
    private static final String LN = "\r\n";

    @SneakyThrows
    public static Object newProxyInstance(CustomerClassloader customerClassloader, Class<?>[] interfaces, CustomerInvocationHandler h) {
        //1、动态生成.java文件
        String s = generateSrc(interfaces);
        //2、java文件输出到磁盘
        String path = CustomerProxy.class.getResource("").getPath();
        try {
            path = URLDecoder.decode(path,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(path);
        File file = new File(path + "$Proxy0.java");
        if(!file.exists()){
            try {
                if (!file.createNewFile()) {
                    System.out.println("创建文件失败!");
                }
                System.out.println("创建成功!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (FileWriter fw = new FileWriter(file)){
            fw.write(s);
            fw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        //3、把生成的.java文件编译成.class文件
        //把生成的.java文件编译成.class文件
        JavaCompiler systemJavaCompiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager standardFileManager = systemJavaCompiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> iterable = standardFileManager.getJavaFileObjects(file);
        //返回一个编译任务
        JavaCompiler.CompilationTask task = systemJavaCompiler.getTask(null, standardFileManager, null, null, null, iterable);
        task.call();
        try {
            standardFileManager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //4、编译生成的.class文件加载到jvm中
        Class<?> proxyClass = customerClassloader.findClass("$Proxy0");
        //5、返回字节码重组以后新的代理对象
        //通过反射new一个对象
        Constructor<?> constructor = proxyClass.getConstructor(CustomerInvocationHandler.class);
        file.delete();
        return constructor.newInstance(h);
    }

    private static String generateSrc(Class<?>[] interfaces) {
        //略过
        StringBuffer sb = new StringBuffer();
        sb.append("package com.shejimoshi.creationtype.proxy.jdkproxy.customerproxy;" + LN);
        sb.append("import com.shejimoshi.creationtype.proxy.jdkproxy.Person;" + LN);
        sb.append("import java.lang.reflect.Method;" + LN);
        sb.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + LN);

        sb.append("CustomerInvocationHandler h;" + LN);
        sb.append("public $Proxy0(CustomerInvocationHandler h) { " + LN);
        sb.append("this.h = h;" + LN);
        sb.append("}" + LN);
        for (Method m : interfaces[0].getMethods()) {
            sb.append("@Override" + LN);
            sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "() {" + LN);
            sb.append("try {" + LN);
            sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() +"\", new Class[]{});" + LN);
            sb.append("this.h.invoke(this, m, null);");

            sb.append("} catch(Throwable e) {" + LN);
            sb.append("e.printStackTrace();" + LN);
            sb.append("}");
            sb.append("}" + LN);
        }
        sb.append("}" + LN);
        return sb.toString();
    }
}
