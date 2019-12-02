package projetoUp.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import projetoUp.model.Cidades;
import projetoUp.model.Pilotos;
import projetoUp.model.Voo;
import projetoUp.negocio.Fachada;

public class TelaAddVooController {

    @FXML
    private ChoiceBox<Pilotos> chBoxPiloto;

    @FXML
    private ChoiceBox<Pilotos> chBoxCopiloto;

    @FXML
    private ChoiceBox<Cidades> chBoxOrigem;

    @FXML
    private ChoiceBox<Cidades> chBoxDestino;

    @FXML
    private DatePicker dtPickerDataVoo;

    @FXML
    private TextField txtCodigo;

    @FXML
    private Button btSalvar;

    @FXML
    private Button btCancelar;
    
    @FXML
    private TextField txtHoraSaida;
    
    @FXML
    public void initialize() {
        this.chBoxOrigem.getItems().addAll(Cidades.values());
        this.chBoxDestino.getItems().addAll(Cidades.values());
        
        this.chBoxPiloto.getItems().addAll(Pilotos.values());
        this.chBoxCopiloto.getItems().addAll(Pilotos.values());

    }
    
    @FXML
    void onClickCancelar(ActionEvent event) {
    	((Stage) this.btCancelar.getScene().getWindow()).close();
    	this.limparCampos();
    	
    }

    public void limparCampos() {
        this.chBoxOrigem.getSelectionModel().clearSelection();
        this.chBoxDestino.getSelectionModel().clearSelection();
        this.chBoxPiloto.getSelectionModel().clearSelection();
        this.chBoxCopiloto.getSelectionModel().clearSelection();
        
        this.txtCodigo.setText("");
        this.txtHoraSaida.setText("");
        this.dtPickerDataVoo.setValue(null);
		
	}

	@FXML
    void onclickSalvar(ActionEvent event) {
		String msgErro = "";
		if(txtCodigo.getText() == null) {
			msgErro = "Código Inválido.";
		}
		if(chBoxOrigem.getValue() == null || 
			chBoxDestino.getValue() == null||
			chBoxCopiloto.getValue() == null ||
			chBoxCopiloto.getValue() == null ||
			dtPickerDataVoo.getValue() == null) {
			msgErro = "Selecione todos os itens.";
		}
		
		if (msgErro.length() == 0) {
			Voo v = new Voo( chBoxOrigem.getValue(),
					chBoxDestino.getValue(),
					chBoxPiloto.getValue(),
					chBoxCopiloto.getValue(),
					null,
					null,
					this.txtCodigo.getText(),
					this.dtPickerDataVoo.getValue()
					);
	
			Fachada.getInstance().criarVoo(v);
            
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(msgErro);
            alert.setContentText("");

            alert.showAndWait();
        }
		

    }

}
