import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

//import calctest.Runner;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import views.CalcController;

@ExtendWith(ApplicationExtension.class)
class calcTest {

	@Start
	private void start(Stage stage)
	{
		FXMLLoader loader= new FXMLLoader();
		loader.setLocation(Runner.class.getResource("views/Calculator.fxml"));
		
		BorderPane view;
		try {
			view = loader.load();
			CalcController cont= loader.getController();
			
			Scene S= new Scene(view);
			stage.setScene(S);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testAdd1(FxRobot robot) {
		robot.clickOn("#num1");
		robot.write("10.0");
		
		robot.clickOn("#num2");
		robot.write("2.5");
		
		robot.clickOn("#button");
		
		Assertions.assertThat(robot.lookup("#sumtext").queryAs(Text.class)).hasText("12.5");
	}
	
	@Test
	public void testAdd2(FxRobot robot) {
		robot.clickOn("#num1");
		robot.write("12");
		
		robot.clickOn("#num2");
		robot.write("2.5");
		
		robot.clickOn("#button");
		
		Assertions.assertThat(robot.lookup("#sumtext").queryAs(Text.class)).hasText("14.5");
		
		robot.clickOn("#num1");
		robot.write("2");
		
		robot.clickOn("#button");
		
		Assertions.assertThat(robot.lookup("#sumtext").queryAs(Text.class)).hasText("4.5");
	}
	
	@Test
	public void testAddInvalid(FxRobot robot) {
		robot.clickOn("#button");
		Assertions.assertThat(robot.lookup("#sumtext").queryAs(Text.class)).hasText("null");
		
		robot.clickOn("#num1");
		robot.clickOn("#button");
		
		Assertions.assertThat(robot.lookup("#sumtext").queryAs(Text.class)).hasText("null");
		
		robot.clickOn("#num1");
		robot.clickOn("#num2");
		robot.clickOn("#button");
		
		Assertions.assertThat(robot.lookup("#sumtext").queryAs(Text.class)).hasText("null");
	}

}
