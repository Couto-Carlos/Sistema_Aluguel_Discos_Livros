package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.bo.DiscoBO;
import model.entity.Disco;
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

public class TelaEstqDiscoController extends NavController {

    @FXML
    private Button botaoAdicionar;
    @FXML
    private TextField srchDisco;
    @FXML
    private VBox discosLayout;

    static List<Disco> listaDiscos = new ArrayList<>();

    public void adicionarDisco(ActionEvent event) throws Exception {
        System.out.println("Disco Adicionado.");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/VE/AddEditDisco.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void initialize() {
        isGerente();
        showUserLogin();
        DiscoBO controllerDisco = new DiscoBO();
        if (listaDiscos.size() == 0) {
            System.out.println("LISTAVAZIA");
            listaDiscos = controllerDisco.listar();
        } else {
            System.out.println("LISTA COM ITENS");
        }
        printDiscos(listaDiscos);
    }

    public void printDiscos(List<Disco> discos) {
        try {
            for (Disco disco : discos) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/VE/ListaDisco.fxml"));
                HBox hBox = fxmlLoader.load();
                ListaDiscoController ldc = fxmlLoader.getController();
                ldc.setData(disco);
                ldc.userPermissions(isGerente());
                botaoAdicionar.setDisable(!isGerente());
                discosLayout.getChildren().add(hBox);

            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public void procurarDisco(ActionEvent event) throws Exception {
        DiscoBO discoController = new DiscoBO();
        String search = srchDisco.getText();

        Disco discoBase = new Disco();
        discoBase.setTitulo(search);

        List<Disco> clear = new ArrayList<Disco>();
        listaDiscos = clear;

        listaDiscos = discoController.pesquisaTotal(discoBase);

        printDiscos(listaDiscos);

        NavController e = new NavController();
        e.mudarTelaEstqDiscos(event);

        System.out.println("Procurando por: " + search);
    }

}
