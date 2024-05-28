package com.example;

import java.util.List;


public class Feline extends Animal implements Predator, IFeline{

    @Override
    public List<String> eatMeat() throws Exception {
        return getFood("Predator");
    }

    @Override
    public String getFamily() {
        return "Cats";
    }

    @Override
    public int getKittens() {
        return getKittens(1);
    }

    @Override
    public int getKittens(int kittensCount) {
        return kittensCount;
    }
}
