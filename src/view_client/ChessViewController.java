package view_client;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import viewmodel_client.ChessViewModel;
import javafx.scene.input.*;
import javafx.event.EventHandler;

import java.lang.ref.WeakReference;

public class ChessViewController  {

	protected Region root;
	private double orgSceneX, orgSceneY;
	private double orgTranslateX, orgTranslateY;

	private ViewHandler viewHandler;

	protected ChessViewModel viewModel;

	@FXML private ImageView queen;



	public void init(ViewHandler viewHandler, ChessViewModel viewModel, Region root){
		this.viewHandler=viewHandler;
		this.viewModel=viewModel;
		this.root=root;
		this.orgSceneX = 0;
		this.orgSceneY= 0;
		this.orgTranslateX =0;
		this.orgTranslateY=0;

		makeDraggable(queen);







	}



	public Region getRoot(){
		return root;
	}


	public void reset() {

	}

	private void makeDraggable(ImageView imageView)
	{



		imageView.setOnMousePressed(new EventHandler<MouseEvent>()
		{
			AnchorPane targetPane = null;

			@Override public void handle(MouseEvent event)
			{
				// Store the initial coordinates of the mouse click
				orgSceneX = event.getSceneX();
				orgSceneY = event.getSceneY();
				orgTranslateX = imageView.getTranslateX();
				orgTranslateY = imageView.getTranslateY();

				targetPane.setPrefSize(200, 200);
				targetPane.setLayoutX(event.getSceneX());
				targetPane.setLayoutY(event.getSceneY());

			}
		});

		imageView.setOnMouseDragged(new EventHandler<MouseEvent>()
		{
			@Override public void handle(MouseEvent event)
			{
				// Calculate the new position of the ImageView
				double offsetX = event.getSceneX() - orgSceneX;
				double offsetY = event.getSceneY() - orgSceneY;
				double newTranslateX = orgTranslateX + offsetX;
				double newTranslateY = orgTranslateY + offsetY;

				// Set the new position of the ImageView
				imageView.setTranslateX(newTranslateX);
				imageView.setTranslateY(newTranslateY);
			}
		});


		AnchorPane anchorPane = new AnchorPane();


		// Set the event handler for mouse release events on the ImageView
		imageView.setOnMouseReleased(new EventHandler<MouseEvent>()
		{
			@Override public void handle(MouseEvent event)
			{
				AnchorPane targetPane = new AnchorPane();
				targetPane.setPrefSize(200, 200);
				targetPane.setLayoutX(event.getSceneX());
				targetPane.setLayoutY(event.getSceneY());
				anchorPane.getChildren().add(targetPane);


				// Check if the ImageView is within the bounds of the target AnchorPane
				if (event.getSceneX() > targetPane.getLayoutX() && event.getSceneX()
						< targetPane.getLayoutX() + targetPane.getPrefWidth()
						&& event.getSceneY() > targetPane.getLayoutY() && event.getSceneY()
						< targetPane.getLayoutY() + targetPane.getPrefHeight())
				{
					// Remove the ImageView from the root AnchorPane
					targetPane.getChildren().remove(imageView);

					// Add the ImageView to the target AnchorPane
					anchorPane.getChildren().add(imageView);

					// Set the position of the ImageView relative to the target AnchorPane
					imageView.setLayoutX(event.getSceneX() - targetPane.getLayoutX());
					imageView.setLayoutY(event.getSceneY() - targetPane.getLayoutY());
				}
				else
				{
					// If the ImageView is not within the bounds of the target AnchorPane, return it to its original position
					imageView.setTranslateX(orgTranslateX);
					imageView.setTranslateY(orgTranslateY);
				}
			}

		});
	}



}
