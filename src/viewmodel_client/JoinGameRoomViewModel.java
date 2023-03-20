package viewmodel_client;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import model_client.ModelClient;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class JoinGameRoomViewModel extends ViewModel implements PropertyChangeListener {

	@FXML private StringProperty idProperty;

	@FXML private StringProperty errorProperty;

	private ViewState viewState;


	private ModelClient modelClient;

	public JoinGameRoomViewModel(ModelClient model, ViewState viewState) {

	}

	public void join() {

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
