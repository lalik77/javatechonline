package com.mami.javatechonline.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnumSingletonTest {

    @Test
    public void whenCreateTwoInstances_thenTheyHaveTheSameHashCode()
    {
        EnumSingleton singletonE1 = EnumSingleton.SINGLETON_INSTANCE  ;

        EnumSingleton singletonE2 = EnumSingleton.SINGLETON_INSTANCE ;

        assertTrue(singletonE1.hashCode() == singletonE2.hashCode());
    }

}
