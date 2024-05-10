package by.intexsoft.model;

import by.intexsoft.model.constants.Colour;
import by.intexsoft.model.constants.Discount;


public class Apple extends Food{

    private String colour;

    public Apple(int amount, int price, String colour){
        this.amount = amount;
        this.price = price;
        this.colour = colour;
        this.isVegetarian = true;
    }

    @Override
    public int getAmount(){
        return this.amount;
    }

    @Override
    public int getPrice(){
        return this.price;
    }

    @Override
    public boolean isVegetarian(){
        return this.isVegetarian;
    }

    @Override
    public int getDiscount() {
        int discount = 0;
        if(this.colour == Colour.RED){
            discount = Discount.DISCOUNT_60;
        }
        return discount;
    }
}
