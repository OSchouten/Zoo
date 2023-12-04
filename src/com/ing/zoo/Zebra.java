package com.ing.zoo;

public class Zebra extends Animal implements Herbivore {

    public Zebra() {
        super("zebra zebra");
    }

    public void eatLeaves() {
        eatText = "munch munch zank yee bra";
        System.out.println(eatText);
    }
}
