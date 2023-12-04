package com.ing.zoo;

public abstract class Animal {
    protected String name;
    protected String helloText;
    protected String eatText;

    public Animal() {
    }

    public void sayHello() {
        System.out.println(helloText);
    }

    public abstract void eat();

}
