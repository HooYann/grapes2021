package org.yann.dynamicproxy.util;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ProxyClassFileUtil {

    public static void createFile(String proxyClassName, Class[] interfaces) {
        byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
                proxyClassName, interfaces);

        String path = "D:\\IdeaProj\\grapes2021\\S0101_DynamicProxy\\target\\classes\\org\\yann\\dynamicproxy\\util\\";
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(path + proxyClassName + ".class");
            out.write(proxyClassFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException ee) {
                ee.printStackTrace();
            }
        }

    }

}
