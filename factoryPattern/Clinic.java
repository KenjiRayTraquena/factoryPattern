package factoryPattern;

import java.util.Scanner;

public class Clinic {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n[1] Dog");
            System.out.println("[2] Cat");
            System.out.println("[3] Exit");
            System.out.print("Choose: ");
            choice = input.nextInt();

            if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            }

            if (choice != 1 && choice != 2) {
                System.out.println("Invalid! Try again.");
                continue;
            }

            PetRecord petFile = new PetRecord();
            Pet pet;
            String extraInfo = "";

            if (choice == 1) {
                pet = new Dog();
                petFile.setPetId("D01");
                petFile.setPetName("Bantay");
                ((Dog) pet).setBreed("German Shepherd");
                extraInfo = "Breed: " + ((Dog) pet).getBreed();
            } else {
                pet = new Cat();
                petFile.setPetId("C01");
                petFile.setPetName("Muning");
                ((Cat) pet).setNoOfLives(9);
                extraInfo = "Lives: " + ((Cat) pet).getNoOfLives();
            }

            petFile.setPet(pet);

            System.out.println("\nPet ID is " + petFile.getPetId());
            System.out.println("Pet name is " + petFile.getPetName());
            System.out.println("Pet Kind: " + pet.getClass().getSimpleName());
            System.out.println(extraInfo);
            System.out.println("Communication Sound: " + pet.makeSound());
            System.out.println("Play mode: " + pet.play());

        } while (true);

        input.close();
    }
}

