package com.ing.zoo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Zoo {
    private Map<String, Animal> animals;

    public Zoo() {
        this.animals = new HashMap<>();
    }

    public void addAnimal(Animal animal) {
        animals.put(animal.name.toLowerCase(), animal);
    }

    public void processCommand(String input) {
        String[] splitCommand = input.split(",");
        if (splitCommand.length == 1) {
            performCommand(splitCommand[0], null);
        } else if (splitCommand.length == 2) {
            String command = splitCommand[0];
            String animalName = splitCommand[1].toLowerCase().trim();

            Animal animal = animals.get(animalName);
            if (animal != null) {
                performCommand(command, animal);
            } else {
                System.out.println("Unknown animal: " + animalName);
            }
        } else {
            System.out.println("Invalid command: " + input);
        }
    }

    private void performCommand(String command, Animal specificAnimal) {
        switch (command) {
            case "hello":
                if (specificAnimal != null) {
                    specificAnimal.sayHello();
                } else {
                    for (Animal animal : animals.values()) {
                        animal.sayHello();
                    }
                }
                break;

            case "give leaves":
                if (specificAnimal instanceof Herbivore) {
                    ((Herbivore) specificAnimal).eatLeaves();
                } else {
                    System.out.println(specificAnimal.name + " won't eat meat.");
                }
                break;

            case "give meat":
                if (specificAnimal instanceof Carnivore) {
                    ((Carnivore) specificAnimal).eatMeat();
                } else {
                    System.out.println(specificAnimal.name + " won't eat leaves.");
                }
                break;

            case "perform trick":
                if (specificAnimal instanceof PerformTrick) {
                    ((PerformTrick) specificAnimal).performTrick();
                } else if (specificAnimal == null) {
                    for (Animal animal : animals.values()) {
                        if (animal instanceof PerformTrick) {
                            ((PerformTrick) animal).performTrick();
                        }
                    }
                } else {
                    System.out.println(specificAnimal.name + " won't't perform any tricks.");
                }
                break;

            default:
                System.out.println("Unknown command: " + command);

        }
    }


    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        Lion henk = new Lion();
        henk.name = "henk";
        Hippo elsa = new Hippo();
        elsa.name = "elsa";
        Pig dora = new Pig();
        dora.name = "dora";
        Tiger wally = new Tiger();
        wally.name = "wally";
        Zebra marty = new Zebra();
        marty.name = "marty";

        zoo.addAnimal(henk);
        zoo.addAnimal(elsa);
        zoo.addAnimal(dora);
        zoo.addAnimal(wally);
        zoo.addAnimal(marty);

        StringBuilder commandsBuilder = new StringBuilder();
        commandsBuilder.append("The following commands are available:\n");
        commandsBuilder.append("hello\n");
        commandsBuilder.append("give leaves\n");
        commandsBuilder.append("give meat\n");
        commandsBuilder.append("perform trick\n");
        commandsBuilder.append("Use the format: Command, AnimalName");
        String commandsString = commandsBuilder.toString();
        System.out.println(commandsString);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your command: ");

        String input = scanner.nextLine();

        zoo.processCommand(input);
    }
}
