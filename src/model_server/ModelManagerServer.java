package model_server;

import java.net.Socket;

public class ModelManagerServer implements ModelServer {

	private GameRoom gameRoom;

	public ModelManagerServer() {

	}

	@Override
	public String createGameRoom(Socket socket) {
		return null;
	}

	@Override
	public boolean joinRoom(String id, Socket socket) {
		return false;
	}

	@Override
	public boolean updateChessGameRoom(String id, String notation) {
		return false;
	}

	@Override
	public boolean leaveGameRoom(String id) {
		return false;
	}

	@Override
	public String getNotation(String id) {
		return null;
	}
}
