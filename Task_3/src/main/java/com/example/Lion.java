package com.example;

import java.util.List;


public class Lion extends Feline{

    boolean hasMane;
    private IFeline feline;

    public Lion(String sex) throws Exception {
        if ("Male".equals(sex)) {
            hasMane = true;
        } else if ("Female".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Use true types of sex - male of female");
        }
    }

    public Lion(IFeline feline){
        this.feline = feline;
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return getFood("Predator");
    }

}
