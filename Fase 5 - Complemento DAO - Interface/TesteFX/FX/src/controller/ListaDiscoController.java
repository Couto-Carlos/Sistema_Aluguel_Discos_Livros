package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.bo.DiscoBO;
import model.entity.Disco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ListaDiscoController {
    @FXML
    private Label id;
    @FXML
    private Label titulo;
    @FXML
    private Label banda;
    @FXML
    private Label estilo;
    @FXML
    private Label quant_stq;
    @FXML
    private Label preco_uni;
    @FXML
    private Button delete;
    @FXML
    private Button editar;

    private Disco selectedDisco;

    @FXML
    void deletePU(ActionEvent event) throws Exception {
        System.out.println("<Deletando Disco: " + selectedDisco.getTitulo() + ">");
        DiscoBO discoController = new DiscoBO();
        discoController.Deletar(selectedDisco);
        // delete no Banco e recarrege a tela

        List<Disco> clear = new ArrayList<Disco>();
        TelaEstqDiscoController.listaDiscos = clear;

        TelaEstqDiscoController.listaDiscos = discoController.listar();

        NavController e = new NavController();
        e.mudarTelaEstqDiscos(event); // recarrega a tela
    }

    @FXML
    void editarPU(ActionEvent event) {
        System.out.println("<Abrindo Pop-Up AddEditDisco>");

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/VE/AddEditDisco.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));

            // preenche a tela aberta con os dados desse funcionario
            AddEditDiscoController aef = fxmlLoader.getController();
            aef.setData(getSelectedDisco());

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setData(Disco disco) {

        setSelectedDisco(disco);
        id.setText("" + disco.getId());
        titulo.setText(disco.getTitulo());
        banda.setText(disco.getNomeBanda());
        estilo.setText(disco.getEstilo());
        quant_stq.setText("" + disco.getQuantidadeExemplares());
        preco_uni.setText("" + disco.getValorAluguel());
    }

    // visibilidade dos controles para somente gerentes
    public void userPermissions(Boolean controlVisibility) {
        editar.setDisable(!controlVisibility);
        delete.setDisable(!controlVisibility);
    }

    public Disco getSelectedDisco() {
        return selectedDisco;
    }

    public void setSelectedDisco(Disco selectedDisco) {
        this.selectedDisco = selectedDisco;
    }

}
