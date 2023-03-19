package mediator_server;



import model_server.ModelServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnector {

	private ServerSocket welcomeSocket;

	private int port;

	private ModelServer modelServer;

	public ServerConnector(ModelServer model, int port) {
		this.port = port;
		this.modelServer = model;
		try
		{
			this.welcomeSocket = new ServerSocket(port);
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
		System.out.println("Server starting ....");
		System.out.println("Server running....");
		start();

	}

	private void start() {
		while	(true)
		try
		{
			Socket socket = welcomeSocket.accept();
			ServerClientHandler serverClientHandler = new ServerClientHandler(modelServer,socket);
			System.out.println("Client Connected");
			serverClientHandler.run();
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}

	}

	public void close() throws IOException
	{
		welcomeSocket.close();
	}
}
