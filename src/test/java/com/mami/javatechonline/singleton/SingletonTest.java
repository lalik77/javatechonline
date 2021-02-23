package com.mami.javatechonline.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.*;

public class SingletonTest {

    @Test
    public void whenCreateTwoInstances_thenTheyHaveSameHashCode() {

        Singleton singleton1 = Singleton.getInstance();

        Singleton singleton2 = Singleton.getInstance();

        assertTrue(singleton1.hashCode()==singleton2.hashCode());
    }

    @Test
    public void whenCreateTwoInstances_andUseReflectionTheHaveDifferentHashCode() throws Exception {

        Singleton singleton1 = Singleton.getInstance();

        Singleton singleton2 = Singleton.getInstance();

        Class clazz = Class.forName("com.mami.javatechonline.singleton.Singleton");

        Constructor<Singleton> constructor = clazz.getDeclaredConstructor();

        constructor.setAccessible(true);

        singleton2 = constructor.newInstance();

        assertFalse(singleton1.hashCode()==singleton2.hashCode());


    }

}
