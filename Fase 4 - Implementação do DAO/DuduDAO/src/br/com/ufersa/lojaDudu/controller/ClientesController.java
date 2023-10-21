package br.com.ufersa.lojaDudu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufersa.lojaDudu.model.entity.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ClientesController extends NavController {
    @FXML private TextField srchCliente;
    @FXML private Button addCliente;
    @FXML private VBox clientesLayout;
    
    public void procurarCliente(ActionEvent event) throws Exception {
        String search = srchCliente.getText();

        System.out.println("Procurando por: " + search);
    }

    public void adicionarCliente(ActionEvent event) throws Exception {
        System.out.println("Cliente Adicionado.");
    }

    public void initialize() {
        try {
            List<Cliente> clientes = new ArrayList<>(clientesTeste());

            for (Cliente cliente : clientes) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/ufersa/lojaDudu/view/VE/ListaCliente.fxml"));
                HBox hBox = fxmlLoader.load();
                ListaClientesController ldc = fxmlLoader.getController();
                ldc.setData(cliente);
                ldc.userPermissions(true);
                clientesLayout.getChildren().add(hBox);
                
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., show an error message.
        }
    }

    public List<Cliente> clientesTeste() {
        List<Cliente> ls = new ArrayList<>();
        
        Cliente c = new Cliente("Adriano", "Rua Zero", "123.456.789-11", "+55 (84) 99999-2222");
        ls.add(c);
        c = new Cliente("Bernardo", "Rua Um", "222.222.222-22", "91111-2222");
        ls.add(c);
        c = new Cliente("Carlos", "Rua Dois", "333.333.333-33", "92222-3333");
        ls.add(c);
        ls.add(c);
        ls.add(c);
        ls.add(c);
        ls.add(c);
        ls.add(c);
        ls.add(c);
        ls.add(c);
        ls.add(c);

        return ls;
    }
}
