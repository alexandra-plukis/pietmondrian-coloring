
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class DriverPiet extends Application {
	
	public void start(Stage stage)
	{
		PietTHAT gui = new PietTHAT();
		StackPane rootPane = new StackPane();
		
		rootPane.getChildren().addAll(gui);
		
		Scene scene = new Scene(rootPane, 450, 775); //height is 590 px width is 560 px, we want
		stage.setTitle("Color Me Piet!"); 			//space for an error message and the color choices
		stage.setResizable(false);					//plus the clear button
		stage.setScene(scene); // Place the scene in the stage
		stage.show(); // Display the stage
		
	}
	public static void main(String[] args)
	   {
	      Application.launch(args);
	   }
}
