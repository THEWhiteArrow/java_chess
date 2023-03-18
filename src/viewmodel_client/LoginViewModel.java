package viewmodel_client

-client;

import model-client.ModelClient;

public class LoginViewModel implements java::beans::PropertyChangeListener, ViewModel {

	private StringProperty portPropert;

	private StringProperty hostProperty;

	private StringProperty errorProperty;

	private ViewState viewState;

	private ModelClient modelClient;

	private ViewState viewState;

	private ModelClient modelClient;

	private java::beans::PropertyChangeListener java::beans::PropertyChangeListener;

	public LoginViewModel(ModelClient model, ViewState viewState) {

	}

	public boolean login() {
		return false;
	}

	public void clear() {

	}


	/**
	 * @see java::beans::PropertyChangeListener#propertyChange(PropertyChangeEvent)
	 *  
	 */
	public void propertyChange(PropertyChangeEvent evt) {

	}

}
