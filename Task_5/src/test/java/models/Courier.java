package models;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class Courier {

    public static String createdCourierId;
    private long id;
    private String login;
    private String password;
    private String firstName;

    public Courier(){}

    public Courier(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    public Courier(long id){
        this.id = id;
    }
}
