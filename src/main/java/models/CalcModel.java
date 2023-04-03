package models;
import javafx.beans.property.*;

public class CalcModel {
	DoubleProperty num1= new SimpleDoubleProperty();
	DoubleProperty num2= new SimpleDoubleProperty();
	DoubleProperty sum= new SimpleDoubleProperty();
	
	public DoubleProperty sums(DoubleProperty num1, DoubleProperty num2) {
		
		sum.set( num1.get()+num2.get());
		
		return sum;
	}
}
