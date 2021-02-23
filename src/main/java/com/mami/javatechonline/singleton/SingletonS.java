package com.mami.javatechonline.singleton;

import java.io.Serializable;

// When we serialize an object and deserialize it again  there are different hashcode

public class SingletonS implements Serializable {

    private static SingletonS singletonS = new SingletonS();

    private SingletonS() {

        System.out.println("Constructor call ...");
    }

    public static SingletonS getInstance() {

        return singletonS;
    }


    private Object readResolve() {
        System.out.println("Applying readResolve() ... ");
        return SingletonS.getInstance();
    }


}
