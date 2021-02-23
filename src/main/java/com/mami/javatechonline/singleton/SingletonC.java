package com.mami.javatechonline.singleton;

public class SingletonC implements Cloneable{

    public static SingletonC singletonC = new SingletonC();

    private SingletonC() {

        System.out.println("Constructor call ...");
    }

    public static SingletonC getInstance() {
        return singletonC;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        if(singletonC != null)
            throw new CloneNotSupportedException("Can't create instance.Please use getInstance() to create it") ;

        return super.clone();
    }

}
