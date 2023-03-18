package viewmodel_client

-client;

import model-client.ModelClient;
import mediator-server.String;

public class CreateGameRoomViewModel implements java::beans::PropertyChangeListener, ViewModel {

	private ViewState viewState;

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
