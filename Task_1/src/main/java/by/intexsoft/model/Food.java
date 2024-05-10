package by.intexsoft.model;


public abstract class Food implements Discountable{

    protected int amount;
    protected int price;
    protected boolean isVegetarian;

    public abstract int getAmount();
    public abstract int getPrice();
    public abstract boolean isVegetarian();

}
