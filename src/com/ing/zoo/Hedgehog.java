package com.ing.zoo;

class Hedgehog extends Animal implements PerformTrick, Omnivore {
    public Hedgehog() {
        super("Squawk! Hello from the parrot");
    }

    public void eatLeaves() {
        System.out.println("Satisfying nibbles, contented snuffles.");
    }

    public void eatMeat() {
        System.out.println("Satisfying crunches, contented sniffing.");
    }

    public void performTrick() {
        System.out.println("The hedgehog shows it's belly");    }
}
