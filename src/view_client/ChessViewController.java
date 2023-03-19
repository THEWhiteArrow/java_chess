package view_client;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import util.DraggableMaker;
import viewmodel_client.ChessViewModel;



public class ChessViewController  {
	@FXML private GridPane grid;
	@FXML private ImageView q1;
	protected Region root;

	protected ViewHandler viewHandler;

	protected ChessViewModel viewModel;



	public void init(ViewHandler viewHandler, ChessViewModel viewModel, Region root){
		this.viewHandler=viewHandler;
		this.viewModel=viewModel;
		this.root=root;

		new DraggableMaker().makeDraggable(this.q1,this.grid);
	}

	public Region getRoot(){
		return root;
	}


	public void reset() {

	}

}
