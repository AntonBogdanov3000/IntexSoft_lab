package by.intexsoft;

import by.intexsoft.model.Apple;
import by.intexsoft.model.Food;
import by.intexsoft.model.Meat;
import by.intexsoft.model.constants.Colour;
import by.intexsoft.service.ShoppingCart;


public class Main {

    public static void main(String[] args) {

        ShoppingCart shoppingCart = new ShoppingCart(new Food[]{
                new Meat(5, 100),
                new Apple(10, 50, Colour.RED),
                new Apple(8,60, Colour.GREEN)
        }
        );

        System.out.println("Total price with discount: " +  shoppingCart.getSumPriceWithDiscount());

        System.out.println("Total price without discount: " + shoppingCart.getSumPriceWithoutDiscount());

        System.out.println("Total price vegetarian without discount: " + shoppingCart.getSumPriceVegetarianWithoutDiscount());

    }
}