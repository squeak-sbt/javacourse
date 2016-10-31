package ru.sbt.lesson5;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectionUtils {
    public static void printMethodInfo(Object o) throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz = o.getClass();
        while (clazz != null) {
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if (method.getName().startsWith("get")){
                    System.out.println(method.invoke(o));
                }
            }
            clazz = clazz.getSuperclass();
        }
    }

    public static List<Field> getAllFields(Object o){
        List<Field> list = new ArrayList<>();
        Class<?> clazz = o.getClass();
        while (clazz != null) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                list.add(field);
            }
            clazz = clazz.getSuperclass();
        }
        return list;
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Person person = new Person("ddddd", "sdsdsd");
        printMethodInfo(person);
    }
}
