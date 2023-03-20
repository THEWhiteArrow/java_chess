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

public class ClientConnector  implements ModelClient
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
			t1.setDaemon(true);
			t1.start();
			this.property=new PropertyChangeSupport(this);



		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}

	}

	public void receivedPackage(GamePackage pkg) { //This function might be private and without any arguments passed
		// then we should check for a package being received by the inputStream (in.readline) and then check the type of this package.
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

	@Override public boolean createGameRoom(String id)
	{
		GamePackage pkg = new GamePackage(GamePackage.CREATE).setRoomID(id);
		out.println( gson.toJson(pkg) );

		try {
			wait();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		if(gamePackage!=null && GamePackage.CREATE.equals(gamePackage.getType()))
			return true;

//		fire error property event?
		return false;
	}

	@Override public void joinGameRoom(String id)
	{
		GamePackage gamePackage = new GamePackage(GamePackage.JOIN,id,null,null);
		out.println(gamePackage);
	}

	@Override public boolean leaveGameRoom(String id)
	{
		return false;
	}

	@Override public void sendNotation(String roomId, String notation)
	{
		modelClient.sendNotation(roomId,notation);
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
		property.addPropertyChangeListener(listener);
	}

	@Override public void removeListener(PropertyChangeListener listener)
	{
		property.removePropertyChangeListener(listener);
	}
}
