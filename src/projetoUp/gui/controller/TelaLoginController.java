package projetoUp.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    	//IMPLEMENTAR:
    	//se o login existe
    	//se é o gerente ou um cliente
    	//definir telas especificas
    	
    }
}
