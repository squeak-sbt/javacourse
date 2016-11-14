package ru.sbt.homework6;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeanUtils {
    public static void assign(Object from, Object to) {
        if (from == null || to == null) {
            return;
        }
        Map<String, Method> map = new HashMap<>();
        for (Method method : from.getClass().getDeclaredMethods()) {
            map.put(method.getName().toLowerCase(), method);
        }
        for (Method method : to.getClass().getDeclaredMethods()) {
            if (method.getName().toLowerCase().startsWith("set")) {
                String field = method.getName().toLowerCase();
                field = field.substring(3, field.length());
                Method method1 = map.get("get" + field);
                if (method1 != null) {
                    if (method.getParameterCount() == 1 &&
                            method1.getReturnType().equals(method.getParameterTypes()[0])) {
                        try {
                            method.invoke(to, method1.invoke(from));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
