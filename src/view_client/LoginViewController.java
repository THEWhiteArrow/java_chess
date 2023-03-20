package view_client;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewmodel_client.ViewModel;


public class LoginViewController extends ViewController {

	@FXML private TextField hostField;

	@FXML private TextField portField;

	private void login() {

	}


	@Override
	public void init(ViewHandler viewHandler, ViewModel viewModel, Region root) {

	}

	/**
	 * @see view-client.ViewController#reset()
	 *  
	 */
	public void reset() {

	}

}
