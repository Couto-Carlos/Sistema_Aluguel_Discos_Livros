package br.com.ufersa.lojaDudu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufersa.lojaDudu.model.entity.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VendaController extends NavController {
    @FXML private Button addCarrinho;
    @FXML private Button addCliente;
    @FXML private Button finalVenda;
    @FXML private TextField srchCliente;
    @FXML private Label precoTotal;
    @FXML private VBox itemsLayout;


    public void adicionarCarrinho(ActionEvent event) throws Exception {
        System.out.println("Produto Adicionado ao Carrinho.");
    }
    public void adicionarCliente(ActionEvent event) throws Exception {
        System.out.println("Novo Cliente Adicionado.");
    }
    public void finalizarVenda(ActionEvent event) throws Exception {
        System.out.println("Venda Finalizada.");
    }
    public void procurarCliente(ActionEvent event) throws Exception {
        String search = srchCliente.getText();

        System.out.println("Procurando por: " + search);
    }


    public void initialize() {
        try {
            List<Item> item = new ArrayList<>(itemsTeste());

            for (Item items : item) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/ufersa/lojaDudu/view/VE/ListaCarrinho.fxml"));
                HBox hBox = fxmlLoader.load();
                ListaCarrinhoController ldc = fxmlLoader.getController();
                ldc.setData(items);
                
                if (item.size() >= 0) {
                    precoFinal(item);
                }

                itemsLayout.getChildren().add(hBox);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., show an error message.
        }
    }


    private void precoFinal (List<Item> item) {
        Double total = 0d;

        for (Item items : item) {
            total =+ items.getValorAluguel();
        }

        precoTotal.setText(Double.toString(total));
    }

    
    private List<Item> itemsTeste() {
        List<Item> ls = new ArrayList<>();

        return ls;
    }

}
