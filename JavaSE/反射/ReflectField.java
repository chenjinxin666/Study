package 反射;

import java.lang.reflect.Field;

public class ReflectField {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<?> aClass = Class.forName("反射.Person");
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }
        System.out.println("--------------------------------------------------------------------------------------");
        Person p = (Person) aClass.newInstance();
        System.out.println(p);
        System.out.println("--------------------------------------------------------------------------------------");
        Field field = aClass.getField("name");
        System.out.println(field);
        field.set(p,"宁荣荣");
        Object obj = field.get(p);
        System.out.println(obj);
        System.out.println(p);
        System.out.println("--------------------------------------------------------------------------------------");
        field = aClass.getDeclaredField("age");
        System.out.println(field);
        field.set(p,12);
        obj = field.get(p);
        System.out.println(obj);
        System.out.println(p);
        System.out.println("--------------------------------------------------------------------------------------");
        field = aClass.getDeclaredField("sex");
        System.out.println(field);
        field.set(p,'女');
        obj = field.get(p);
        System.out.println(obj);
        System.out.println(p);
        System.out.println("--------------------------------------------------------------------------------------");
        field = aClass.getDeclaredField("address");
        field.setAccessible(true);
        System.out.println(field);
        field.set(p,"天斗城/九宝琉璃宗");
        obj = field.get(p);
        System.out.println(obj);
        System.out.println(p);
        System.out.println("--------------------------------------------------------------------------------------");
    }
}
