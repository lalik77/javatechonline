package com.mami.javatechonline.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.*;

public class SingletonRTest {

    public static SingletonR staticSngltn;

    @Test
    public void whenCreateTwoInstances_thenTheyHaveTheSameHashCode(){

        SingletonR singletonR1 = SingletonR.getInstance();

        SingletonR singletonR2 = SingletonR.getInstance();

        assertTrue(singletonR1.hashCode() == singletonR2.hashCode());



    }

    @Test
   public void  whenCreateTwoOrMoreInstances_andUseReflection_thenThrowsException() throws Exception {

        SingletonR singletonR1 = SingletonR.getInstance();

        SingletonR singletonR2 = SingletonR.getInstance();

        SingletonR singletonR4 = SingletonR.getInstance();

        Class clazz = Class.forName("com.mami.javatechonline.singleton.SingletonR");

        Constructor<SingletonR> constructor = clazz.getDeclaredConstructor();

        constructor.setAccessible(true);

       assertThrows(Exception.class,
                () -> { SingletonR singletonR3 ;
                singletonR3 = constructor.newInstance();

        });

        assertThrows(Exception.class,
                () -> {
                  staticSngltn= constructor.newInstance();

                });

        assertTrue(singletonR1.hashCode() == singletonR2.hashCode());

        assertTrue(singletonR4.hashCode() == singletonR2.hashCode());

       assertThrows(NullPointerException.class, () -> staticSngltn.hashCode());




    }
}
