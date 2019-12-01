package projetoUp.gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class UpAirlinesApp extends Application{

	
    @Override
    public void start(Stage primaryStage) throws IOException {
		    	
				primaryStage.setTitle("UP Airlines - United Programmers Airlines ");
				
				Pane rootScene = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));
				
				Scene scene = new Scene(rootScene, 597, 396);
				primaryStage.setScene(scene);
				primaryStage.show(); 
				

  
    }
    
 
	public static void main(String[] args) {
		UpAirlinesApp.launch(args);

	}

}
