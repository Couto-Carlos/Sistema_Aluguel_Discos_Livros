package br.com.ufersa.lojaDudu.controller;

import br.com.ufersa.lojaDudu.model.entity.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddEditFuncionarioController {

    @FXML private TextField nome;
    @FXML private TextField funcao;
    @FXML private TextField cpf;
    @FXML private TextField endereco;
    @FXML private TextField salario;
    @FXML private Button confirm;

    @FXML void confirmar(ActionEvent event) {
        System.out.println("pop-up aberto");
        Stage stage = (Stage) confirm.getScene().getWindow();
        stage.close();
    }

    public void setData(Funcionario func) {

        nome.setText(func.getNome());
        funcao.setText(func.getFuncao());
        cpf.setText(func.getCpf());
        endereco.setText(func.getEndereco());
        salario.setText(Double.toString(func.getSalario()));
    }
}
