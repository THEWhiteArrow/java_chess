package model_server ;

import mediator_server.ServerClientHandler;


public class GameRoom {
	private String id;

	private Chess chess;

	public GameRoom(String id){
		this.id=id;
		this.chess=new Chess();
	}

	public Chess getChessGame(){
		return chess;
	}

	public String getId(){
		return id;
	}

	public  void addChessPlayer(ServerClientHandler clientHandler){
		chess.addPlayer(clientHandler);
	}
}
