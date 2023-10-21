package controller;

import model.bo.FuncionarioBO;
import model.entity.Funcionario;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddEditFuncionarioController {

    @FXML
    private Label erroFuncionario;
    @FXML
    private TextField nome;
    @FXML
    private TextField funcao;
    @FXML
    private TextField senha;
    @FXML
    private Button confirm;

    private Funcionario selectedFuncionario;

    @FXML
    void confirmar(ActionEvent event) throws Exception {
        System.out.println("pop-up aberto");

        FuncionarioBO funcionarioController = new FuncionarioBO();
        Funcionario funcionario = new Funcionario();
        funcionario.setLogin(nome.getText());
        funcionario.setSenha(senha.getText());
        funcionario.setFuncao(funcao.getText());

        Funcionario autenticar = funcionarioController.VerificarLogin(funcionario);
        System.out.println("POS BUSCAR");
        Stage stage = (Stage) confirm.getScene().getWindow();

        if (selectedFuncionario == null) {
            if (autenticar == null) {
                funcionarioController.criar(funcionario);

                List<Funcionario> clear = new ArrayList<Funcionario>();
                TelaFuncionariosController.listaFuncionarios = clear;

                TelaFuncionariosController.listaFuncionarios = funcionarioController.listar();

                NavController e = new NavController();
                e.mudarTelaFuncionarios(event);
                stage.close();
            } else {
                erroFuncionario.setVisible(true);
            }
        }else{
            if (autenticar == null || autenticar.getLogin().equals(selectedFuncionario.getLogin())) {
                System.out.println("SELECTEDFUNCID"+selectedFuncionario.getId());
                funcionario.setId(selectedFuncionario.getId()); 
                funcionarioController.alterar(funcionario);

                List<Funcionario> clear = new ArrayList<Funcionario>();
                TelaFuncionariosController.listaFuncionarios = clear;

                TelaFuncionariosController.listaFuncionarios = funcionarioController.listar();

                NavController e = new NavController();
                e.mudarTelaFuncionarios(event);
                stage.close();
            } else {
                erroFuncionario.setVisible(true);
            }
        }
    }

    public void setData(Funcionario func) {

        setSelectedFuncionario(func);
        nome.setText(func.getLogin()); // login nome, senha cpf
        funcao.setText(func.getFuncao());
        senha.setText(func.getSenha());
    }

    public Funcionario getSelectedFuncionario() {
        return selectedFuncionario;
    }

    public void setSelectedFuncionario(Funcionario selectedFuncionario) {
        this.selectedFuncionario = selectedFuncionario;
    }
}
