package model_client;



import mediator_client.ClientConnector;

import mediator_server.GamePackage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelManagerClient implements ModelClient, PropertyChangeListener {

	private ClientModel clientModel;

	public void ModelManagerClient() {
		clientModel=null;
	}

	public boolean connectToServer(String host, int port){
		clientModel = new ClientConnector(host, port);

		return true;
	}


	/**
	 * @see model-client.ModelClient#createGameRoom()
	 *  
	 */
	public boolean createGameRoom(String id) {
		return true;
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

	@Override
	public void addListener(PropertyChangeListener listener) {

	}

	@Override
	public void removeListener(PropertyChangeListener listener) {

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		property.firePropertyChange(evt);
	}
}
