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

    /**
     * Processes a user command for interacting with animals in the zoo.
     *
     * @param input The user input string containing the command and, optionally, an animal name.
     */
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

    /**
     * Performs a specific command for a given animal or all animals in the zoo.
     *
     * @param command        The command to be performed (e.g., "hello", "give leaves").
     * @param specificAnimal The specific animal to perform the command on, or null to perform on all animals.
     */
    private void performCommand(String command, Animal specificAnimal) {
        if (command.equals("hello") && specificAnimal != null) {
            specificAnimal.sayHello();
        }

        for (Animal animal : animals.values()) {
            switch (command) {
                case "hello":
                    if (specificAnimal == null) {
                        animal.sayHello();
                    }
                    break;

                case "give leaves":
                    if (animal instanceof Herbivore) {
                        ((Herbivore) animal).eatLeaves();
                    } else {
                        System.out.println(animal.name + " won't eat leaves.");
                    }
                    break;

                case "give meat":
                    if (animal instanceof Carnivore) {
                        ((Carnivore) animal).eatMeat();
                    } else {
                        System.out.println(animal.name + " won't eat meat.");
                    }
                    break;

                case "perform trick":
                    if (animal instanceof PerformTrick) {
                        ((PerformTrick) animal).performTrick();
                    } else {
                        System.out.println(animal.name + " won't perform tricks.");
                    }
                    break;

                default:
                    System.out.println("Unknown command: " + command);
                    System.exit(0);
            }
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
