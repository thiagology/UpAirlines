package projetoUp.gui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ScreenManager  {
	private static ScreenManager instance;
    private Stage primaryStage;
    private Scene mainScene;  
    
    private Scene addClienteScene;
    private TelaAddClienteController telaAddClienteController;
    
    private Scene addVooScene;
    private TelaAddVooController telaAddVooController;
    
    private Scene clienteScene;
    private TelaClienteController telaClienteController;
    
    private Scene passagemScene;
    private TelaComprarPassagemController telaComprarPassagemController;
    
    private Scene gerenteScene;
    private TelaGerenteController telaGerenteController;
    
    private Scene loginScene;
    private TelaLoginController telaLoginController;
    
	
    public static ScreenManager getInstance() {
        if (instance == null) {
            instance = new ScreenManager();
        }
        return instance;
    }
    
    private ScreenManager() { 
        this.initialize(); 
    }

	private void initialize() {
    	try {
    	FXMLLoader fxmlLoader = new FXMLLoader();
    	GridPane addClientePane = fxmlLoader.load(getClass()
                .getResource("TelaAddClient.fxml").openStream());            
        this.addClienteScene = new Scene(addClientePane); 
        this.telaAddClienteController = (TelaAddClienteController) fxmlLoader.getController();
        
        fxmlLoader = new FXMLLoader();
    	GridPane addVooPane = fxmlLoader.load(getClass()
                .getResource("TelaAddVoo.fxml").openStream());            
        this.addVooScene = new Scene(addVooPane); 
        this.telaAddVooController = (TelaAddVooController) fxmlLoader.getController(); 
        
        fxmlLoader = new FXMLLoader();
    	GridPane comprarPassagemPane = fxmlLoader.load(getClass()
                .getResource("TelaComprarPassagem.fxml").openStream());            
        this.passagemScene = new Scene(comprarPassagemPane); 
        this.telaComprarPassagemController = (TelaComprarPassagemController) fxmlLoader.getController();
        
        fxmlLoader = new FXMLLoader();
    	AnchorPane clientePane = fxmlLoader.load(getClass()
                .getResource("TelaCliente.fxml").openStream());            
        this.clienteScene = new Scene(clientePane); 
        this.telaClienteController = (TelaClienteController) fxmlLoader.getController();
        
        fxmlLoader = new FXMLLoader();
    	AnchorPane gerentePane = fxmlLoader.load(getClass()
                .getResource("TelaGerente.fxml").openStream());            
        this.gerenteScene = new Scene(gerentePane); 
        this.telaGerenteController = (TelaGerenteController) fxmlLoader.getController();
        
        
        fxmlLoader = new FXMLLoader();
    	AnchorPane loginPane = fxmlLoader.load(getClass()
                .getResource("TelaLogin.fxml").openStream());            
        this.loginScene = new Scene(loginPane); 
        this.telaLoginController = (TelaLoginController) fxmlLoader.getController();
        
        
        
    	}catch(IOException e) {
            e.printStackTrace();
        }
    	
    	
    	
    }

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public Scene getMainScene() {
		return mainScene;
	}

	public Scene getAddClienteScene() {
		return addClienteScene;
	}

	public TelaAddClienteController getTelaAddClienteController() {
		return telaAddClienteController;
	}

	public Scene getAddVooScene() {
		return addVooScene;
	}

	public TelaAddVooController getTelaAddVooController() {
		return telaAddVooController;
	}

	public Scene getClienteScene() {
		return clienteScene;
	}

	public TelaClienteController getTelaClienteController() {
		return telaClienteController;
	}

	public Scene getPassagemScene() {
		return passagemScene;
	}

	public TelaComprarPassagemController getTelaComprarPassagemController() {
		return telaComprarPassagemController;
	}

	public Scene getGerenteScene() {
		return gerenteScene;
	}

	public TelaGerenteController getTelaGerenteController() {
		return telaGerenteController;
	}

	public Scene getLoginScene() {
		return loginScene;
	}

	public TelaLoginController getTelaLoginController() {
		return telaLoginController;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
   
    
    

}
