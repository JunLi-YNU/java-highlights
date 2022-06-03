package com.reflect;

import com.reflection.User;

import java.lang.reflect.Field;

public class DemoReflection {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        User user = new User("JunLi",26);
        System.out.println(user);
        Class<User> userClass = User.class;
        Field field = userClass.getDeclaredField("name");
        field.setAccessible(true);
        System.out.println(field.get(user));
    }
}
