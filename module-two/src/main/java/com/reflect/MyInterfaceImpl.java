package com.reflect;


import com.reflection.MyInterface;

public class MyInterfaceImpl implements MyInterface {

    @Override
    public String getMyName(String firstName, String lastName) {
        return firstName+lastName;
    }
}
