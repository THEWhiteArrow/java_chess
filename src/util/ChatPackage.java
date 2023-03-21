package util;

import java.io.Serializable;

public class ChatPackage implements Serializable {
    public final static String CHAT = "CHAT";
    public final static String GET = "GET";

    private String type;
    private String username,message,roomId;
    public ChatPackage(String type,String roomId,String username, String message){
        this.type = type;
        this.username=username;
        this.message=message;
        this.roomId=roomId;
    }

    public String getType(){
        return type;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
    }
}
