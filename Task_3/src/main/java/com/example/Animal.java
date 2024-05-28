package com.example;

import java.util.List;


public class Animal {

    public List<String> getFood(String animalKind) throws Exception {
        if ("Herbivore".equals(animalKind)) {
            return List.of("Grass", "Other plants");
        } else if ("Predator".equals(animalKind)) {
            return List.of("Animals", "Birds", "Fish");
        } else {
            throw new Exception("Unknown type of animal, use Herbivore or Predator types");
        }
    }

    public String getFamily() {
        return "There are several kinds: hare, squirrel, mice, cats, hounds, bears";
    }
}