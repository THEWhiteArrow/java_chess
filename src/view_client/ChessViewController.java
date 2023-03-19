package view_client;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import util.DraggableMaker;
import util.FENParser;
import util.Piece;
import viewmodel_client.ChessViewModel;

import java.io.File;
import java.util.ArrayList;


public class ChessViewController  {
	@FXML private Pane piecesPane;

	protected Region root;

	protected ViewHandler viewHandler;

	protected ChessViewModel viewModel;



	public void init(ViewHandler viewHandler, ChessViewModel viewModel, Region root){
		this.viewHandler=viewHandler;
		this.viewModel=viewModel;
		this.root=root;



		viewModel.getNotationProperty().addListener((obs,oldValue,newValue)->{
			String notation = (String)newValue;
			System.out.println(notation);

			updatePieces(notation);

		});
		reset();
	}

	public Region getRoot(){
		return root;
	}


	public void reset() {
		viewModel.clear();
	}

	public void sendNotation(String fieldName){
		String notation = FENParser.calculateFen( piecesPane.getChildren() ) +" " +fieldName;
		System.out.println(notation);
		viewModel.sendNotation(notation);
	}

	public void updatePieces(String notation){
		System.out.println("UPDATING PIECES...........");

		piecesPane.getChildren().remove(0,32);




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

			new DraggableMaker().makeDraggable(imageView,piecesPane,this);

		}
	}
}
