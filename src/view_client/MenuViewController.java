package view_client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewmodel_client.MenuViewModel;
import viewmodel_client.ViewModel;


public class MenuViewController extends ViewController {
    @FXML private TextField roomField;
    private MenuViewModel viewModel;


    public void init(ViewHandler viewHandler, ViewModel viewModel, Region root) {
        this.viewHandler=viewHandler;
        this.viewModel = (MenuViewModel) viewModel;
        this.root = root;

        roomField.textProperty().bindBidirectional(this.viewModel.getRoomIdProperty());
    }

    @Override
    public void reset() {
        viewModel.clear();
    }

    public void createRoom( ) {

        String room = viewModel.createRoom();
        if(room!=null && room.length()>0){
            viewHandler.openView("chess");
        }
    }

    public void joinRoom( ) {
        viewModel.joinRoom();
    }
}
