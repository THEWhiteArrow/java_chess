package view_client;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import util.DraggableMaker;
import util.FENParser;
import util.Logger;
import util.Piece;
import viewmodel_client.ChessViewModel;
import viewmodel_client.ViewModel;

import java.io.File;
import java.util.ArrayList;


public class ChessViewController extends ViewController {
	@FXML private Pane piecesPane;
	@FXML private Pane mainPane;
	@FXML private GridPane grid;
	@FXML private TextField chatField;

	@FXML private ListView<String> listView;


	private ChessViewModel viewModel;




	public void init(ViewHandler viewHandler, ViewModel viewModel, Region root){
		this.viewHandler=viewHandler;
		this.viewModel= (ChessViewModel) viewModel;
		this.root=root;
		Logger.log("IS IT A SPECTATOR STILL:::" + ((ChessViewModel) viewModel).setSpectator());
		Logger.log("Items being set");
		listView.setItems(this.viewModel.getChatList());
		Logger.log("Items  set");

		this.viewModel.getNotationProperty().addListener((obs,oldValue,newValue)->{
			// here with event notation sth wrong
			String notation = (String)newValue;
			Logger.log(notation);

			Platform.runLater(()->{
				updatePieces(notation);
			});

		});

		this.chatField.textProperty().bindBidirectional(this.viewModel.getChatProperty());

		reset();
	}

	public Region getRoot(){
		return root;
	}


	@FXML private void changeView(){
//		Platform.runLater( ()-> {
//			Logger.log("cahnge view");
//			piecesPane.setRotate(piecesPane.getRotate()+180.0);
//			for(Node node : piecesPane.getChildren())
//				node.setRotate(node.getRotate()+180.0);
//
//		});
		viewModel.changeView();

	}


	@FXML private void enterPressed(){
		Logger.log("pressed");
		viewModel.sendChatMessage();
	}


	public void reset() {
		viewModel.clear();
	}

	public void sendNotation(String fieldName){
		String notation = FENParser.calculateFen( piecesPane.getChildren() ) +" " +fieldName;
		Logger.log("SENDING NOTATION: "+notation);
		Logger.log(" IS IT A SPECTATOR?" + viewModel.setSpectator());

		viewModel.sendNotation(notation);

	}

	public void updatePieces(String notation){
		System.out.println("UPDATING PIECES...........");

		piecesPane.getChildren().remove(0,piecesPane.getChildren().size());




		ArrayList<Piece> pieces = FENParser.createPieces(notation);
		for(Piece p : pieces){


			File file = new File(p.getSrc());
			Image image = new Image(file.toURI().toString());
			ImageView imageView = new ImageView(image);

			imageView.setFitWidth(40);
			imageView.setFitHeight(40);

			imageView.setLayoutX(p.getX());
			imageView.setLayoutY(p.getY());

			piecesPane.getChildren().add(imageView);


			if (viewModel.setSpectator()==false)
			new DraggableMaker().makeDraggable(imageView,piecesPane,this);
			else Logger.log("Cant drag for sure???");

		}
	}
}
