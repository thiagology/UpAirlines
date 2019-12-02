package projetoUp.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TelaLoginController {

    @FXML
    private TextField txLogin;
    
    @FXML
    private ImageView imgUP;

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

    	if (msgErro.length() == 0) {
    		if(txLogin.getText().equals("Gerente") &&
    		   txSenha.getText().equals("senha")) {
    			
    			try {
    		    	Stage s1 = new Stage();
    		        Parent root;
    				root = FXMLLoader.load(getClass().getResource("TelaGerente.fxml"));
    		        Scene scene = new Scene(root);

    		        s1.setScene(scene);
    		        s1.show();
    		        
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}
    		else {
    			try {
    		    	Stage s1 = new Stage();
    		        Parent root;
    				root = FXMLLoader.load(getClass().getResource("TelaCliente.fxml"));
    		        Scene scene = new Scene(root);

    		        s1.setScene(scene);
    		        s1.show();
    		        
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
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
