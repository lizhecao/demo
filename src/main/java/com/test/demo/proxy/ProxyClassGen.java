//package com.test.demo.proxy;
//
//import sun.misc.ProxyGenerator;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//
///**
// * 写代理类文件到磁盘中
// *
// * @author lizhecao 2018/4/20
// * @version 1.0
// */
//public class ProxyClassGen {
//  public static void main(String[] args) throws IOException {
//
////    // 第一种方法，直接将生成的字节数组写到文件中
////    byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy33", UserImpl.class.getInterfaces());
////
////    try(FileOutputStream outputStream = new FileOutputStream(
////        "/Users/lizhecao/java/demo/src/main/java/com/test/demo/proxy/$Proxy33.class")) {
////      outputStream.write(bytes);
////    }
//    // 第二种方法，设置系统属性值，有jdk自动写
//    System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
//    ProxyGenerator.generateProxyClass("$Proxy34", UserImpl.class.getInterfaces());
//  }
//}
