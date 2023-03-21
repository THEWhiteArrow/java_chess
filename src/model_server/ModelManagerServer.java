package model_server;

import mediator_server.GamePackage;
import mediator_server.ServerClientHandler;
import util.Logger;

import java.net.Socket;
import java.util.ArrayList;

public class ModelManagerServer implements ModelServer {

	private ArrayList<GameRoom> rooms;

	public ModelManagerServer() {
		rooms= new ArrayList<>();
	}

	@Override
	public synchronized boolean createGameRoom(String id, ServerClientHandler clientHandler) {
//		account for the case when room of given id already exists
		GameRoom room = new GameRoom(id);
		room.addChessPlayer(clientHandler);
		rooms.add(room);
		Logger.log("Successfully added a new room: {id:"+id+"}" +rooms.get(0).getId());

		Logger.log( getGameRoomById(room.getId()).toString() );
		return true;
	}

	public GameRoom getGameRoomById(String id){
		Logger.log("ROOM_ID: "+id);
		if(id==null)return null;
		for(GameRoom room : rooms){
			if(id.equals(room.getId()))
				return room;
		}
		return null;
	}

	@Override
	public synchronized boolean joinRoom(String id, ServerClientHandler clientHandler) {
		GameRoom room = getGameRoomById(id);
		if(room==null)return false;

		room.addChessPlayer(clientHandler);

		return true;
	}

	public synchronized  boolean addChatMessage(String id, String username, String message){
		GameRoom room = getGameRoomById(id);
		if(room==null)return false;

		room.addChessChatMessage(username,message);

		return true;
	}

	@Override
	public synchronized boolean updateChessGameRoom(String id, String notation) {
		Logger.log("UPDATE ROOM ID: "+id);
		GameRoom room = getGameRoomById(id);
		Logger.log(room.toString());
		if(room==null)return false;

		room.getChessGame().setNotation(notation);
		return true;
	}

	@Override
	public synchronized boolean leaveGameRoom(String id) {
		return false;
	}

	@Override
	public synchronized String getNotation(String id) {
		return null;
	}
}
