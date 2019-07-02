package ch.wiss.javafx.bmi;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BmiController {
	
	@FXML
	private TextField size, weight;
	
	@FXML
	private Label result;
	
	public void calculate() {
		try {
			Double bmi = Double.parseDouble(weight.getText()) / Math.pow(Double.parseDouble(size.getText()),2);
			String message = (bmi < 20)?"Untergewicht":(bmi > 25)?"Übergewicht":"Normalgewicht";
			result.setText(String.format("%.2f", bmi)+": "+message);
		}catch(Exception e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Ungültige Werte");
			alert.setContentText("Bitte geben Sie gültige Zahlenwerte ein!");
			alert.show();
		}
	}
	

}
