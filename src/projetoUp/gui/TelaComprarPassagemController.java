package projetoUp.gui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import projetoUp.model.Aeroporto;

public class TelaComprarPassagemController {

    @FXML
    private ChoiceBox<Aeroporto> chBoxOrigem;

    @FXML
    private ChoiceBox<Aeroporto> chBoxDestino;

    @FXML
    private DatePicker dtPickerDataVoo;

    @FXML
    private Button btSalvar;

    @FXML
    private Button btCancelar;

    @FXML
    void onClickCancelar(ActionEvent event) {

    }

    @FXML
    void onclickSalvar(ActionEvent event) {

    }

}
