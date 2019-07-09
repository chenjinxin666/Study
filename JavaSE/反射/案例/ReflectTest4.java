package 反射.案例;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest4 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
        Person person = new Person();
        System.out.println(person.getName());
        setProperty(person,"name","aaa");
        System.out.println(person.getName());
    }

    public static void setProperty(Object obj,String fieldName,Object value) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        // 获取obj对应的字节码文件对象
        Class<?> aClass = obj.getClass();
        // 获取字段对象
        Field field = aClass.getDeclaredField(fieldName);
        // 取消java语法检查
        field.setAccessible(true);
        // 为obj对象里面的propertyName字段赋值为value
        field.set(obj,value);
    }
}
class Person{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
