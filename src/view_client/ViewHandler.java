package view_client

-client;

import viewmodel-client.ViewModelFactory;
import mediator-server.String;

public class ViewHandler {

	private Stage primaryStage;

	private Scene currentScene;

	private ViewModelFactory viewModelFactory;

	public ViewHandler(ViewModelFactory viewModelFactory) {

	}

	public void start(Stage primaryStage) {

	}

	public void openView(String id) {

	}

	private Region loadView(String fxmlFile, ViewController viewController) {
		return null;
	}

}
