package mediator_client;

import com.google.gson.Gson;
import mediator_server.GamePackage;
import model_client.ModelClient;
import model_server.GameRoom;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

public class ClientConnector extends ClientModel implements ModelClient
{

	private GamePackage gamePackage;
	private Gson gson;  // ADd to class diagram
	private Socket socket;
	private PropertyChangeSupport property;
	private BufferedReader in;

	private PrintWriter out;

	private ModelClient modelClient;


	public ClientConnector(String host,int port) {

		try
		{
			this.socket = new Socket(host,port);
			out = new PrintWriter(socket.getOutputStream(),true);
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.out = new PrintWriter(socket.getOutputStream(),true);
			this.gamePackage = null;
			ClientReceiver  clientReceiver = new ClientReceiver(this,this.in);
			Thread t1 =new Thread((clientReceiver));
			this.property=new PropertyChangeSupport(this);



		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}

	}

	public void receivedPackage(GamePackage pkg) {
		switch (pkg.getType())
		{
			case GamePackage.NOTATION ->
			{
				sendNotation(pkg.getRoomID(),pkg.getNotation());
				break;
			}
			case GamePackage.ERROR ->
			{
				displayMessage(pkg.getError());
				break;
			}
			case	GamePackage.JOIN ->
			{
				joinGameRoom(pkg.getRoomID());
				break;
			}
		}


	}

	@Override public String createGameRoom()
	{

	}

	@Override public void joinGameRoom(String id)
	{

	}

	@Override public boolean leaveGameRoom(String id)
	{
		return false;
	}

	@Override public void sendNotation(String roomId, String notation)
	{

	}

	@Override public String getNotation(String id)
	{
		return null;
	}

	@Override public void displayMessage(String msg)
	{

	}

	@Override public void addListener(PropertyChangeListener listener)
	{

	}

	@Override public void removeListener(PropertyChangeListener listener)
	{

	}
}
