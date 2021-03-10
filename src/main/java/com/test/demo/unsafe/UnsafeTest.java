//package com.test.demo.unsafe;
//
//import sun.misc.Unsafe;
//
//import java.lang.reflect.Field;
//
//import static rx.internal.util.unsafe.UnsafeAccess.UNSAFE;
//
///**
// * @author lizhecao 2018/4/28
// * @version 1.0
// */
//public class UnsafeTest {
//  public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//    User user = new User();
//    // getUnsafe 只能被BootLoader加载，其他地方调用会跑出SecurityException
//    // Unsafe unsafe = Unsafe.getUnsafe();
//
//    // 但是我们可以通过反射来轻松获取Unsafe的实例
//    Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
//    unsafeField.setAccessible(true);
//    Unsafe unsafe = (Unsafe) unsafeField.get(null);
//
//    // Unsafe 可以获取指定实例field在对象内存中的偏移量
//    long offset = unsafe.objectFieldOffset(user.getClass().getDeclaredField("age"));
//    System.out.println(offset);
//
//    // 也可以通过比较并替换的机制，修改指定偏移量内存的值
//    UNSAFE.compareAndSwapInt(user, offset, 0, 123);
//    System.out.println(user.getAge());
//
//    // 还可以使用park挂起，unpark唤醒线程，分配实例内存，修改私有域等
//  }
//}
