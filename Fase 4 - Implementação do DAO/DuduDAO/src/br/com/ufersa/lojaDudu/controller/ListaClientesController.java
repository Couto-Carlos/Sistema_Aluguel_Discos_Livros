package br.com.ufersa.lojaDudu.controller;

import java.io.IOException;

import br.com.ufersa.lojaDudu.model.entity.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ListaClientesController {
    @FXML private Label nome;
    @FXML private Label cpf;
    @FXML private Label endereco;
    @FXML private Label telefone;
    @FXML private Button editar;
    @FXML private Button delete;
    @FXML private Button add;

    private Cliente selectedCliente;

    @FXML
    void adicionar(ActionEvent event) {
        System.out.println("<Cliente Adicionado>");
    }
    

    @FXML
    void deletePU(ActionEvent event) {
        System.out.println("<Abrindo Pop-Up Confirmação>");
    }


    @FXML
    void editarPU(ActionEvent event) {
        System.out.println("<Abrindo Pop-Up AddEditCliente>");

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/ufersa/lojaDudu/view/VE/AddEditCliente.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            
            // preenche a tela aberta con os dados desse funcionario
            AddEditClienteController aef = fxmlLoader.getController();
            aef.setData(getSelectedCliente());

            stage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setData(Cliente cliente) {

        setSelectedCliente(cliente);
        nome.setText(cliente.getNome());
        endereco.setText(cliente.getEndereco());
        cpf.setText(cliente.getCpf());
        telefone.setText(cliente.getTelefone());
    }

    public void userPermissions(Boolean controlVisibility) {
        editar.setVisible(controlVisibility);
        editar.setManaged(controlVisibility);
        delete.setVisible(controlVisibility);
        delete.setManaged(controlVisibility);
        add.setVisible(!controlVisibility);
        add.setManaged(!controlVisibility);
    }
    
    public Cliente getSelectedCliente() { return selectedCliente; }

    public void setSelectedCliente(Cliente selectedCliente) {
        this.selectedCliente = selectedCliente;
    }

}
