package br.com.ufersa.lojaDudu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufersa.lojaDudu.model.entity.Funcionario;
import br.com.ufersa.lojaDudu.model.entity.Gerente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FuncionariosController extends NavController {
    @FXML private TextField srchFuncionario;
    @FXML private Button addFuncionario;
    @FXML private VBox funcionariosLayout;
    
    public void procurarFuncionario(ActionEvent event) throws Exception {
        String search = srchFuncionario.getText();

        System.out.println("Procurando por: " + search);
    }

    public void adicionarFuncionario(ActionEvent event) throws Exception {
        System.out.println("Funcionario Adicionado.");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/ufersa/lojaDudu/view/VE/AddEditFuncionario.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }
    
    public void initialize() {
        try {
            List<Funcionario> funcionario = new ArrayList<>(funcionarioTeste());

            for (Funcionario func : funcionario) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/ufersa/lojaDudu/view/VE/ListaFuncionario.fxml"));
                HBox hBox = fxmlLoader.load();
                ListaFuncionarioController lfc = fxmlLoader.getController();
                lfc.setData(func);
                funcionariosLayout.getChildren().add(hBox);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    private List<Funcionario> funcionarioTeste() {
        List<Funcionario> ls = new ArrayList<>();

        Funcionario dudu = new Gerente("Dudu", "111.222.333-44", "Boulevard", 3000.00, "duduDono", "1234");
        ls.add(dudu);
        Funcionario f1 = new Funcionario("Fernando", "Caixa","555.666.777-88", "Rua Sete", 1700.00, "fernandin", "senhadaora");
        ls.add(f1);
        ls.add(f1);
        ls.add(f1);
        ls.add(f1);
        ls.add(f1);
        ls.add(f1);
        ls.add(f1);
        ls.add(f1);
        ls.add(f1);
        ls.add(f1);

        return ls;
    }

}
