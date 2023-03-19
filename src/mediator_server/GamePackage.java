package mediator_server;

import java.io.Serializable;

public class GamePackage implements Serializable
{

	public static final String ERROR = "ERROR";

	public static final String NOTATION = "NOTATION";

	public static final String JOIN = "JOIN";

	private String type;

	private String notation;
	private String roomID; //Add to class diagram;

	private String error;

	public GamePackage(String type) {
	this.type = type;
	this.notation= null;
	this.error = null;
	this.roomID = null;
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
