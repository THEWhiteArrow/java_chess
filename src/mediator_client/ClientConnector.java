package mediator_client

-client;

import mediator-server.String;
-server.Socket;
-server.PrintWriter;
import mediator_server.GamePackage;
import mediator_server.PrintWriter;
import mediator_server.Socket;
import mediator_server.String;
import model-client.ModelClient;-server.GamePackage;

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
