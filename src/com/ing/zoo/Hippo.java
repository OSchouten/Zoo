package com.ing.zoo;

public class Hippo extends Animal implements Herbivore {
    public Hippo() {
        super("Splash");
    }

    public void eatLeaves() {
        eatText = "munch munch lovely";
        System.out.println(eatText);
    }
}
