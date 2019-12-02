package projetoUp.gui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import projetoUp.model.Cidades;

public class TelaComprarPassagemController {

    @FXML
    private ChoiceBox<Cidades> chBoxOrigem;

    @FXML
    private ChoiceBox<Cidades> chBoxDestino;

    @FXML
    private DatePicker dtPickerDataVoo;

    @FXML
    private Button btSalvar;

    @FXML
    private Button btCancelar;
    
    @FXML
    public void initialize() {
        this.chBoxOrigem.getItems().addAll(Cidades.values());
        this.chBoxDestino.getItems().addAll(Cidades.values());
    }

    @FXML
    void onClickCancelar(ActionEvent event) {
    	((Stage) this.btCancelar.getScene().getWindow()).close();
    	this.limparCampos();
    }

    @FXML
    void onclickSalvar(ActionEvent event) {

    }
    
    public void limparCampos() {
        this.chBoxOrigem.getSelectionModel().clearSelection();
        this.chBoxDestino.getSelectionModel().clearSelection();
        this.dtPickerDataVoo.setValue(null);
		
	}

}
