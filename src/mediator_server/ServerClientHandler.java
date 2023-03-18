package mediator_server;

import model_server.ModelManagerServer;
import model_server.ModelServer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerClientHandler implements Runnable, PropertyChangeListener{

	private Socket socket;

	private BufferedReader in;

	private PrintWriter out;

	private com.google.gson.Gson gson;

	private String roomId;

	private ModelServer modelServer;

	private ServerClientSocket serverClientSocket;

	public ServerClientHandler(ModelServer model) {

	}

	public void disconnect() {

	}

	public void sendErrorPackage(String message) {

	}

	public void sendNotationPackage(String notation) {

	}

	public void run() {

	}

	@Override public void propertyChange(PropertyChangeEvent evt)
	{

	}
}
