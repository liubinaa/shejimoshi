package com.shejimoshi.proxy.jdkproxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * JDK动态代理的原理
 * 1、拿到被代理对象的引用，并且获取它的所有的接口，发射获取
 * 2、JDK proxy类重新生成一个新的类，同时新的类要实现被代理类实现的所有接口
 * 3、动态生成java代码，在自己新加的业务逻辑方法由一定的逻辑代码去调用(在代码中体现)
 * 4、编译新生成的java代码.class
 * 5、再重新加载带jvm运行
 * 6、完成后删除文件 或者变为在内存中编译
 * 以上的过程叫做字节码重组
 * * @author liubin
 */
public class TestProxy {
    public static void main(String[] args) {

        //这里只能强转为接口！！！ 否则报错
        Person o = (Person) new JdkProxy().toInstance(new ZhangSan());
        o.findLove();
        System.out.println(o);
        //通过反编译工具可以查看Proxy0的源代码
        byte[] $Proxy0s = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
        try (FileOutputStream fos = new FileOutputStream(
                "src\\main\\java\\com\\shejimoshi\\proxy\\jdkproxy\\$Proxy.class")) {
            fos.write($Proxy0s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
