package Views;

import java.io.IOException;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import DemoApp.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.numberModel;

@ExtendWith(ApplicationExtension.class)
public class TestNumView {

	@Start
	private void start(Stage stage) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Controller.class.getResource("../Views/numberadder.fxml"));
		
		try {
			BorderPane view = loader.load();
			NumController controller = loader.getController();
			numberModel model = new numberModel();
			controller.setModel(model);
			
			Scene scene = new Scene(view);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void test(FxRobot robot) {
		
		checkPlus(robot);
		
		testAdd(robot, "-10", "-10");
		testAdd(robot, "20", "10");
		testAdd(robot, "11", "21");
		testAdd(robot, "50", "71");
		
		checkPlus(robot);
		
	}
	
	public void testAdd(FxRobot robot, String amount, String sum) {
		enterInput(robot, amount);
		testButton(robot);
		checkSum(robot, sum);
		checkEmpty(robot);
	}
	
	public void enterInput(FxRobot robot, String amount) {
		
		try {
			Thread.sleep(100);
			robot.clickOn("#inputText");
			Thread.sleep(100);
			robot.write(amount);
			Thread.sleep(100);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	

	public void testButton(FxRobot robot) {
		try {
			Thread.sleep(100);
			robot.clickOn("#addButton");
			Thread.sleep(100);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void checkSum(FxRobot robot, String sum) {
		Assertions.assertThat(robot.lookup("#sumLabel").queryAs(Label.class)).hasText(sum);
	}
	
	public void checkEmpty(FxRobot robot) {
		Assertions.assertThat(robot.lookup("#inputText").queryAs(TextField.class)).hasText("");
	}
	
	public void checkPlus(FxRobot robot) {
		Assertions.assertThat(robot.lookup("#plusLabel").queryAs(Label.class)).hasText("+");
	}
}
