package projetoUp.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TelaMainController extends Application {


    @Override
    public void start(Stage stage) throws Exception {

        Pane mainPane =(Pane) FXMLLoader.load(TelaMainController.class.getResource("TelaAddVoo.fxml"));
        
        Scene scene = new Scene(mainPane);
        
        stage.setScene(scene);
        stage.show();
    }
    

	public static void main(String[] args) {
		Application.launch(args);

	}

}
