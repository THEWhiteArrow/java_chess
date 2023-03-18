package mediator_server

-server;

import model-server.ModelManagerServer;
import model-server.ModelServer;

public class ServerClientHandler implements java::lang::Runnable, java::beans::PropertyChangeListener, java::lang::Runnable {

	private Socket socket;

	private BuferedReader in;

	private PrintWriter out;

	private Gson gson;

	private String roomId;

	private ModelManagerServer modelManagerServer;

	private ModelServer modelServer;

	private ServerClientSocket serverClientSocket;

	public ServerClientHandler(ModelServer model) {

	}

	public void disconnect() {

	}

	public void sendErrorPackage(String message) {

	}

	public void sendNotationPackage(String notation) {

	}


	/**
	 * @see java::beans::PropertyChangeListener#propertyChange(PropertyChangeEvent)
	 *  
	 */
	public void propertyChange(PropertyChangeEvent evt) {

	}


	/**
	 * @see java::lang::Runnable#run()
	 *  
	 */
	public void run() {

	}

}
