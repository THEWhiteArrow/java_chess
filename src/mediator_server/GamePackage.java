package mediator_server;

import java.io.Serializable;

public class GamePackage implements Serializable
{

	public static final String ERROR = "ERROR";

	public static final String NOTATION = "NOTATION";

	public static final String JOIN = "JOIN";
    public static final String CREATE = "CREATE";

    private String type;

	private String notation;
	private String roomID; //Add to class diagram;

	private String error;

	public GamePackage(String type,String roomID,String notation, String error) {
	this.type = type;
	this.notation= notation;
	this.error = error;
	this.roomID = roomID;
	}

	public String getType() {
		return type;
	}

	public String getNotation() {
		return notation;
	}

	public String getError() {
		return error;
	}

	public void setNotation(String notation) {
		this.notation = notation;

	}
	public String getRoomID()
	{
		return roomID;
	}

	public void setError(String error) {
		this.error = error;

	}

	public void setRoomID(String roomID)
	{
		this.roomID = roomID;

	}
}
