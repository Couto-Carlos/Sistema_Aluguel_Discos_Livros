package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.bo.FuncionarioBO;
import model.entity.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ListaFuncionarioController {

    @FXML
    private Label id;
    @FXML
    private Label nome;
    @FXML
    private Label funcao;
    @FXML
    private Label cpf;
    @FXML
    private Button editar;
    @FXML
    private Button delete;

    private Funcionario selectedFuncionario;

    @FXML
    void deletePU(ActionEvent event) throws Exception {
        System.out.println("<Deletando Funcionario: " + selectedFuncionario.getLogin() + ">");

        FuncionarioBO funcionarioController = new FuncionarioBO();
        funcionarioController.deletar(selectedFuncionario);
        // delete no Banco e recarrege a tela

        List<Funcionario> clear = new ArrayList<Funcionario>();
        TelaFuncionariosController.listaFuncionarios = clear;

        TelaFuncionariosController.listaFuncionarios = funcionarioController.listar();

        NavController e = new NavController();
        e.mudarTelaFuncionarios(event); // regarrega a tela
    }

    @FXML
    void editarPU(ActionEvent event) {
        System.out.println("<Abrindo Pop-Up AddEditFuncionario>");

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/VE/AddEditFuncionario.fxml"));
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
        id.setText("" + func.getId());
        nome.setText(func.getLogin());
        funcao.setText(func.getFuncao());
        cpf.setText("***********");
    }

    public Funcionario getSelectedFuncionario() {
        return selectedFuncionario;
    }

    public void setSelectedFuncionario(Funcionario selectedFuncionario) {
        this.selectedFuncionario = selectedFuncionario;
    }
}
