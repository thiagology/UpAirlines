package projetoUp.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import projetoUp.negocio.Fachada;

public class TelaLoginController {

    @FXML
    private TextField txLogin;

    @FXML
    private Button btLogin;

    @FXML
    private Button btConta;

    @FXML
    private PasswordField txSenha;

    @FXML
    void onClickCriarConta(ActionEvent event) {
        Stage dialog = new Stage();

        dialog.setScene(ScreenManager.getInstance().getAddClienteScene());
        dialog.setResizable(false);
        dialog.setTitle("Criar Conta");
        dialog.initOwner(((Node) event.getSource()).getScene().getWindow());
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.showAndWait();
    }

    @FXML
    void onClickLogin(ActionEvent event) {
    	String msgErro = "";
		if(txLogin.getText() == null ||
			txSenha.getText() == null) {
			msgErro = "Login ou senha inválidos";
		}
		boolean isLog = Fachada.getInstance().fazerLogin(txLogin.getText(),
														 txSenha.getText());
    	if(isLog == false) {
    		msgErro = "Usuário inexistente";
    	}
    	if (msgErro.length() == 0) {
    		Stage dialog = new Stage();
    		if(txLogin.getText() == "Gerente" &&
    		   txSenha.getText() == "senha") {
    			
    	        dialog.setScene(ScreenManager.getInstance().getGerenteScene());
    	        dialog.setResizable(false);
    	        dialog.setTitle("Criar Conta");
    	        dialog.initOwner(((Node) event.getSource()).getScene().getWindow());
    	        dialog.initModality(Modality.APPLICATION_MODAL);
    	        dialog.showAndWait();
    		}
    		else {
    	        dialog.setScene(ScreenManager.getInstance().getClienteScene());
    	        dialog.setResizable(false);
    	        dialog.setTitle("Criar Conta");
    	        dialog.initOwner(((Node) event.getSource()).getScene().getWindow());
    	        dialog.initModality(Modality.APPLICATION_MODAL);
    	        dialog.showAndWait();
    		}
    		
    	}else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(msgErro);
            alert.setContentText("");

            alert.showAndWait();
        }
    	
    }
}
