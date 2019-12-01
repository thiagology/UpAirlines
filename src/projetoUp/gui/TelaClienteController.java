package projetoUp.gui;

import java.awt.TextField;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
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
    private Button btCheckin;

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
    

    @FXML
    void onClickAlterarPassagem(ActionEvent event) {
    	Passagem p = Fachada.getInstance().buscarPassagem(this.btExibirPass.getText());
    	if(p != null) {
      		Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setHeaderText("");
            alert.setTitle("Alterar Passagem");
            alert.setContentText("Deseja alterar o assento da passagem a seguir?\n" + p);
            Optional<ButtonType> btnPressionado = alert.showAndWait();
            if (btnPressionado.isPresent()
                    && btnPressionado.get().equals(ButtonType.OK)) {
                Fachada.getInstance().alterarPassagem(p, txtNovoAssento.getText());
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
    void onClickCheckin(ActionEvent event) {

    }

    @FXML
    void onClickComprarPassagem(ActionEvent event) {
        Stage dialog = new Stage();

        dialog.setScene(ScreenManager.getInstance().getPassagemScene());
        dialog.setResizable(false);
        dialog.setTitle("Comprar passagem");
        dialog.initOwner(((Node) event.getSource()).getScene().getWindow());
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.showAndWait();

    }

    @FXML
    void onClickExcluirPassagem(ActionEvent event) {
    	Passagem p = Fachada.getInstance().buscarPassagem(this.txtExcluirPass.getText());
    	if(p != null) {
    		Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setHeaderText("");
            alert.setTitle("Excluir Passagem");
            alert.setContentText("Deseja excluir a passagem a seguir?\n" + p);
            Optional<ButtonType> btnPressionado = alert.showAndWait();
            if (btnPressionado.isPresent()
                    && btnPressionado.get().equals(ButtonType.OK)) {
                Fachada.getInstance().excluirPassagem(p);
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
    	Passagem p = Fachada.getInstance().buscarPassagem(this.btExibirPass.getText());
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
