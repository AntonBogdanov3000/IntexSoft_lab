package com.example;

import java.util.List;

public class Cat {

    Predator predator;

    public Cat(Feline feline) {
        this.predator = feline;
    }

    public String getSound() {
        return "Meow";
    }

    public List<String> getFood(){
        try {
            return predator.eatMeat();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
