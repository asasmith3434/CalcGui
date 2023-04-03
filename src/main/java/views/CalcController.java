



package views;



import javafx.beans.property.DoubleProperty;
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
    	DoubleProperty first= null;
    	DoubleProperty second= null;
    	
    	first.set(Integer.parseInt(num1.getText()));
    	second.set(Integer.parseInt(num2.getText()));
    	
    	DoubleProperty output= model.sums(first, second);
    	
    	sumtext.setText(output.toString());
    }

}
