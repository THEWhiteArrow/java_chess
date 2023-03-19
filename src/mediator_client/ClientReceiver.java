package mediator_client;

import java.io.BufferedReader;
import java.net.Socket;

import com.google.gson.Gson;
import model_server.ModelServer;
public class ClientReceiver implements Runnable {

	private BufferedReader in;

	private ClientConnector client;

	private Gson gson;

	private ClientConnector clientConnector;

	public ClientReceiver(ClientConnector clientConnector, BufferedReader in) {


	}
	public void run() {

	}

}
