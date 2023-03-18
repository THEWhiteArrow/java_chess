package mediator_client;

import java.io.BufferedReader;
import java.net.Socket;

import model_server.ModelServer;
public class ClientReceiver implements Runnable {

	private BufferedReader in;

	private ClientConnector client;

//	private com.google.gson.Gson gson;

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
