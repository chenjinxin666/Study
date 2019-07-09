package 反射.反射基础;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//反射构造方法并创建对象
public class ReflectConstructor {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class aClass = Class.forName("反射.反射基础.Person");

        //获取 public 的构造方法并打印
        Constructor[] constructors = aClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("-------------------------------------------------------------------");
        //获取 所有 的构造方法并打印
        constructors = aClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("-------------------------------------------------------------------");
        //获取公共的空参构造方法并创建对象;需要抛出 NoSuchMethodException
        Constructor constructor = aClass.getConstructor();
        System.out.println(constructor);
        //需要抛出 IllegalAccessException, InvocationTargetException, InstantiationException
        Object obj = constructor.newInstance();
        System.out.println(obj);
        //如果一个字节码文件对象中有空参构造方法，那么可以直接使用字节码文件对象的newInstance方法
        obj = aClass.newInstance();
        System.out.println(obj);
        System.out.println("-------------------------------------------------------------------");
        //获取公共的有参构造方法并创建对象
        constructor = aClass.getConstructor(String.class);
        System.out.println(constructor);
        obj = constructor.newInstance("唐三");
        System.out.println(obj);
        System.out.println("-------------------------------------------------------------------");
        //获取受保护的有参构造方法并创建对象
        constructor=aClass.getDeclaredConstructor(String.class,int.class);
        System.out.println(constructor);
        obj=constructor.newInstance("小舞",12);
        System.out.println(obj);
        System.out.println("-------------------------------------------------------------------");
        //获取默认的有参构造方法并创建对象
        constructor=aClass.getDeclaredConstructor(String.class,int.class,char.class);
        System.out.println(constructor);
        obj=constructor.newInstance("戴沐白",13,'男');
        System.out.println(obj);
        System.out.println("-------------------------------------------------------------------");
        //获取私有的构造方法并创建对象
        constructor = aClass.getDeclaredConstructor(String.class, int.class, char.class, String.class);
        System.out.println(constructor);
        //暴力反射，取消Java语法检查；JDK9 开始有所限制
        constructor.setAccessible(true);
        obj=constructor.newInstance("奥斯卡",12,'男',"未知");
        System.out.println(obj);
    }
}
