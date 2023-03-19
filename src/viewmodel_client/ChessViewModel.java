package viewmodel_client;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model_client.ModelClient;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class ChessViewModel implements PropertyChangeListener {

	private final String FEN="rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
	private StringProperty notationProperty;

	private ViewState viewState;


	private ModelClient model;

	public ChessViewModel(ModelClient model, ViewState viewState) {
		this.model=model;
		this.viewState=viewState;
		this.notationProperty = new SimpleStringProperty();
	}

	public void clear() {
		this.notationProperty.set(FEN);
	}

	public void sendNotation(String notation) {

	}

	public StringProperty getNotationProperty(){return notationProperty;}


	/**
	 * @see java::beans::PropertyChangeListener#propertyChange(PropertyChangeEvent)
	 *  
	 */
	public void propertyChange(PropertyChangeEvent evt) {

	}

}
