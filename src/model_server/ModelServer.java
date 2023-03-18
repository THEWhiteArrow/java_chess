package model_server

-server;

import mediator-server.ServerConnector;
import mediator-server.String;
import mediator-server.Socket;

public interface ModelServer {

	private ServerConnector serverConnector;

	public abstract String createGameRoom(Socket socket);

	public abstract boolean joinRoom(String id, Socket socket);

	public abstract boolean updateChessGameRoom(String id, String notation);

	public abstract boolean leaveGameRoom(String id);

	public abstract String getNotation(String id);

}
