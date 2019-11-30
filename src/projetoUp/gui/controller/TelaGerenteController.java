package projetoUp.gui.controller;

import java.awt.TextField;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import projetoUp.gui.UpAirlinesApp;
import projetoUp.model.Voo;
import projetoUp.negocio.Fachada;

public class TelaGerenteController implements Initializable {

	
	
    @FXML
    private Tab tbVoos;

    @FXML
    private Button btBuscarVoo;

    @FXML
    private Button btAlterarVoo;

    @FXML
    private Button btRemoverVoo;

    @FXML
    private Button btInserirVoo;

    @FXML
    private Tab tbFunc;

    @FXML
    private Button btInserirFunc;

    @FXML
    private Button btBuscarFunc;

    @FXML
    private Button btRemoverFunc;
    
    @FXML
    private TextField txtCodigoRemove;

    @FXML
    private TextField txtCodigoAlterar;

    @FXML
    private TextField txtCodigoBuscar;
    
    private UpAirlinesApp upApp;
    
    public void setUpApp(UpAirlinesApp app){
    	this.upApp = app;
    }
    

    @FXML
    void InserirVoo(ActionEvent event) {
        Stage dialog = new Stage();

        dialog.setScene(ScreenManager.getInstance().getAddVooScene());
        dialog.setResizable(false);
        dialog.setTitle("Adicionar novo voo");
        dialog.initOwner(((Node) event.getSource()).getScene().getWindow());
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.showAndWait();

    }


    @FXML
    void BuscarVoo(ActionEvent event) {
    	Voo v = Fachada.getInstance().buscarVoo(this.txtCodigoRemove.getText());
    	if(v != null) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("Voo " + v.getcodigoVoo() + 
            					"\nOrigem: " + v.getAeroportoDeOrigem().getNome() +
            					"\nDestino: " + v.getAeroportoDeDestino().getNome() +
            					"\nSaída: " + v.getHorarioDeSaida().getHour() + ":" + v.getHorarioDeSaida().getMinute() +
            					"\nChegada: "+ v.getHorarioDeChegada().getHour() + ":" + v.getHorarioDeChegada().getMinute());
            alert.setTitle("Buscar Voo");
            alert.setContentText("");
            alert.show();
    		
    	}
    	else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("");
            alert.setTitle("Erro");
            alert.setContentText("Não existe voo com o código informado");
            alert.show();
    	}
    }
    
    @FXML
    void RemoverVoo(ActionEvent event) {
    	Voo v = Fachada.getInstance().buscarVoo(this.txtCodigoRemove.getText());
    	if(v != null) {
    		Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setHeaderText("");
            alert.setTitle("Remover Voo");
            alert.setContentText("Deseja remover voo a seguir?\n" + v);
            Optional<ButtonType> btnPressionado = alert.showAndWait();
            if (btnPressionado.isPresent()
                    && btnPressionado.get().equals(ButtonType.OK)) {
                Fachada.getInstance().removerVoo(v);
            }
    	}
    	else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("");
            alert.setTitle("Erro");
            alert.setContentText("Não existe voo com o código informado");
            alert.show();
    	}
    }

    
    @FXML
    void BuscarFuncionario(ActionEvent event) {

    }
    
    @FXML
    void InserirFuncionario(ActionEvent event) {

    }

    @FXML
    void RemoverFuncionario(ActionEvent event) {

    }



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
