package mediator_client;


import com.google.gson.Gson;
import mediator_server.GamePackage;
import model_client.ModelClient;
import model_server.GameRoom;
import util.ChatPackage;
import util.ChatPackageList;
import util.Logger;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Map;

public class ClientConnector  implements ModelClient, utility.observer.javaobserver.UnnamedPropertyChangeSubject
{

	private GamePackage receivedPackage;
	private ChatPackageList chatPackageList;
	private Gson gson;  // ADd to class diagram
	private Socket socket;
	private PropertyChangeSupport property;
	private BufferedReader in;

	private PrintWriter out;

	private ModelClient modelClient;
	private boolean setSpectator = false;


	public ClientConnector(String host,int port) {

		try
		{
			this.socket = new Socket(host,port);
			out = new PrintWriter(socket.getOutputStream(),true);
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.out = new PrintWriter(socket.getOutputStream(),true);
			this.receivedPackage = null;
			this.chatPackageList=null;
			gson = new Gson();
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

	public synchronized void  receivedPackage(String json) { //This function might be private and without any arguments passed
		// then we should check for a package being received by the inputStream (in.readline) and then check the type of this package.
		Logger.log("received package");
		Map<String,String> pkgMap = gson.fromJson(json, Map.class);
		if(pkgMap.get("type").equals("CHAT")){
			ChatPackage chatPkg = gson.fromJson(json,ChatPackage.class);
			property.firePropertyChange("CHAT",null, chatPkg.getMessage());
		}
		else if(pkgMap.get("type").equals("CHAT-LIST")){
			chatPackageList = gson.fromJson(json, ChatPackageList.class);
			notify();
		}
		else{

			receivedPackage = gson.fromJson(json, GamePackage.class);
			switch (receivedPackage.getType()){
				case GamePackage.CREATE, GamePackage.JOIN:
					notify();
					break;
				case GamePackage.ERROR:
					if (receivedPackage.getError().equals("aaa111"))
						setSpectator=true;
					else setSpectator=false;
						break;
				default:
					property.firePropertyChange(receivedPackage.getType(),null, receivedPackage);
			}
		}

	}
	@Override
	public synchronized boolean setSpectator()
	{
		return setSpectator;
	}


	public synchronized ArrayList<String> getAllChat(String roomId){
		out.println( gson.toJson(  new ChatPackage("GET",roomId,null,null)) );

		try {
			wait();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}


		return chatPackageList.getChats();
	}


	public synchronized void sendChatMessage(String id, String username, String message){
		ChatPackage pkg = new ChatPackage(ChatPackage.CHAT,id,username,message);
		String json = gson.toJson(pkg);
		Logger.log("sending chat message...");
		out.println(json);
	}

	@Override public synchronized boolean createGameRoom(String id)
	{
		GamePackage pkg = new GamePackage(GamePackage.CREATE,id,null,null);
		Logger.log("sending create request...");
		out.println( gson.toJson(pkg) );

		Logger.log("sent...");
		try {
			Logger.log("starting to wait...");
			wait();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		Logger.log("WORKSSSSSSSSSSSSSSSSSSSSS!!...");
		if(receivedPackage!=null && GamePackage.CREATE.equals(receivedPackage.getType()))
			return true;

//		fire error property event?

		return false;
	}

	@Override public synchronized boolean joinGameRoom(String id)
	{
		Logger.log("joining the room...");
		GamePackage gamePackage = new GamePackage(GamePackage.JOIN,id,null,null);
		out.println(gson.toJson(gamePackage));
		Logger.log("send join room request...");
		try {
			Logger.log("starting to wait...");
			wait();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		if (receivedPackage!= null && GamePackage.JOIN.equals(receivedPackage.getType()))
			return true;
		return false;
	}

	@Override public synchronized boolean leaveGameRoom(String id)
	{
		return false;
	}

	@Override public synchronized void sendNotation(String roomId, String notation)
	{

		Logger.log("CLIENT ROOM ID: "+roomId);
		GamePackage gamePackage = new GamePackage(GamePackage.NOTATION, roomId,notation,null);
		String sendNotation = gson.toJson(gamePackage);
		out.println(sendNotation);
	}

	@Override public String getNotation(String id)
	{
		receivedPackage =gson.fromJson(id, GamePackage.class);
		if (receivedPackage.getType().equals(GamePackage.NOTATION))
			return receivedPackage.getNotation();
		return null;
	}

	@Override public void displayMessage(String msg)
	{
		GamePackage gamePackage = new GamePackage(null,null,null,msg);
		String displayMessage = gson.toJson(gamePackage);
		out.println(displayMessage);
	}

	@Override
	public boolean connectToServer(String host, int port) {
//		no purpose for that
		return false;
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
