package models;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class OrderList {

    private Order[] orders;

    public OrderList(Order[] orders) {
        this.orders = orders;
    }
}
