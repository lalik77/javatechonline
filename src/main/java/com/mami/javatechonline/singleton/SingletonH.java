package com.mami.javatechonline.singleton;


 // Bill Pugh Singleton - Holder Class method

public class SingletonH {

    private SingletonH() {
        System.out.println("Constructor call ...");
    }

    static class Holder {

        static final SingletonH INSTANCE = new SingletonH(); // lazy
    }


    public static SingletonH getInstance() {

        return Holder.INSTANCE;
    }



}
