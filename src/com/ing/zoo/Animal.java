package com.ing.zoo;

public abstract class Animal {
    protected String name;
    protected String helloText;
    protected String eatText;

    public Animal(String helloText) {
        this.helloText = helloText;
    }

    public void sayHello() {
        System.out.println(helloText);
    }

}
