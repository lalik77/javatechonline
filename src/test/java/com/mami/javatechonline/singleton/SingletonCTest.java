package com.mami.javatechonline.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SingletonCTest {

    @Test
    public void whenCreateTwoInstances_thenTheyHaveTheSameHashCode()
    {
        SingletonC singletonC1 = SingletonC.getInstance();

        SingletonC singletonC2 = SingletonC.getInstance();

        assertTrue(singletonC1.hashCode() == singletonC2.hashCode());
    }


    @Test
    public void whenCreateInstance_andCloneIt_thenThrowsException() throws CloneNotSupportedException {

        SingletonC singletonC = SingletonC.getInstance();

        assertThrows(CloneNotSupportedException.class,
                () -> { SingletonC clone = (SingletonC) singletonC.clone();

                });

    }

}
