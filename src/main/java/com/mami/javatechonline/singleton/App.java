package com.mami.javatechonline.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class App {

    static void singletonCloneViolation() {
        SingletonC singletonC1 = SingletonC.getInstance();

        SingletonC singletonC2 = SingletonC.getInstance();

        System.out.println(singletonC1.hashCode());
        System.out.println(singletonC2.hashCode());

        try {
            SingletonC singletonC3  = (SingletonC) singletonC2.clone();
            System.out.println(singletonC3.hashCode());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

     static void singletonReflectionViolation() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException {
        SingletonR singletonR1 = SingletonR.getInstance();

        SingletonR singletonR2 = SingletonR.getInstance();

        SingletonR singletonR4 = SingletonR.getInstance();

        Class clazz = Class.forName("com.mami.javatechonline.singleton.SingletonR");

        Constructor<SingletonR> constructor = clazz.getDeclaredConstructor();

        constructor.setAccessible(true);

        SingletonR singletonR = constructor.newInstance();
    }

    static void singletonSerializationViolation() throws IOException, ClassNotFoundException {
        SingletonS singletonS1 = SingletonS.getInstance()                ;

        SingletonS singletonS2 = SingletonS.getInstance();

        System.out.println(singletonS1.hashCode());
        System.out.println(singletonS2.hashCode());

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file.ser")) ;
        oos.writeObject(singletonS2);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file.ser"));
        SingletonS singletonS3 = (SingletonS) ois.readObject();
        ois.close();

        System.out.println(singletonS3.hashCode());
    }

    public static void main(String[] args) throws ClassNotFoundException,
                                                  NoSuchMethodException, InvocationTargetException,
                                                  InstantiationException, IllegalAccessException,
                                                                                           IOException {

       // singletonCloneViolation();
      //  singletonReflectionViolation();
      singletonSerializationViolation();
    }


}







