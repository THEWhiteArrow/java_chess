package model_client;

public interface ModelClient extends utility.observer.javaobserver.UnnamedPropertyChangeSubject {

	public abstract String createGameRoom();

	public abstract void joinGameRoom(String id);

	public abstract boolean leaveGameRoom(String id);

	public abstract void sendNotation(String roomId, String notation);

	public abstract String getNotation(String id);

	public abstract void displayMessage(String msg);

	boolean connectToServer(String host, int port);

}
