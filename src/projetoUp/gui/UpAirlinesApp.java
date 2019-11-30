package projetoUp.gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import projetoUp.gui.controller.TelaGerenteController;


public class UpAirlinesApp extends Application{
	private Stage primaryStage;
	private BorderPane rootScene;
	
    @Override
    public void start(Stage stage) {
		    	this.primaryStage = stage;
				this.primaryStage.setTitle("UP Airlines - United Programmers Airlines ");
				this.rootScene = new BorderPane();
				
				Scene scene = new Scene(rootScene, 597, 396);
		        stage.setScene(scene);
		        stage.show(); 
				
				try {
			        FXMLLoader loader = new FXMLLoader();
			        loader.setLocation(UpAirlinesApp.class.getResource("view/TelaGerente.fxml"));
			       
			        AnchorPane gerenteView = (AnchorPane) loader.load();
 
			        this.rootScene.setCenter(gerenteView);
			        
			        TelaGerenteController gerenteController = loader.getController();
			        gerenteController.setUpApp(this);
			        
				} catch (IOException e) {
					e.printStackTrace();
				}
  
    }
    
	public Stage getPrimaryStage() {
		return primaryStage;
	}
 
	public static void main(String[] args) {
		UpAirlinesApp.launch(args);

	}

}
