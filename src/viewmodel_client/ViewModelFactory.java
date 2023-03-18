package viewmodel_client;


import model_client.ModelClient;

public class ViewModelFactory {

	private ViewModel createGameRoomViewModel;

	private ViewModel joinGameRoomViewModel;

	private ViewModel loginViewModel;
	private ViewModel chessViewModel;

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

	public ViewModel getChessViewModel() {
		return chessViewModel;
	}

}
