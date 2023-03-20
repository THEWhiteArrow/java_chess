package viewmodel_client;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model_client.ModelClient;

public class MenuViewModel extends ViewModel{

    private StringProperty roomIdProperty;
    private ModelClient model;
    private ViewState viewState;

    public MenuViewModel(ModelClient model , ViewState viewState){
        this.model = model;
        this.viewState = viewState;
        roomIdProperty = new SimpleStringProperty();

    }

    public boolean joinRoom(){
        return false;
    }

    public boolean createRoom(){
        return model.createGameRoom(roomIdProperty.get());
    }


    public StringProperty getRoomIdProperty(){
        return roomIdProperty;
    }

    @Override
    public void clear() {
        roomIdProperty.set("");
    }


}
