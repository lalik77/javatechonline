package com.mami.javatechonline.singleton;

public class Singleton {

    private static Singleton singleton = new Singleton();

    private Singleton() {
        System.out.println("Constructor call ...");
    }

    public static Singleton getInstance(){

        return singleton;
    }

}
