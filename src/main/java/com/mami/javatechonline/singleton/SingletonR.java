package com.mami.javatechonline.singleton;

public class SingletonR {

    private static SingletonR singleton = new SingletonR();

    private SingletonR() {

        if(singleton != null) throw new RuntimeException("Can't create instance.Please use getInstance() to create it");

        System.out.println("Constructor call ...");

    }

    public static SingletonR getInstance(){

        return singleton;
    }
}
