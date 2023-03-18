package viewmodel_client;

import model_client.ModelClient;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CreateGameRoomViewModel implements PropertyChangeListener, ViewModel {

	private ViewState viewState;


	private ModelClient modelClient;

	public CreateGameRoomViewModel(ModelClient model, ViewState viewState) {

	}

	public String create() {
		return null;
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
