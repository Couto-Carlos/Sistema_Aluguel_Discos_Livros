package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import model.bo.ClienteBO;
import model.entity.Cliente;

public class SrchClienteController {

    @FXML
    private TextField srchCliente;
    @FXML
    private VBox clientesLayout;
    @FXML
    private Button confirm;
    @FXML
    private TextField nome;

    private static Cliente selectedCliente;

    static List<Cliente> listaClientes = new ArrayList<>();

    @FXML
    void confirmar(ActionEvent event) {
        try {
            if (selectedCliente != null) {

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/VE/TelaVenda.fxml"));

                Parent root = fxmlLoader.load();
                TelaVendaController cl = fxmlLoader.getController();

                cl.setSelectedCliente(selectedCliente);

                try {
                    cl.mudarTelaVenda(event);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("fechando pop-up");
        Stage stage = (Stage) confirm.getScene().getWindow();
        stage.close();

    }

    public void initialize() {
        ClienteBO controleCliente = new ClienteBO();

        if (listaClientes.size() == 0) {
            listaClientes = new ArrayList<>(controleCliente.listar());
        } else {
            System.out.println("LISTA COM ITENS");
        }
        System.out.println("Srch Cliente Controller");
        printClientes(listaClientes);

    }

    public void procurarCliente(ActionEvent event) throws Exception {
        ClienteBO ClienteController = new ClienteBO();
        String search = srchCliente.getText();

        Cliente ClienteBase = new Cliente();
        ClienteBase.setNome(search);

        List<Cliente> clear = new ArrayList<Cliente>();
        listaClientes = clear;

        listaClientes = ClienteController.pesquisaTotal(ClienteBase);

        printClientes(listaClientes);

        Stage stage = (Stage) confirm.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/VE/SrchCliente.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage openStage = new Stage();
        openStage.setScene(new Scene(root1));
        openStage.show();

        System.out.println("Procurando por: " + search);
    }

    public void printClientes(List<Cliente> clientes) {
        try {
            for (Cliente cliente : clientes) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/VE/ListaCliente.fxml"));

                HBox hBox = fxmlLoader.load();
                ListaClientesController ldc = fxmlLoader.getController();

                ldc.setData(cliente);

                ldc.userPermissions(false, true);
                clientesLayout.getChildren().add(hBox);

            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public Cliente getSelectedCliente() {
        return selectedCliente;
    }

    public void setSelectedCliente(Cliente selected) {
        System.out.println("Set Selected Cliente" + selected.getNome());

        selectedCliente = selected;
    }
}
