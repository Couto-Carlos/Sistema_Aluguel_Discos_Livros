package br.com.ufersa.lojaDudu.controller;

import br.com.ufersa.lojaDudu.model.entity.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddEditClienteController {
    
    @FXML private TextField nome;
    @FXML private TextField cpf;
    @FXML private TextField endereco;
    @FXML private TextField telefone;
    @FXML private Button confirm;


    @FXML
    void confirmar(ActionEvent event) {
        System.out.println("pop-up aberto");
        Stage stage = (Stage) confirm.getScene().getWindow();
        stage.close();
    }
    

    public void setData(Cliente cliente) {

        nome.setText(cliente.getNome());
        cpf.setText(cliente.getCpf());
        endereco.setText(cliente.getEndereco());
        telefone.setText(cliente.getTelefone());
    }
}
