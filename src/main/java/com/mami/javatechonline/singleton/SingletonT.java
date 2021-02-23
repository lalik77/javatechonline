package com.mami.javatechonline.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonT {

    private static SingletonT singletonT = null; // lazy intantiation

    private SingletonT() {

        System.out.println("Constructor call ...");
    }

    public static SingletonT getInstance() {

        if(singletonT == null) {
            singletonT = new SingletonT();
        }

        return singletonT;
    }

    static void useSingleton() {

        Singleton singleton = Singleton.getInstance();
        System.out.println("Hashcode of singleton object : " + singleton.hashCode());
    }

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(SingletonT::useSingleton);
        while ( testHashCode(getInstance().hashCode())) {
            service.submit(SingletonT::useSingleton);
            service.submit(SingletonT::useSingleton);

        }


        service.shutdown();

    }

    private static boolean testHashCode(int hashCode) {

        if ( hashCode == singletonT.hashCode() )
            return true;
        else return false;
    }
}
