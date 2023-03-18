package view_client

-client;

import viewmodel-client.ViewModel;

public interface ViewController {

	private Region region;

	private ViewHandler viewHandler;

	private ViewModel viewModel;

	private ViewHandler viewHandler;

	public abstract void init(ViewHandler viewHandler, ViewModel viewModel, Region root);

	public abstract Region getRoot();

	public abstract void reset();

}
