package projetoUp.gui;


import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import projetoUp.model.Voo;
import projetoUp.negocio.Fachada;

public class TelaGerenteController implements Initializable {
    @FXML
    private Text lbBemVIndoG;
	
    @FXML
    private Tab tbVoos;
    
    @FXML
    private ImageView imgFundo1;
    

    @FXML
    private ImageView imgFundo2;

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
    
    @FXML
    private TextField txtCodigoRemoveFunc;

    @FXML
    private TextField txtCodigoBuscaFunc;
    
    private Fachada fachada = Fachada.getInstance();
    
    @SuppressWarnings("unused")
	private UpAirlinesApp upApp;
    
    public void setUpApp(UpAirlinesApp app){
    	this.upApp = app;
    }
    

    @FXML
    void InserirVoo(ActionEvent event) {
        
        try {
        	
        	Stage s1 = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("TelaAddVoo.fxml"));
            Scene scene = new Scene(root);

            s1.setScene(scene);
            s1.show(); 
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }


    @FXML
    void BuscarVoo(ActionEvent event) {
    	Voo v = fachada.buscarVoo(this.txtCodigoBuscar.getText());
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
            alert.setContentText("Não existe voo com o código informado.");
            alert.show();
    	}
    }
    
    @FXML
    void RemoverVoo(ActionEvent event) {
    	Voo v = fachada.buscarVoo(this.txtCodigoRemove.getText());
    	if(v != null) {
    		Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setHeaderText("");
            alert.setTitle("Remover Voo");
            alert.setContentText("Deseja remover o voo a seguir?\n" + v);
            Optional<ButtonType> btnPressionado = alert.showAndWait();
            if (btnPressionado.isPresent()
                    && btnPressionado.get().equals(ButtonType.OK)) {
            	fachada.removerVoo(v);
            }
    	}
    	else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("");
            alert.setTitle("Erro");
            alert.setContentText("Não existe voo com o código informado.");
            alert.show();
    	}
    }
    
    @FXML
    void AlterarVoo(ActionEvent event) {

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
