package br.com.ufersa.lojaDudu.controller;

import br.com.ufersa.lojaDudu.model.entity.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ListaCarrinhoController {
    @FXML private Label nome;
    @FXML private Label tipo;
    @FXML private Label preco;
    @FXML private Button delete;
    
    @FXML
    void deletePU(ActionEvent event) {
        System.out.println("<Abrindo Pop-Up Confirmação>");
    }


    public void setData(Item items) {
        nome.setText(items.getTitulo());
        tipo.setText(items.getTipo());
        preco.setText(Double.toString(items.getValorAluguel()));
    }
}
