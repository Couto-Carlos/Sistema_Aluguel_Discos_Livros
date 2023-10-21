package br.com.ufersa.lojaDudu.controller;

import java.io.IOException;

import br.com.ufersa.lojaDudu.model.entity.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ListaFuncionarioController {
    @FXML private Label nome;
    @FXML private Label funcao;
    @FXML private Label cpf;
    @FXML private Label endereco;
    @FXML private Label salario;
    @FXML private Button editar;
    @FXML private Button delete;

    private Funcionario selectedFuncionario;


    @FXML
    void deletePU(ActionEvent event) throws Exception {
        System.out.println("<Abrindo Pop-Up Confirmação>");
    }

    @FXML
    void editarPU(ActionEvent event)  {
        System.out.println("<Abrindo Pop-Up AddEditFuncionario>");

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/ufersa/lojaDudu/view/VE/AddEditFuncionario.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            
            // preenche a tela aberta con os dados desse funcionario
            AddEditFuncionarioController aef = fxmlLoader.getController();
            aef.setData(selectedFuncionario);

            stage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setData(Funcionario func) {
        
        setSelectedFuncionario(func);
        nome.setText(func.getNome());
        funcao.setText(func.getFuncao());
        cpf.setText(func.getCpf());
        endereco.setText(func.getEndereco());
        salario.setText(Double.toString(func.getSalario()));
    }
    
    
    public Funcionario getSelectedFuncionario() { return selectedFuncionario; }

    public void setSelectedFuncionario(Funcionario selectedFuncionario) {
        this.selectedFuncionario = selectedFuncionario;
    }
}
