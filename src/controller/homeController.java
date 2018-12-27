/*
 * Dustin Cheung
 * Dice Roller Program: Utilizing JavaFx to create a clean GUI that allows a user to simulate rolls with different number of dies 
 * and dies of different number of sides.  The output returns the number rolled for each die and the sum of all rolls.
 */
package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;


public class homeController {
	
	@FXML TextField numDiceField;
	@FXML TextField numSidesField;
	@FXML Label resultLabel;
	@FXML Button rollButton;
	
	/*
	 *  Action method when roll button is clicked
	 */
	public void rollAction(ActionEvent event) throws IOException {
		int total = 0;
		
		resultLabel.setText(""); //clears label field
		
		//error handling
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
		
		//roll simulation using loop and random number 
		for(int i = 0; i < numDice; i++){
			int rollResult = (int)(numSides * Math.random()) + 1;
			total += rollResult;
			resultLabel.setText(resultLabel.getText() + "Roll " + (i+1) + " with a " + numSides + " sided die: " + rollResult+"\n");
		}
		
		resultLabel.setText(resultLabel.getText() + "Total of all rolls: " + total + "\n");
		
	}
}
