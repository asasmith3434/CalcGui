package views;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import models.CalcModel;

public class CalcController {

	CalcModel model;
	
	void setModel(CalcModel newmod) {
		model= newmod;
	}
	
	@FXML
	private TextField num1;

	@FXML
	private TextField num2;
	
    @FXML
    private Text sumtext;

    @FXML
    void sumall(ActionEvent event) {
    	DoubleProperty first = new SimpleDoubleProperty();
    	DoubleProperty second = new SimpleDoubleProperty();
    	
    	setModel(new CalcModel());
    	
    	first.set(Double.parseDouble(num1.getText()));
    	second.set(Double.parseDouble(num2.getText()));
    	
    	DoubleProperty output= model.sums(first, second);
    	
    	String sum = Double.toString(output.doubleValue());
    	
    	sumtext.setText(sum);
    }

}
