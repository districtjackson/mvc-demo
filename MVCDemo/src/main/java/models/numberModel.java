package models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class numberModel {
	private IntegerProperty sum = new SimpleIntegerProperty();

	/**
	 * @return the sum
	 */
	public IntegerProperty getSum() {
		return sum;
	}
	
	public void addToSum(int added) {
		sum.set(sum.get() + added);
	}
}
