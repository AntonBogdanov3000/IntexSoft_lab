package by.intexsoft.model;


public class Meat extends Food{

    public Meat(int amount, int price) {
        super(amount, price);
        isVegetarian = false;
    }

    @Override
    public int getAmount() {
        return this.amount;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public boolean isVegetarian() {
        return this.isVegetarian;
    }

    @Override
    public int getDiscount() {
        return 0;
    }
}
