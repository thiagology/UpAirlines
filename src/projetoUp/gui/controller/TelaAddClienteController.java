package projetoUp.gui.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaAddClienteController {

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCPF;

    @FXML
    private TextField txtRG;

    @FXML
    private TextField txtTelefone;

    @FXML
    private TextField txtEndereco;

    @FXML
    private DatePicker dtPNascimento;

    @FXML
    private Button btSalvar;

    @FXML
    private Button btCancelar;

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtSenha;

    @FXML
    void onClickCancelar(ActionEvent event) {
    	((Stage) this.btCancelar.getScene().getWindow()).close();
    	this.limparCampos();
    }
    
    public void limparCampos() {
        this.txtLogin.setText("");
        this.txtSenha.setText("");        
        this.txtEndereco.setText("");
        this.txtTelefone.setText("");        
        this.txtRG.setText("");
        this.txtCPF.setText("");
        this.txtNome.setText("");
        
        this.dtPNascimento.setValue(null);
		
	}

    @FXML
    void onClickSalvar(ActionEvent event) {

    }
    

}
