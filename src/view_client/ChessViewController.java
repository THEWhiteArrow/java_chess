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
	@FXML private Pane mainPane;
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


	public void updatePieces(String notation){
		System.out.println("UPDATING PIECES...........");

		for(Node node : piecesPane.getChildren()){
//			node.setOpacity(0);
//			node.setDisable(true);
			System.out.println( ((ImageView)(node)).getImage().getUrl() );
		}


//		IMPORTANT
//		need to reference the out folder from here
		File file = new File("@../images/black/R.png");
		Image image = new Image(file.toURI().toString());
		System.out.println(image.getUrl());


		ArrayList<Piece> pieces = FENParser.createPieces(notation);
		for(Piece p : pieces){


//			File file = new File("images/black/R.png");
//			Image image = new Image(file.toURI().toString());
//			ImageView imageView = new ImageView(image);
//
//			imageView.setFitWidth(40);
//			imageView.setFitHeight(40);


//			imageView.setX(p.getX());
//			imageView.setY(p.getY());

//			mainPane.getChildren().add((Node)imageView);

		}
	}
}
