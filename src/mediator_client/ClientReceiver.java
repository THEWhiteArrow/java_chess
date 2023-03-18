package mediator_client

-client;

import mediator-server.GamePackage;
import mediator-server.BuferedReader;
import mediator-server.Gson;
import mediator-server.Socket;
import model-server.ModelServer;

public class ClientReceiver implements java::lang::Runnable {

	private BuferedReader in;

	private ClientConnector client;

	private Gson gson;

	private ClientConnector clientConnector;

	public ClientReceiver(Socket socket, ModelServer model) {

	}


	/**
	 * @see java::lang::Runnable#run()
	 *  
	 */
	public void run() {

	}

}
