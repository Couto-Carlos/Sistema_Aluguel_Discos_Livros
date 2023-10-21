package controller;

import model.bo.ClienteBO;
import model.entity.Cliente;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddEditClienteController {

    @FXML
    private Label erroCliente;
    @FXML
    private TextField nome;
    @FXML
    private TextField cpf;
    @FXML
    private TextField endereco;
    @FXML
    private Button confirm;

    private Cliente selectedcliente;

    @FXML
    void confirmar(ActionEvent event) throws Exception {
        System.out.println("pop-up aberto");
        Stage stage = (Stage) confirm.getScene().getWindow();

        Cliente cliente = new Cliente();

        cliente.setNome(nome.getText());
        cliente.setCpf(cpf.getText());
        cliente.setEndereco(endereco.getText());
        ClienteBO clienteController = new ClienteBO();

        if (selectedcliente == null) {
            Cliente autenticarcliente = clienteController.autenticarCPF(cliente);
            if (autenticarcliente == null) {
                clienteController.criar(cliente);

                List<Cliente> clear = new ArrayList<Cliente>();
                TelaClientesController.listaClientes = clear;

                TelaClientesController.listaClientes = clienteController.listar();

                NavController e = new NavController();
                e.mudarTelaClientes(event);
                stage.close();
            } else {
                erroCliente.setVisible(true);
                // TEXT NO ADDEDITclienteCONTROLLER JÁ EXISTE ESTE TITULO
            }

        } else {
            cliente.setId(selectedcliente.getId());

            System.out.println("AUTENTICAR ALTERAR");
            Cliente autenticarcliente = clienteController.autenticarCPF(cliente);
            if (autenticarcliente == null || autenticarcliente.getCpf().equals(selectedcliente.getCpf())) {
                clienteController.alterar(cliente);

                List<Cliente> clear = new ArrayList<Cliente>();
                TelaClientesController.listaClientes = clear;

                TelaClientesController.listaClientes = clienteController.listar();

                NavController e = new NavController();
                e.mudarTelaClientes(event);
                stage.close();
            } else {
                erroCliente.setVisible(true);
                // TEXT NO ADDEDITclienteCONTROLLER JÁ EXISTE ESTE TITULO
            }
        }
    }

    public void setData(Cliente cliente) {

        setSelectedCliente(cliente);
        nome.setText(cliente.getNome());
        cpf.setText(cliente.getCpf());
        endereco.setText(cliente.getEndereco());
    }

    public void setSelectedCliente(Cliente selectedCliente) {
        this.selectedcliente = selectedCliente;
    }

    public Cliente getSelectedCliente() {
        return selectedcliente;
    }
}
