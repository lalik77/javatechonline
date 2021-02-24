package com.mami.javatechonline.singleton;


//Joshua Bloch Singleton
//using Enum to implement Singleton design pattern ensure that any enum value is instanciated only once .
//Buy ist inflexible and does not allow lazy instantiation
public enum EnumSingleton {

    SINGLETON_INSTANCE;

    public static void doMoreThing(){

       // do something

    }


}
