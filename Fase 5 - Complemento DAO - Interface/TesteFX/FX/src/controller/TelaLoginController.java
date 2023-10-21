package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import view.Telas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.FuncionarioDAO;
import model.bo.FuncionarioBO;
// import DAO.FuncionarioDAO;
import model.entity.Funcionario;

public class TelaLoginController {

    @FXML
    private Label erroLogin;
    @FXML
    private TextField usuario;
    @FXML
    private TextField senha;
    @FXML
    private Hyperlink recuperar;

    public void autenticar(ActionEvent event) throws Exception {

        Funcionario novFuncionario = new Funcionario(usuario.getText(), senha.getText(), "00000");

        FuncionarioBO funcionarioBO = new FuncionarioBO();
        Funcionario funcionarioEncontrado = funcionarioBO.login(novFuncionario);

        NavController.setFuncionarioLogado(funcionarioEncontrado);

        if (funcionarioEncontrado != null) {
            Telas.telaVenda(); // Passar funcionario como parametro.
        } else {
            System.out.println("Funcionario não encontrado");// Aplicar pop-up de
            erroLogin.setVisible(true);
        }

    }

    public void recuperarConta(ActionEvent event) throws Exception {
        System.out.println("Abrindo Pop-Up <Recuperar Senha>");
    }

}
