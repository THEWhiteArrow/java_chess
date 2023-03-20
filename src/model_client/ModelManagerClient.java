package model_client;



import mediator_client.ClientConnector;

import mediator_server.GamePackage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelManagerClient implements ModelClient, PropertyChangeListener {

	private ClientConnector client;

	private PropertyChangeSupport property;

	public ModelManagerClient() { }

	public boolean connectToServer(String host, int port){
		this.property = new PropertyChangeSupport(this);
		this.client = new ClientConnector(host, port);
		this.client.addListener(this);

		return true;
	}

	public synchronized boolean createGameRoom(String id) {
		return client.createGameRoom(id);
	}

	public synchronized boolean joinGameRoom(String id) {

		return client.joinGameRoom(id);
	}

	public synchronized boolean leaveGameRoom(String id) {
		return false;
	}


	public synchronized void sendNotation(String roomId, String notation) {
		client.sendNotation(roomId,notation);

	}

	public synchronized String getNotation(String id) {
		return null;
	}

	/**
	 * NOT BEING USED
	 */
	public synchronized void displayMessage(String msg) {
		client.displayMessage(msg);
	}

	@Override
	public void addListener(PropertyChangeListener listener) {
		property.addPropertyChangeListener(listener);

	}

	@Override
	public void removeListener(PropertyChangeListener listener) {
		property.removePropertyChangeListener(listener);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		property.firePropertyChange(evt);
	}
}
