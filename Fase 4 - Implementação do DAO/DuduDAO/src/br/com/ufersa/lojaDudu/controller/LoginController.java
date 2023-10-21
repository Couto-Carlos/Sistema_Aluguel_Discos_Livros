package br.com.ufersa.lojaDudu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import br.com.ufersa.lojaDudu.view.Telas;

public class LoginController {
    @FXML private TextField usuario;
    @FXML private TextField senha;
    @FXML private Hyperlink recuperar;

    public void autenticar(ActionEvent event) throws Exception {
        String login2 = usuario.getText();
        String senha2 = senha.getText();

        System.out.println("Usuário: " + login2 + " | Senha: " + senha2);

        Telas.telaVenda();
    }

    public void recuperarConta(ActionEvent event) throws Exception {
        System.out.println("Abrindo Pop-Up <Recuperar Senha>");
    }
}
