package 反射.反射基础;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectMethod {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("反射.反射基础.Person");
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        Object obj = aClass.newInstance();
        System.out.println("------------------------------------------------------");
        Method method = aClass.getMethod("show", Object.class);
        System.out.println(method);
        method.invoke(obj,"show...");
        System.out.println("------------------------------------------------------");
        method = aClass.getDeclaredMethod("getSum", int.class, int.class);
        System.out.println("getSum...");
        Object v = method.invoke(obj, 1, 2);
        System.out.println(v);
        System.out.println("------------------------------------------------------");
        method = aClass.getDeclaredMethod("concat", String.class, String.class);
        System.out.println(method);
        v=method.invoke(obj,method.invoke(obj,"who"," are")," you");
        System.out.println(v);
        System.out.println("------------------------------------------------------");
        method=aClass.getDeclaredMethod("method");
        System.out.println(method);
        method.setAccessible(true);
        v=method.invoke(obj);
    }
}
