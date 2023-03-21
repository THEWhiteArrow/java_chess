package mediator_server;

import com.google.gson.Gson;
import model_server.ModelServer;
import util.ChatPackage;
import util.Logger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

public class ServerClientHandler implements Runnable, PropertyChangeListener
{

	private Socket socket;

	private BufferedReader in;

	private PrintWriter out;

	private Gson gson;


	private ModelServer model;


	public ServerClientHandler(ModelServer model,Socket socket) {
		this.model = model;
		this.socket = socket; // Change class diagram ;
		this.gson = new Gson();
		try
		{
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.out = new PrintWriter(socket.getOutputStream(),true);
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}

	}

	public void disconnect() {
		try
		{
			in.close();
			out.close();
			socket.close();
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	public void sendErrorPackage(String message) {
		GamePackage gamePackage = new GamePackage(GamePackage.ERROR,null,null,message);
		String sendError = gson.toJson(gamePackage);
		out.println(sendError);
	}

	public synchronized void sendNotationPackage(String notation) {
		Logger.log("sending the notation from server to client");
		GamePackage gamePackage = new GamePackage(GamePackage.NOTATION, null,notation,null);
		String sendError = gson.toJson(gamePackage);
		out.println(sendError);
	}

	public synchronized  void sendChatPackage(String message){
		Logger.log("prepared to send a chat message but not sending yet... " + message);
	}

	public void run() {
		while (true)
		{
			try
			{
				String receive =in.readLine();
				Logger.log("received: "+receive);
				Map<String,String> pkg = gson.fromJson(receive,Map.class);

				if(pkg.get("type").equals("CHAT")){
					ChatPackage chatPackageReceived = gson.fromJson(receive, ChatPackage.class);
					String roomId = chatPackageReceived.getRoomId();
					String username = chatPackageReceived.getUsername();
					String message = chatPackageReceived.getMessage();

					model.addChatMessage(roomId,username,message);
				}else{

					GamePackage gamePackageReceived = gson.fromJson(receive, GamePackage.class);

					switch (gamePackageReceived.getType())

					{
						case GamePackage.NOTATION:

							String id =gamePackageReceived.getRoomID();
							Logger.log("id null? : "+id);
							String notation = gamePackageReceived.getNotation();
							model.updateChessGameRoom(id,notation);
							Logger.log("working notation...");
							break;

						case GamePackage.ERROR:
							String error = gamePackageReceived.getError();
							out.println(error);
							break;

						case GamePackage.JOIN:
							String roomID = gamePackageReceived.getRoomID();
							model.joinRoom(roomID,this);
							Logger.log("JOIN WORKING");
							out.println(gson.toJson(new GamePackage(GamePackage.JOIN,gamePackageReceived.getRoomID(),null,null)));
							break;
						case GamePackage.CREATE:
							String roomId = gamePackageReceived.getRoomID();
							Logger.log("requested a new room creation...");
							model.createGameRoom(roomId,this);
							out.println( gson.toJson(new GamePackage(GamePackage.CREATE,null,null,null)));
							break;
					}
				}

			}
			catch (IOException e)
			{
				System.out.println("error: "+e.getMessage());
				break;
//				throw new RuntimeException(e);
			}
		}


	}

	@Override public void propertyChange(PropertyChangeEvent evt)
	{
		GamePackage gamePackage = new GamePackage(null,null,null,
				(String) evt.getNewValue());
		out.println(gson.toJson(gamePackage));

	}
}
