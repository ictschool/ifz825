package ch.wiss.javafx.bmi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Starter extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(Starter.class.getResource("bmi-ui.fxml"));
		
		loader.setController(new BmiController());
		
		Parent parent = loader.load();
		Scene scene = new Scene(parent);
		
		primaryStage.setTitle("BMI-Rechner");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
