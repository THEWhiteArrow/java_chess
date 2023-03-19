package view_client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import viewmodel_client.ViewModelFactory;

public class ViewHandler {

	private Region root;
	private Stage primaryStage;
	private ChessViewController chessViewController;

	private Scene currentScene;

	private ViewModelFactory viewModelFactory;

	public ViewHandler(ViewModelFactory viewModelFactory) {
		this.viewModelFactory = viewModelFactory;
		currentScene = new Scene(new Region());
	}

	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		openView("chess");
	}

	public void closeView() {
		primaryStage.close();
	}

	public void openView(String id) {
		switch (id)
		{
			case "chess":
				chessViewController = loadViewController("ChessBoard.fxml",chessViewController);
				break;
		}
		currentScene.setRoot(root);

		String title = "";
		if (root.getUserData() != null)
		{
			title += root.getUserData();
		}
		primaryStage.setTitle(title);
		primaryStage.setResizable(false);
		primaryStage.setScene(currentScene);
		primaryStage.setWidth(root.getPrefWidth());
		primaryStage.setHeight(root.getPrefHeight());
		primaryStage.show();
	}

	private ChessViewController loadViewController(String fxmlFile, ChessViewController viewController) {
		if (viewController == null)
		{
			try
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource(fxmlFile));
				this.root = loader.load();
				viewController = loader.getController();
				viewController
						.init(this, viewModelFactory.getChessViewModel(), this.root);
				viewController.reset();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			viewController.reset();
		}
		return viewController;
	}

}
