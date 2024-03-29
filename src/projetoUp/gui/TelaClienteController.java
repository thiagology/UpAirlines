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
import projetoUp.exceptions.NaoExisteException;
import projetoUp.model.Cliente;
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
    	Passagem p;
		try {
			p = fachada.buscarPassagem(this.btAlterarPass.getText());
			 if(txtNovoAssento.getText() == null) {
		            Alert alert = new Alert(AlertType.ERROR);
		            alert.setHeaderText("");
		            alert.setTitle("Erro");
		            alert.setContentText("Informe um assento v�lido.");
		            alert.show();
		    	}
			 else {
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
		} catch (NaoExisteException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("");
            alert.setTitle("Erro");
            alert.setContentText("N�o existe passagem com o c�digo informado.");
            alert.show();
		}catch (NullPointerException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("");
            alert.setTitle("Erro");
            alert.setContentText("N�o existe passagem com o c�digo informado.");
            alert.show();
		} catch (Exception e) {
			e.printStackTrace();
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
    	Passagem p;
		try {
			p = fachada.buscarPassagem(this.txtExcluirPass.getText());
    		Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setHeaderText("");
            alert.setTitle("Excluir Passagem");
            alert.setContentText("Deseja excluir a passagem a seguir?\n" + p);
            Optional<ButtonType> btnPressionado = alert.showAndWait();
            if (btnPressionado.isPresent()
                    && btnPressionado.get().equals(ButtonType.OK)) {
            	fachada.excluirPassagem(p);
            }
		} catch (NaoExisteException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("");
            alert.setTitle("Erro");
            alert.setContentText("N�o existe passagem com o c�digo informado.");
            alert.show();
		} catch (NullPointerException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("");
            alert.setTitle("Erro");
            alert.setContentText("N�o existe passagem com o c�digo informado.");
            alert.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void onClickExibirPassagem(ActionEvent event) {
    	Passagem p;
		try {
			p = fachada.buscarPassagem(this.btExibirPass.getText());
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("C�digo " + p.getCodigo() + 
            					"\n:Voo " + p.getVoo().getcodigoVoo() +
            					"\nPassageiro: " + p.getPassageiro().getNome() +
            					"\nPre�o: " + p.getPreco() );
            alert.setTitle("Buscar Passagem");
            alert.setContentText("");
            alert.show();
		} catch (NaoExisteException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("");
            alert.setTitle("Erro");
            alert.setContentText("N�o existe passagem com o c�digo informado.");
            alert.show();
		}catch (NullPointerException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("");
            alert.setTitle("Erro");
            alert.setContentText("N�o existe passagem com o c�digo informado.");
            alert.show();
		}  catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void onClickRemoverConta(ActionEvent event) throws NaoExisteException {
    	Cliente c = fachada.getClienteLog();
    	Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setHeaderText("");
        alert.setTitle("Excluir conta UP");
        alert.setContentText("Deseja excluir sua conta UP?\n");
        Optional<ButtonType> btnPressionado = alert.showAndWait();
        if (btnPressionado.isPresent()
                && btnPressionado.get().equals(ButtonType.OK)) {
        	fachada.excluirConta(c);
        }
    }
}
