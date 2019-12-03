package projetoUp.gui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import projetoUp.exceptions.JaExisteException;
import projetoUp.exceptions.NaoExisteException;
import projetoUp.model.Cliente;
import projetoUp.negocio.Fachada;

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
    
    private Fachada fachada = Fachada.getInstance();

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
    	String msgErro = "";
    	
    	if(txtCPF.getText() == null ||
    	   txtEndereco.getText() == null ||
    	   txtLogin.getText() == null||
    	   txtNome.getText() == null ||
    	   txtRG.getText() == null ||
    	   txtSenha.getText() == null ||
    	   txtTelefone.getText() == null ||
    	   dtPNascimento.getValue() == null) {
    		msgErro = "Preencha todos os campos.";
    	}
    	if(msgErro.length() == 0) {
    		Cliente c = new Cliente(txtNome.getText(),
    					txtCPF.getText(),
    					txtRG.getText(),
    					Integer.parseInt(txtTelefone.getText()),
    					txtEndereco.getText(),
    					dtPNascimento.getValue(),
    					txtLogin.getText(),
    					txtSenha.getText());
    		
    		try {
				fachada.criarConta(c);
			} catch (JaExisteException e) {
	            Alert alert = new Alert(AlertType.ERROR);
	            alert.setTitle("Erro");
	            alert.setHeaderText("Esta conta já existe.");
	            alert.setContentText("");

	            alert.showAndWait();
				
			} catch (NaoExisteException e) {
	            Alert alert = new Alert(AlertType.ERROR);
	            alert.setTitle("Erro");
	            alert.setHeaderText("Esta conta não existe.");
	            alert.setContentText("");

	            alert.showAndWait();
			} catch (NullPointerException e) {
	            Alert alert = new Alert(AlertType.ERROR);
	            alert.setHeaderText("");
	            alert.setTitle("Erro");
	            alert.setContentText("Não foi possível cadastrar cliente.");
	            alert.show();
			} catch (Exception e) {
				e.printStackTrace();
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
