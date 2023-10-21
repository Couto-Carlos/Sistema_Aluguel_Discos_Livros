package br.com.ufersa.lojaDudu.controller;

import java.io.IOException;

import br.com.ufersa.lojaDudu.model.entity.Disco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ListaDiscoController {
    @FXML private Label id;
    @FXML private Label titulo;
    @FXML private Label banda;
    @FXML private Label estilo;
    @FXML private Label quant_stq;
    @FXML private Label preco_uni;
    @FXML private Button delete;
    @FXML private Button editar;

    private Disco selectedDisco;


    @FXML
    void deletePU(ActionEvent event) {
        System.out.println("<Abrindo Pop-Up Confirmação>");

    }

    @FXML
    void editarPU(ActionEvent event) {
        System.out.println("<Abrindo Pop-Up AddEditDisco>");

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/ufersa/lojaDudu/view/VE/AddEditDisco.fxml"));
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
        id.setText(Long.toString(disco.getId()));
        titulo.setText(disco.getTitulo());
        banda.setText(disco.getAutor());
        estilo.setText(disco.getEstilo());
        quant_stq.setText(Integer.toString(disco.getQuantEstq()));
        preco_uni.setText(Double.toString(disco.getValorAluguel()));
    } 
    
    // visibilidade dos controles para somente gerentes
    public void userPermissions(Boolean controlVisibility) {
        editar.setVisible(controlVisibility);
        editar.setManaged(controlVisibility);
        delete.setVisible(controlVisibility);
        delete.setManaged(controlVisibility);
    }


    public Disco getSelectedDisco() { return selectedDisco; }

    public void setSelectedDisco(Disco selectedDisco) {
        this.selectedDisco = selectedDisco;
    }

}
