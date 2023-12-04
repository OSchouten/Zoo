package com.ing.zoo;

class Parrot extends Animal implements PerformTrick, Omnivore {
    public Parrot() {
        super("Squawk! Hello from the parrot");
    }

    public void eatLeaves() {
        System.out.println("Squawk, treats");
    }

    public void eatMeat() {
        System.out.println("Squawk, meat");
    }

    public void performTrick() {
        System.out.println("The parrot performs a flying trick");
    }
}
