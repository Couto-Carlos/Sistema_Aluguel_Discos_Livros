package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Cliente;
import model.entity.Cliente;
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
import DAO.ClienteDAO;
import model.entity.Cliente;
import model.bo.ClienteBO;
import model.bo.ClienteBO;

public class TelaClientesController extends NavController {

    @FXML
    private Button botaoAdicionar;
    @FXML
    private TextField srchCliente;
    @FXML
    private VBox clientesLayout;

    static List<Cliente> listaClientes = new ArrayList<>();

    public void procurarCliente(ActionEvent event) throws Exception {
        ClienteBO ClienteController = new ClienteBO();
        String search = srchCliente.getText();

        Cliente ClienteBase = new Cliente();
        ClienteBase.setNome(search);

        List<Cliente> clear = new ArrayList<Cliente>();
        listaClientes = clear;

        listaClientes = ClienteController.pesquisaTotal(ClienteBase);

        printClientes(listaClientes);

        NavController e = new NavController();
        e.mudarTelaClientes(event);

        System.out.println("Procurando por: " + search);
    }

    public void adicionarCliente(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/VE/AddEditCliente.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();

    }

    public void initialize() {

        isGerente();
        showUserLogin();
        ClienteBO controleCliente = new ClienteBO();
        System.out.println(listaClientes.size());
        if (listaClientes.size() == 0) {
            listaClientes = new ArrayList<>(controleCliente.listar());
        } else {
            System.out.println("LISTA COM ITENS");
        }
        printClientes(listaClientes);

    }

    public void printClientes(List<Cliente> clientes) {
        try {
            for (Cliente cliente : clientes) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/VE/ListaCliente.fxml"));

                HBox hBox = fxmlLoader.load();
                ListaClientesController ldc = fxmlLoader.getController();

                ldc.setData(cliente);
                ldc.userPermissions(!isGerente());
                botaoAdicionar.setDisable(!isGerente());
                clientesLayout.getChildren().add(hBox);

            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}
