package viewmodel_client;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import model_client.ModelClient;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoginViewModel implements PropertyChangeListener, ViewModel {

	@FXML private StringProperty portPropert;

	@FXML private StringProperty hostProperty;

	@FXML private StringProperty errorProperty;

	private ViewState viewState;

	private ModelClient modelClient;



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
