package projetoUp.gui;

import java.time.LocalTime;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projetoUp.model.Aeroporto;
import projetoUp.model.Cidades;
import projetoUp.model.Funcionario;
import projetoUp.model.Piloto;
import projetoUp.model.Voo;

public class TelaAddVooController {

    @FXML
    private ChoiceBox<Funcionario> chBoxPiloto;

    @FXML
    private ChoiceBox<Funcionario> chBoxCopiloto;

    @FXML
    private ChoiceBox<Aeroporto> chBoxOrigem;

    @FXML
    private ChoiceBox<Aeroporto> chBoxDestino;

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
        this.chBoxOrigem.getItems().addAll();//adiconar lista de cidades
        this.chBoxDestino.getItems().addAll();
        
        this.chBoxPiloto.getItems().addAll();//adicionar lista de pilotos
        this.chBoxCopiloto.getItems().addAll();

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
		Voo v = new Voo( chBoxOrigem.getValue(),
						chBoxDestino.getValue(),
						chBoxPiloto.getValue(),
						chBoxCopiloto.getValue(),
						null,
						LocalTime.of(Integer.parseInt(this.txtHoraSaida.getText()), 0),
						null,
						this.txtCodigo.getText(),
						0,
						this.dtPickerDataVoo.getValue()
						);
    }

}
