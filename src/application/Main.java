/*
 * Dustin Cheung
 * Dice Roller Program: Utilizing JavaFx to create a clean GUI that allows a user to simulate rolls with different number of dies 
 * and dies of different number of sides.  The output returns the number rolled for each die and the sum of all rolls.
 */
package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

/*
 * opens up home GUI and makes stage fixed size
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Dice Roller Application");
			primaryStage.setResizable(false);
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/home.fxml"));
			GridPane root = (GridPane)loader.load();
			Scene scene = new Scene(root,400,600);
			
	        primaryStage.setScene(scene);
	        primaryStage.show();
	        
	        primaryStage.setOnCloseRequest(e -> {
	        	System.exit(0);
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
