package model_client

-client;

-client.ClientModel;
import mediator-server.String;

public class ModelManagerClient implements ModelClient, ModelClient {

	private ClientModel clientModel;

	public void ModelManagerClient() {

	}


	/**
	 * @see model-client.ModelClient#createGameRoom()
	 *  
	 */
	public String createGameRoom() {
		return null;
	}


	/**
	 * @see model-client.ModelClient#joinGameRoom(mediator-server.String)
	 *  
	 */
	public void joinGameRoom(String id) {

	}


	/**
	 * @see model-client.ModelClient#leaveGameRoom(mediator-server.String)
	 *  
	 */
	public boolean leaveGameRoom(String id) {
		return false;
	}


	/**
	 * @see model-client.ModelClient#sendNotation(mediator-server.String, mediator-server.String)
	 */
	public void sendNotation(String roomId, String notation) {

	}


	/**
	 * @see model-client.ModelClient#getNotation(mediator-server.String)
	 */
	public String getNotation(String id) {
		return null;
	}


	/**
	 * @see model-client.ModelClient#displayMessage(mediator-server.String)
	 */
	public void displayMessage(String msg) {

	}

}
