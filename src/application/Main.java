package application;
	
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
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
