package view_client;

import javafx.scene.layout.Region;
import viewmodel_client.ChessViewModel;

public class ChessViewController  {

	protected Region root;

	protected ViewHandler viewHandler;

	protected ChessViewModel viewModel;



	public void init(ViewHandler viewHandler, ChessViewModel viewModel, Region root){
		this.viewHandler=viewHandler;
		this.viewModel=viewModel;
		this.root=root;
	}

	public Region getRoot(){
		return root;
	}


	public void reset() {

	}

}
