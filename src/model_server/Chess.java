package model_server;


import mediator_server.ServerClientHandler;
import util.Logger;

import java.awt.*;

public class Chess {

	private boolean[] isWhite;

	private String notation;


	private ServerClientHandler[] serverClientHandler;

	public Chess(){
		serverClientHandler = new ServerClientHandler[2];
	}
	public void setNotation(String notation) {
		Logger.log("inside setNoation method inside chess");
		this.notation = notation;
		for (ServerClientHandler player : serverClientHandler) {
			player.sendNotationPackage(notation);
		}

	}

	public String getNotation() {
		return null;
	}


	public void addPlayer(ServerClientHandler player)
	{
		if (serverClientHandler[0]==null)
		{
			serverClientHandler[0] =player;
		}
		else serverClientHandler[1]= player;
	}

}
