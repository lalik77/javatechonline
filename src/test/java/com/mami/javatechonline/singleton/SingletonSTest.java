package com.mami.javatechonline.singleton;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SingletonSTest {

    @Test
    public void whenCreateTwoInstances_thenTheyHaveTheSameHashCode() {

        SingletonS singletonS1 = SingletonS.getInstance();

        SingletonS singletonS2 = SingletonS.getInstance();

        assertTrue(singletonS1.hashCode() == singletonS2.hashCode());

    }


    @Test
    public void whenCreateInstance_thenSerializeAndDeserializeItTheyHaveTheSameHashCode() throws IOException, ClassNotFoundException {

        SingletonS singletonS = SingletonS.getInstance();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.ser"));
        oos.writeObject(singletonS);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.ser"));
        SingletonS singletonS2 = (SingletonS) ois.readObject();
        ois.close();

        assertTrue(singletonS.hashCode() == singletonS2.hashCode());



    }

    @Test // this test fails because SingloneS is not protected against Reflection Violation
    public void  whenCreateTwoOrMoreInstances_andUseReflection_thenThrowsException() throws Exception {

        SingletonS singletonS1 = SingletonS.getInstance();

        SingletonS singletonS2 = SingletonS.getInstance();

        SingletonS singletonS4 = SingletonS.getInstance();

        Class clazz = Class.forName("com.mami.javatechonline.singleton.SingletonS");

        Constructor<SingletonS> constructor = clazz.getDeclaredConstructor();

        constructor.setAccessible(true);

        assertThrows(Exception.class,
                () -> { SingletonS singletonS3 ;
                    singletonS3 = constructor.newInstance();

                });



    }



}
