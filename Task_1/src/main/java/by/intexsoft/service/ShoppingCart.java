package by.intexsoft.service;

import by.intexsoft.model.Food;


public class ShoppingCart {

    private Food[] foodArray;


    public ShoppingCart(Food[] foodArray){
        this.foodArray = foodArray;
    }

    public int getSumPriceWithoutDiscount(){
        int result = 0;
        for (Food food : foodArray){
            if(food.getDiscount() == 0){
                result += food.getPrice() * food.getAmount();
            }
        }
        return result;
    }

    public int getSumPriceWithDiscount(){
        int result = 0;
        for (Food food : foodArray){
            int discount = food.getDiscount();
            if(food.getDiscount() != 0){
                result += (food.getPrice() * food.getAmount()) / 100 * discount;
            }
        }
        return result;
    }

    public int getSumPriceVegetarianWithoutDiscount(){
        int result = 0;
        for (Food food : foodArray){
            if(food.getDiscount() == 0 && food.isVegetarian()){
                result += food.getPrice() * food.getAmount();
            }
        }
        return result;
    }
}
