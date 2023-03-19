import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.File;

public class TestMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create an ImageView object
        File file = new File("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png");
        Image image = new Image(file.toURI().toString());
        ImageView imageView = new ImageView(image);
        new ImageView();
        // Set the width and height of the ImageView
        imageView.setFitWidth(40);
        imageView.setFitHeight(40);

        imageView.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 2;");

        System.out.println(

            imageView.getStyle()
        );
        // Create a Pane object and add the ImageView to it
        Pane pane = new Pane();
        pane.getChildren().add(imageView);

        // Create a Scene object with the Pane and set its size
        Scene scene = new Scene(pane, 200, 200);

        // Set the title of the window and show it
        primaryStage.setTitle("Image Viewer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}