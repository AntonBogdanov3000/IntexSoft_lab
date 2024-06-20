package models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Order {

    public static long createdOrderTrack;
    public static long createdOrderId;
    private long id;
    private long courierId;
    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phone;
    private int rentTime;
    private String deliveryDate;
    private long track;
    private String comment;
    private String[] color;
    private String createdAt;
    private String updatedAt;
    private int status;
    private boolean cancelled;
    private boolean finished;
    private boolean inDelivery;


    public Order(String firstName, String lastName, String address,
                 String metroStation, String phone, int rentTime,
                 String deliveryDate, String comment, String[] color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;
    }


    public Order(long id, long courierId, String firstName, String lastName,
                 String address, String metroStation, String phone, int rentTime,
                 String deliveryDate, long track, String comment, String[] color,
                 String createdAt, String updatedAt, int status) {
        this.id = id;
        this.courierId = courierId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.track = track;
        this.comment = comment;
        this.color = color;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public Order(long id, String firstName, String lastName,
                 String address, String metroStation, String phone, int rentTime,
                 String deliveryDate, long track, String comment, boolean cancelled,
                 boolean finished, boolean inDelivery, String[] color,
                 String createdAt, String updatedAt, int status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.track = track;
        this.color = color;
        this.comment = comment;
        this.cancelled = cancelled;
        this.finished = finished;
        this.inDelivery = inDelivery;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }
}
