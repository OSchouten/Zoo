package com.ing.zoo;

import java.util.Random;

public class Tiger extends Animal implements Carnivore, PerformTrick {
    public String trick;

    public Tiger() {
        super("rraaarww");
    }

    public void eatMeat() {
        eatText = "nomnomnom oink wubalubadubdub";
        System.out.println(eatText);
    }

    @Override
    public void performTrick() {
        Random random = new Random();
        int rnd = random.nextInt(2);
        if (rnd == 0) {
            trick = "jumps in tree";
        } else {
            trick = "scratches ears";
        }
        System.out.println(trick);
    }
}
