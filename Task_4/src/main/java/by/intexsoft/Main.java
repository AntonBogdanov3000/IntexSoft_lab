package by.intexsoft;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();
        AnimalFarm animalFarm = new AnimalFarm(animals);

        animalFarm.addToAnimalFarm(Animal.DOG, "Sam");
        animalFarm.addToAnimalFarm(Animal.DOG, "Sal");
        animalFarm.addToAnimalFarm(Animal.CAT, "Pushok");
        animalFarm.addToAnimalFarm(Animal.HORSE, "Spirit");

        animalFarm.addToAnimalFarm(Animal.COW, "Mu-mu");  // Задание 3. метод public void addToAnimalFarm(Animal animal, String name)
        animalFarm.addToAnimalFarm(Animal.HORSE);    // Задание 3. метод public void addToAnimalFarm(Animal animal)
        animalFarm.addToAnimalFarm("Flipper");  // Задание 3. метод public void addToAnimalFarm(String name)

        System.out.println(animalFarm.countedAnimals());   // Задание 1. работа метода public Map<Animal, Integer> countedAnimals()
        System.out.println(animalFarm.uniqueNames());     // Задание 2. работа метода Set<String> uniqueNames()

        System.out.println(animalFarm);  // Задание 4. переопределенный метод toString()

    }
}
