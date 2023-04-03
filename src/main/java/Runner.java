import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import views.CalcController;

public class Runner extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader= new FXMLLoader();
		loader.setLocation(Runner.class.getResource("views/Calculator.fxml"));
		
		BorderPane view= loader.load();
		
		CalcController cont= loader.getController();
		
		Scene S= new Scene(view);
		stage.setScene(S);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
