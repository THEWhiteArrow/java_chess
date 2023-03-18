package mediator_server;

import java.io.Serializable;

public class GamePackage implements Serializable
{

	public static String ERROR = "ERROR";

	public static String NOTATION = "NOTATION";

	private String type;

	private String notation;

	private String error;

	public GamePackage(String type) {

	}

	public String getType() {
		return null;
	}

	public String getNotation() {
		return null;
	}

	public String getError() {
		return null;
	}

	public void setNotation(String notation) {

	}

	public void setError(String error) {

	}

}
