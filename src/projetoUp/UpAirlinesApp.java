package projetoUp;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import projetoUp.gui.TelaMainController;

public class UpAirlinesApp extends Application{
	private Stage primaryStage;
	
    @Override
    public void start(Stage stage) {
    	this.primaryStage = stage;
		this.primaryStage.setTitle("Sistema Bancario");
		
        Pane mainPane = null;
		try {
			mainPane = (Pane) FXMLLoader.load(TelaMainController.class.getResource("TelaAddVoo.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        Scene scene = new Scene(mainPane);
        
        stage.setScene(scene);
        stage.show();
        
    }
    
	public Stage getPrimaryStage() {
		return primaryStage;
	}
 
	public static void main(String[] args) {
		UpAirlinesApp.launch(args);

	}

}