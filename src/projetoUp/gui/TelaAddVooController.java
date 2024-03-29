package projetoUp.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import projetoUp.exceptions.JaExisteException;
import projetoUp.exceptions.NaoExisteException;
import projetoUp.exceptions.RotaNaoExiste;
import projetoUp.model.Cidades;
import projetoUp.model.Voo;
import projetoUp.negocio.Fachada;

public class TelaAddVooController {

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
    
    private Fachada fachada = Fachada.getInstance();
    
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

    public void limparCampos() {
        this.chBoxOrigem.getSelectionModel().clearSelection();
        this.chBoxDestino.getSelectionModel().clearSelection();
        
        this.txtCodigo.setText("");
        this.txtHoraSaida.setText("");
        this.dtPickerDataVoo.setValue(null);
		
	}

	@FXML
    void onclickSalvar(ActionEvent event) {
		String msgErro = "";
		if(txtCodigo.getText() == null) {
			msgErro = "C�digo Inv�lido.";
		}
		if(chBoxOrigem.getValue() == null || 
			chBoxDestino.getValue() == null||
			dtPickerDataVoo.getValue() == null) {
			msgErro = "Selecione todos os itens.";
		}
		
		if (msgErro.length() == 0) {
			Voo v = new Voo( chBoxOrigem.getValue(),
					chBoxDestino.getValue(),
					null,
					null,
					this.txtCodigo.getText(),
					this.dtPickerDataVoo.getValue()
					);
			
			try {
				fachada.criarVoo(v);
				 Alert alert = new Alert(AlertType.ERROR);
		            alert.setTitle("Erro");
		            alert.setHeaderText("Voo cadastrado com sucesso!");
		            alert.setContentText("");

		            alert.showAndWait();
			} catch (NaoExisteException e) {
	           //faz nada
			} catch (JaExisteException e) {
	            Alert alert = new Alert(AlertType.ERROR);
	            alert.setTitle("Erro");
	            alert.setHeaderText("J� existe esse voo cadastrado.");
	            alert.setContentText("");

	            alert.showAndWait();
			} catch (RotaNaoExiste e) {
				Alert alert = new Alert(AlertType.ERROR);
	            alert.setTitle("Erro");
	            alert.setHeaderText(e.toString());
	            alert.setContentText("");
			}catch (NullPointerException e) {
	            Alert alert = new Alert(AlertType.ERROR);
	            alert.setHeaderText("");
	            alert.setTitle("Erro");
	            alert.setContentText("N�o foi poss�vel cadastrar voo.");
	            alert.show();
			}  catch (Exception e) {
				e.printStackTrace();
			}
            
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(msgErro);
            alert.setContentText("");

            alert.showAndWait();
        }
		

    }

}
