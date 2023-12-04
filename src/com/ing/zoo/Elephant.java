package com.ing.zoo;

class Elephant extends Animal implements Herbivore, PerformTrick {
    public Elephant() {
        super("Trumpet! Hello from the elephant");
    }

    public void eatLeaves() {
        System.out.println("The elephant munches on leaves with its long trunk");
    }

    public void performTrick() {
        System.out.println("The elephant balances on its hind legs");
    }
}