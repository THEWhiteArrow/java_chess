package model_server;


import mediator_server.ServerClientHandler;
import util.Logger;
import util.PkgType;

import java.util.ArrayList;


public class Chess {

	private boolean[] isWhite;

	private String notation;

	private ArrayList<String> chatLogs;


	private ArrayList<ServerClientHandler> serverClientHandler;

	public Chess(){

		serverClientHandler = new ArrayList<>();
		chatLogs = new ArrayList<>();
		chatLogs.add("SYSTEM: Welcome all players!");
	}
	public void setNotation(String notation) {
		Logger.log("inside setNoation method inside chess");
		this.notation = notation;
		notifyPlayers(PkgType.NOTATION);

	}

	public String getNotation() {
		return null;
	}


	public void addPlayer(ServerClientHandler player)
	{
		 serverClientHandler.add(player);
	}

	public void addChatMessage(String username, String message){
		chatLogs.add(0,username+" : "+ message);
		notifyPlayers(PkgType.CHAT);
	}

	public void notifyPlayers(PkgType chat){
		for (ServerClientHandler player : serverClientHandler) {
			if(player!=null)
				if(chat == PkgType.NOTATION)
					player.sendNotationPackage(notation);
				else if(chat == PkgType.CHAT)
					player.sendChatPackage(chatLogs.get(0));
		}
	}


	public synchronized ArrayList<String> getChatLogs(){
		return chatLogs;
	}

}
