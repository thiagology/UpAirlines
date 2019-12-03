package projetoUp.gui;


import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import projetoUp.model.Passagem;
import projetoUp.negocio.Fachada;

public class TelaClienteController {
	
    @FXML
    private ImageView imgFundo;
    
    @FXML
    private Button btRemoverConta;

    @FXML
    private Button btCriarPass;

    @FXML
    private Button btRemoverPass;

    @FXML
    private Button btAlterarPass;

    @FXML
    private Button btExibirPass;

    @FXML
    private Label lbBemVindo;
    
    @FXML
    private TextField txtExcluirPass;

    @FXML
    private TextField txtAlterarPass;

    @FXML
    private TextField txtExibirPass;
    
    @FXML
    private TextField txtNovoAssento;
    
    private Fachada fachada = Fachada.getInstance();
    

    @FXML
    void onClickAlterarPassagem(ActionEvent event) {
    	Passagem p = fachada.buscarPassagem(this.btAlterarPass.getText());
    	if(p != null) {
      		Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setHeaderText("");
            alert.setTitle("Alterar Passagem");
            alert.setContentText("Deseja alterar o assento da passagem a seguir?\n" + p);
            Optional<ButtonType> btnPressionado = alert.showAndWait();
            if (btnPressionado.isPresent()
                    && btnPressionado.get().equals(ButtonType.OK)) {
            	fachada.alterarPassagem(p, txtNovoAssento.getText());
            }
    		
    	}
    	else if(txtNovoAssento.getText() == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("");
            alert.setTitle("Erro");
            alert.setContentText("Informe um assento válido.");
            alert.show();
    	}
    	else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("");
            alert.setTitle("Erro");
            alert.setContentText("Não existe passagem com o código informado.");
            alert.show();
    	}
    }

    @FXML
    void onClickComprarPassagem(ActionEvent event) {

		try {
	    	Stage s1 = new Stage();
	        Parent root;
			root = FXMLLoader.load(getClass().getResource("TelaComprarPassagem.fxml"));
	        Scene scene = new Scene(root);

	        s1.setScene(scene);
	        s1.show();
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 

    }

    @FXML
    void onClickExcluirPassagem(ActionEvent event) {
    	Passagem p = fachada.buscarPassagem(this.txtExcluirPass.getText());
    	if(p != null) {
    		Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setHeaderText("");
            alert.setTitle("Excluir Passagem");
            alert.setContentText("Deseja excluir a passagem a seguir?\n" + p);
            Optional<ButtonType> btnPressionado = alert.showAndWait();
            if (btnPressionado.isPresent()
                    && btnPressionado.get().equals(ButtonType.OK)) {
            	fachada.excluirPassagem(p);
            }
    	}
    	else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("");
            alert.setTitle("Erro");
            alert.setContentText("Não existe passagem com o código informado.");
            alert.show();
    	}
    }

    @FXML
    void onClickExibirPassagem(ActionEvent event) {
    	Passagem p = fachada.buscarPassagem(this.btExibirPass.getText());
    	if(p != null) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("Código " + p.getCodigo() + 
            					"\n:Voo " + p.getVoo().getcodigoVoo() +
            					"\nPassageiro: " + p.getPassageiro().getNome() +
            					"\nPreço: " + p.getPreco() );
            alert.setTitle("Buscar Passagem");
            alert.setContentText("");
            alert.show();
    		
    	}
    	else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("");
            alert.setTitle("Erro");
            alert.setContentText("Não existe passagem com o código informado.");
            alert.show();
    	}
    }

    @FXML
    void onClickRemoverConta(ActionEvent event) {

    }
}
