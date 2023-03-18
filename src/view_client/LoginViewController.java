package view_client

-client;

import viewmodel-client.ViewModel;

public class LoginViewController implements ViewController, ViewController {

	private TextField hostField;

	private TextField portField;

	private void login() {

	}


	/**
	 * @see view-client.ViewController#init(view-client.ViewHandler, viewmodel-client.ViewModel, view-client.Region)
	 *  
	 */
	public void init(ViewHandler viewHandler, ViewModel viewModel, Region root) {

	}


	/**
	 * @see view-client.ViewController#getRoot()
	 */
	public Region getRoot() {
		return null;
	}


	/**
	 * @see view-client.ViewController#reset()
	 *  
	 */
	public void reset() {

	}

}
