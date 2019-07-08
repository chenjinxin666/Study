package 反射;

/*
 * 反射概述：对于任意一个类，能动态的获取它的任意组成部分，可以任意的调用它的成员。
 * 想要反射解剖一个类，首先需要获取到该类的字节码文件对象
 */
public class GetClassDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取字节码文件对象

        // 通过对象的getClass方法
        Class clazz = new Person().getClass();
        // 通过类名.classs
        Class clazz2 = Person.class;
        // 通过全路径名；需要抛出ClassNotFoundException
        Class clazz3 = Class.forName("反射.Person");

        ClassLoader classLoader = GetClassDemo.class.getClassLoader();
        //需要抛出ClassNotFoundException
        Class clazz4 = classLoader.loadClass("反射.Person");

        System.out.println(clazz==clazz2);//true
        System.out.println(clazz==clazz3);//true
        System.out.println(clazz==clazz4);//true
    }
}
