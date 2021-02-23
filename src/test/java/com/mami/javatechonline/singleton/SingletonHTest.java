package com.mami.javatechonline.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SingletonHTest {

    @Test
    public void whenCreateTwoInstances_thenTheyHaveTheSameHashCode()
    {
        SingletonH singletonH1 = SingletonH.getInstance();

        SingletonH singletonH2 = SingletonH.getInstance();

        assertTrue(singletonH1.hashCode() == singletonH2.hashCode());
    }
}
