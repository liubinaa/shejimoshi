package com.shejimoshi.proxy.jdkproxy.customerproxy;

import java.io.*;
import java.net.URLDecoder;

/**
 * @author liubin
 */
public class CustomerClassloader extends ClassLoader {

    private File classPathFile;

    public CustomerClassloader() {
        String classPath = CustomerClassloader.class.getResource("").getPath();
        try {
            classPath = URLDecoder.decode(classPath,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        this.classPathFile = new File(classPath);
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //把字节加载到jvm中,通过字节输出
        String className = CustomerClassloader.class.getPackage().getName() + "." + name;
        if (classPathFile != null) {
            File classFile = new File(classPathFile, name.replaceAll("\\.", "/") + ".class");
            if (classFile.exists()) {
                try(FileInputStream in = new FileInputStream(classFile);
                    ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                    byte[] buff = new byte[1024];
                    int len;
                    while ((len = in.read(buff)) != -1) {
                        out.write(buff, 0, len);
                    }
                    return defineClass(className, out.toByteArray(),0, out.size());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
