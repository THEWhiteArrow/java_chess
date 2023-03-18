package viewmodel_client

-client;

import model-client.ModelClient;

public class JoinGameRoomViewModel implements java::beans::PropertyChangeListener, ViewModel {

	private StringProperty idProperty;

	private StringProperty errorProperty;

	private ViewState viewState;

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
