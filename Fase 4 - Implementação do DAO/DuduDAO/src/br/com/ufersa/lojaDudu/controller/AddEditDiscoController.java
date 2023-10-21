package br.com.ufersa.lojaDudu.controller;

import br.com.ufersa.lojaDudu.model.entity.Disco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddEditDiscoController {
    
    @FXML private TextField nome;
    @FXML private TextField banda;
    @FXML private TextField estilo;
    @FXML private TextField quantEstq;
    @FXML private TextField preco;
    @FXML private Button confirm;

    @FXML void confirmar(ActionEvent event) {
        System.out.println("pop-up aberto");
        Stage stage = (Stage) confirm.getScene().getWindow();
        stage.close();
    }

    public void setData(Disco disco) {

        nome.setText(disco.getTitulo());
        banda.setText(disco.getAutor());
        estilo.setText(disco.getEstilo());
        quantEstq.setText(Integer.toString(disco.getQuantEstq()));
        preco.setText(Double.toString(disco.getValorAluguel()));
    }

}
