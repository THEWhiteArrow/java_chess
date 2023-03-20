package viewmodel_client;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import model_client.ModelClient;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoginViewModel extends ViewModel implements PropertyChangeListener {

	private StringProperty hostProperty;
	private IntegerProperty portProperty;


	private StringProperty errorProperty;

	private ViewState viewState;

	private ModelClient model;



	public LoginViewModel(ModelClient model, ViewState viewState) {
		this.model=model;
		this.viewState=viewState;
		hostProperty = new SimpleStringProperty();
		portProperty = new SimpleIntegerProperty();
		errorProperty = new SimpleStringProperty();
	}

	public boolean connect() {
		String host = hostProperty.get();
		int port = portProperty.get();

		return model.connectToServer(host,port);

	}

	public void clear() {
		hostProperty.set("");
		portProperty.set(0);
		errorProperty.set("");
	}


	public IntegerProperty getPortProperty() {
		return portProperty;
	}



	public StringProperty getHostProperty() {
		return hostProperty;
	}



	public StringProperty getErrorProperty() {
		return errorProperty;
	}

	/**
	 * @see java::beans::PropertyChangeListener#propertyChange(PropertyChangeEvent)
	 *  
	 */
	public void propertyChange(PropertyChangeEvent evt) {

	}

}
