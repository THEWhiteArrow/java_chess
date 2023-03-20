package model_server;

import mediator_server.ServerClientHandler;
import mediator_server.ServerConnector;

import java.net.Socket;

public interface ModelServer {

//	public ServerConnector serverConnector;

	public abstract boolean createGameRoom(String id,ServerClientHandler clientHandler);

	public abstract boolean joinRoom(String id, ServerClientHandler clientHandler);

	public abstract boolean updateChessGameRoom(String id, String notation);

	public abstract boolean leaveGameRoom(String id);

	public abstract String getNotation(String id);

}
