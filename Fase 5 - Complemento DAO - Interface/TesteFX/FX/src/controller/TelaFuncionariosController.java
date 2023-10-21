package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import DAO.FuncionarioDAO;
import model.bo.FuncionarioBO;
import model.entity.Funcionario;
// import DAO.FuncionarioDAO;
import model.entity.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaFuncionariosController extends NavController {

    @FXML
    private TextField srchFuncionario;
    @FXML
    private VBox funcionariosLayout;

    static List<Funcionario> listaFuncionarios = new ArrayList<>();

    public void procurarFuncionario(ActionEvent event) throws Exception {

        FuncionarioBO FuncionarioController = new FuncionarioBO();
        String search = srchFuncionario.getText();

        Funcionario FuncionarioBase = new Funcionario();
        FuncionarioBase.setLogin(search);

        List<Funcionario> clear = new ArrayList<Funcionario>();
        listaFuncionarios = clear;

        listaFuncionarios = FuncionarioController.pesquisaTotal(FuncionarioBase);

        printFuncionarios(listaFuncionarios);

        NavController e = new NavController();
        e.mudarTelaFuncionarios(event);

        System.out.println("Procurando por: " + search);
    }

    public void adicionarFuncionario(ActionEvent event) throws Exception {
        System.out.println("Funcionario Adicionado.");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/VE/AddEditFuncionario.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void initialize() {

        showUserLogin();
        FuncionarioDAO controllerFuncionario = new FuncionarioDAO();

        if (listaFuncionarios.size() == 0) {
            listaFuncionarios = new ArrayList<>(controllerFuncionario.listar());
        }

        printFuncionarios(listaFuncionarios);

    }

    public void printFuncionarios(List<Funcionario> funcionarios) {
        try {
            for (Funcionario func : funcionarios) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/VE/ListaFuncionario.fxml"));
                HBox hBox = fxmlLoader.load();
                ListaFuncionarioController lfc = fxmlLoader.getController();
                lfc.setData(func);
                funcionariosLayout.getChildren().add(hBox);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
