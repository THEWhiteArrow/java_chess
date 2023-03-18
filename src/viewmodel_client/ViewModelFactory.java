package viewmodel_client;


import model_client.ModelClient;
import view_client.ChessViewController;

public class ViewModelFactory {

	private ViewModel createGameRoomViewModel;

	private ViewModel joinGameRoomViewModel;

	private ViewModel loginViewModel;
	private ChessViewModel chessViewModel;

	private ViewState viewState;






	public ViewModelFactory(ModelClient model) {
		this.viewState = new ViewState();
		this.chessViewModel = new ChessViewModel(model, viewState);
	}

	public ViewModel getLoginViewModel() {
		return loginViewModel;
	}

	public ViewModel getJoinGameRoomViewModel() {
		return joinGameRoomViewModel;
	}

	public ViewModel getCreateGameRoomViewModel() {
		return createGameRoomViewModel;
	}

	public ChessViewModel getChessViewModel() {
		return chessViewModel;
	}

}
