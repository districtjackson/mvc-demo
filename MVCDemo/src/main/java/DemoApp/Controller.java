package DemoApp;

import com.sun.tools.javac.Main;

import Views.NumController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import models.numberModel;

public class Controller extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Controller.class.getResource("../Views/numberadder.fxml"));
		
		BorderPane view = loader.load();
		NumController controller = loader.getController();
		numberModel model = new numberModel();
		controller.setModel(model);
		
		Scene scene = new Scene(view);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
