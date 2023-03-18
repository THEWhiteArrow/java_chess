package mediator_client;

import mediator_server.GamePackage;
import model_client.ModelClient;

import java.io.PrintWriter;
import java.net.Socket;

public class ClientConnector extends ClientModel {

	private String host;

	private int port;

	private Socket socket;

	private PrintWriter out;

	private ModelClient modelClient;

	public ClientConnector(ModelClient model) {

	}

	public void receivedPackage(GamePackage pkg) {

	}

}
