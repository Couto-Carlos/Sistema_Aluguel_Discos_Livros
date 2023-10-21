package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.bo.ClienteBO;
import model.entity.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ListaClientesController {
    @FXML
    private Label nome;
    @FXML
    private Label cpf;
    @FXML
    private Label endereco;
    @FXML
    private Button editar;
    @FXML
    private Button delete;
    @FXML
    private Button add;

    private Cliente cliente;

    @FXML
    void adicionar(ActionEvent event) {
        System.out.println("<Cliente Adicionado>");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/VE/SrchCliente.fxml"));

        try {
            System.out.println(getCliente().getNome());

            Parent root = fxmlLoader.load();

            SrchClienteController sc = fxmlLoader.getController();
            sc.setSelectedCliente(cliente);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void deletePU(ActionEvent event) throws Exception {
        System.out.println("<Deletando Cliente: " + cliente.getNome() + ">");

        // delete no Banco e recarrege a tela

        ClienteBO clienteController = new ClienteBO();
        clienteController.delete(cliente);

        List<Cliente> clear = new ArrayList<Cliente>();
        TelaClientesController.listaClientes = clear;

        TelaClientesController.listaClientes = clienteController.listar();

        NavController e = new NavController();
        e.mudarTelaClientes(event); // recarrega a tela
    }

    @FXML
    void editarPU(ActionEvent event) {
        System.out.println("<Abrindo Pop-Up AddEditCliente>");

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/VE/AddEditCliente.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));

            // preenche a tela aberta con os dados desse funcionario
            AddEditClienteController aef = fxmlLoader.getController();
            aef.setData(getCliente());

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setData(Cliente cliente) {

        setCliente(cliente);

        nome.setText(cliente.getNome());
        endereco.setText(cliente.getEndereco());
        cpf.setText(cliente.getCpf());
    }

    public void userPermissions(Boolean controlVisibility) {
        editar.setDisable(controlVisibility);
        delete.setDisable(controlVisibility);
        add.setVisible(false);
        add.setManaged(false);
    }

    public void userPermissions(Boolean controlVisibility, Boolean notEdit) {
        if (notEdit) {
            editar.setVisible(controlVisibility);
            editar.setManaged(controlVisibility);
            delete.setVisible(controlVisibility);
            delete.setManaged(controlVisibility);
            add.setVisible(!controlVisibility);
            add.setManaged(!controlVisibility);
        } else {
            editar.setDisable(controlVisibility);
            delete.setDisable(controlVisibility);
        }

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente selectedCliente) {
        this.cliente = selectedCliente;
    }

}
