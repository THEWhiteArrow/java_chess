package viewmodel_client;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import mediator_server.GamePackage;
import model_client.ModelClient;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class ChessViewModel extends ViewModel implements PropertyChangeListener  {

	private boolean isWhite = true;
	private final String FEN="rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
	private StringProperty notationProperty, chatProperty;

	private ViewState viewState;


	private ModelClient model;

	public ChessViewModel(ModelClient model, ViewState viewState) {
		this.model=model;
		this.viewState=viewState;
		this.notationProperty = new SimpleStringProperty();
		this.chatProperty = new SimpleStringProperty();
		this.model.addListener(this);
	}

	public void clear() {
		this.notationProperty.set(FEN);
	}

	public void sendNotation(String notation) {

		if( isWhite ) model.sendNotation(viewState.getRoomId(), notation);
		else {
			StringBuilder builder = new StringBuilder(notationProperty.get().split(" ")[0]);
			model.sendNotation(viewState.getRoomId(), String.valueOf(builder.reverse()));
		}

	}

	public void sendChatMessage(){
		model.sendChatMessage(viewState.getRoomId(),viewState.getName(),chatProperty.get());
	}

	public StringProperty getNotationProperty(){return notationProperty;}
	public StringProperty getChatProperty(){return chatProperty;}


	public void changeView(){
		isWhite = !isWhite;
		StringBuilder builder;
		if(notationProperty.get().contains(" ")){
			builder = new StringBuilder(notationProperty.get().split(" ")[0]);
		}else{
			builder = new StringBuilder(notationProperty.get());
		}
		notationProperty.set(String.valueOf(builder.reverse()));
	}
	/**
	 * @see java::beans::PropertyChangeListener#propertyChange(PropertyChangeEvent)
	 *  
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		String type = evt.getPropertyName();
		GamePackage pkg = (GamePackage) evt.getNewValue();

		switch(type){
			case GamePackage.ERROR:
//				no error property yet
				break;
			case GamePackage.NOTATION:
				if( isWhite) notationProperty.set(pkg.getNotation());
				else {
					StringBuilder builder = new StringBuilder(pkg.getNotation().split(" ")[0]);
					notationProperty.set(String.valueOf(builder.reverse()));
				}
				break;
		}
	}

}
