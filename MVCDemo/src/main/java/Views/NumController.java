package Views;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import models.numberModel;

public class NumController {

    @FXML
    private Button addButton;

    @FXML
    private TextField inputBox;

    @FXML
    private Label numLabel;

    numberModel model = new numberModel();
    StringConverter<Number> fmt = new NumberStringConverter();
    
    public void setModel(numberModel model) {
    	this.model = model;
    	
    	// Bind sum to label
    	Bindings.bindBidirectional(numLabel.textProperty(), model.getSum(), fmt);
    	
    }
    
    @FXML
    void onAddClicked(ActionEvent event) {
    	System.out.println("Click button");
    	
    	model.addToSum(getAdded());

    	inputBox.textProperty().set("");
    }
    
    private int getAdded() {
    	String val = inputBox.textProperty().get();
    	int amount = 0;
    	
    	try {
    		amount = Integer.parseInt(val);
    	}catch(NumberFormatException e) {
    		
    	}
    	
    	return amount;
    }

}

