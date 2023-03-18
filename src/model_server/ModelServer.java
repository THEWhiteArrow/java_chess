package model_server;

import mediator_server.ServerConnector;

import java.net.Socket;

public interface ModelServer {

//	public ServerConnector serverConnector;

	public abstract String createGameRoom(Socket socket);

	public abstract boolean joinRoom(String id, Socket socket);

	public abstract boolean updateChessGameRoom(String id, String notation);

	public abstract boolean leaveGameRoom(String id);

	public abstract String getNotation(String id);

}
