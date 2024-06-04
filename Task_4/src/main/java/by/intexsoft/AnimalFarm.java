package by.intexsoft;

import java.util.*;


public class AnimalFarm {

    private List<String> farmAnimals;

    public AnimalFarm(List<String> farmAnimals){
        this.farmAnimals = farmAnimals;
    }

    public List<String> getFarmAnimals() {
        return farmAnimals;
    }

    public void addToAnimalFarm(Animal animal, String name){
        farmAnimals.add(animal.name() + " " + name);
    }

    public void addToAnimalFarm(Animal animal){
        farmAnimals.add(animal.name() + " " + "N");
    }

    public void addToAnimalFarm(String name){
        farmAnimals.add(Animal.NOT_DEFINED.name() + " " + name);
    }


    public Map<Animal, Integer> countedAnimals(){
        Map<Animal, Integer> animalMap = new HashMap<>();
        Animal animalName = null;
        for(String animal : farmAnimals){
            String[] split = animal.split(" ");
            try {
                animalName = Animal.valueOf(split[0]);
            }
            catch (IllegalArgumentException e) {
                System.out.println("Please correct string [ " + e.getMessage() + " ] Incorrect input data ");
            }
                Integer countOfAnimal = 1;
                if (!animalMap.containsKey(animalName)) {
                    animalMap.put(animalName, countOfAnimal);
                } else {
                    try {
                        int currentCountOfAnimal = animalMap.get(animalName);
                        animalMap.remove(animalName);
                        animalMap.put(animalName, currentCountOfAnimal + 1);
                    }catch (IllegalArgumentException e) {
                        System.out.println("Please correct string [ " + e.getMessage() + " ] Incorrect input data ");
                    }
                }
        }
        return animalMap;
    }


    public Set<String> uniqueNames(){
        Set<String> uniqueNameList = new HashSet<>();
            for (String name : getFarmAnimals()) {
                try {
                    String[] split = name.split(" ");
                    uniqueNameList.add(split[1]);
                }catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Please correct string [" + e.getMessage() +
                            " ] Incorrect input data");
                }
            }
        return uniqueNameList;
    }


    @Override
    public String toString(){
        for(String animal : getFarmAnimals()){
            System.out.println(animal);
        }
        return "";
    }
}

