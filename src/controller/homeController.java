package controller;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class homeController {
	
	@FXML TextField numDiceField;
	@FXML TextField numSidesField;
	@FXML Label resultLabel;
	@FXML Button rollButton;
	
	/*
	 *  Action method when roll button is clicked
	 */
	public void rollAction(ActionEvent event) throws IOException {
		
		if(numDiceField.getText().trim().equals("") || numSidesField.getText().trim().equals("")){
			Alert alert = new Alert(AlertType.ERROR, "Both fields must be filled", ButtonType.OK);
			alert.showAndWait();

			if (alert.getResult() == ButtonType.OK) {
			    return;
			}
		}
		
		int numDice = Integer.parseInt(numDiceField.getText().trim());
		int numSides = Integer.parseInt(numSidesField.getText().trim());
		
		if(numDice < 1 || numDice > 100){
			Alert alert = new Alert(AlertType.ERROR, "The number of dies must be between 1 and 100 inclusive", ButtonType.OK);
			alert.showAndWait();

			if (alert.getResult() == ButtonType.OK) {
				numDiceField.clear();
				numSidesField.clear();
			    return;
			}	
		}
		
		if(numSides < 2 || numSides > 100){
			Alert alert = new Alert(AlertType.ERROR, "The number of sides on the dice must be between 2 and 100 inclusive", ButtonType.OK);
			alert.showAndWait();

			if (alert.getResult() == ButtonType.OK) {
				numDiceField.clear();
				numSidesField.clear();
			    return;
			}	
		}
	}
}
