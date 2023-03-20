package mediator_server;

import com.google.gson.Gson;
import model_server.ModelServer;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerClientHandler implements Runnable, PropertyChangeListener
{

	private Socket socket;

	private BufferedReader in;

	private PrintWriter out;

	private Gson gson;

	private String roomId;

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

	public void sendNotationPackage(String notation) {

		GamePackage gamePackage = new GamePackage(GamePackage.NOTATION, null,notation,null);
		String sendError = gson.toJson(gamePackage);
		out.println(sendError);
	}

	public void run() {
		while (true)
		{
			try
			{
				String receive =in.readLine();
				GamePackage gamePackageReceived = gson.fromJson(receive, GamePackage.class);

				switch (gamePackageReceived.getType())

				{
					case GamePackage.NOTATION:
						String id =gamePackageReceived.getRoomID();
						String notation = gamePackageReceived.getNotation();
						model.updateChessGameRoom(id,notation);
						out.println("working notation");
						break;

					case GamePackage.ERROR:
						String error = gamePackageReceived.getError();
						out.println(error);
						break;

					case GamePackage.JOIN:
						String roomID = gamePackageReceived.getRoomID();
						model.joinRoom(roomID,socket);
						out.println("JOIN WORKING");
				}

			}
			catch (IOException e)
			{
				throw new RuntimeException(e);
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
