package by.intexsoft.model;


public abstract class Food implements Discountable{

    protected int amount;
    protected int price;
    protected boolean isVegetarian;

    public Food(int amount, int price){
        this.amount = amount;
        this.price = price;
    }

    public abstract int getAmount();
    public abstract int getPrice();
    public abstract boolean isVegetarian();

}
