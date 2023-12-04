package com.ing.zoo;

public class Lion extends Animal implements Carnivore{

    public Lion()
    {
        super("roooaoaaaaar");
    }

    public void eatMeat()
    {
        eatText = "nomnomnom thx mate";
        System.out.println(eatText);
    }
}
