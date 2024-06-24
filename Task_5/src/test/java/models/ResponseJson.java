package models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResponseJson {

    private boolean ok;
    private int code;
    private String message;
    private int track;

    public ResponseJson(boolean ok){
        this.ok = ok;
    }

    public ResponseJson(int code, String message){
        this.code = code;
        this.message = message;
    }

    public ResponseJson(int track){
        this.track = track;
    }

}
