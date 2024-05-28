package com.example;

import java.util.List;


public class LionAlex extends Lion{

    public LionAlex() throws Exception {
        super("Male");
    }

    public List<String> getFriends(){
        return List.of("Marty", "Gloria", "Melman");
    }

    public String getPlaceOfLiving(){
        return "New York Zoo";
    }

    @Override
    public int getKittens(){
        return 0;
    }
}
