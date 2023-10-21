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
import model.bo.AluguelBO;
import model.entity.Venda;
import model.entity.Venda;

public class SrchItemController {
    @FXML
    private TextField nome;
    @FXML
    private Button confirm;
    @FXML
    private VBox itemsLayout;
    @FXML
    private TextField srchVenda;

    private static List<Venda> itemsCarrinho = new ArrayList<Venda>();
    static List<Venda> listaVendas = new ArrayList<>();

    @FXML
    void confirmar(ActionEvent event) {
        try {

            if (itemsCarrinho.size() > 0) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/VE/TelaVenda.fxml"));
                Parent root = fxmlLoader.load();
                TelaVendaController sr = fxmlLoader.getController();

                sr.addCarrinho(itemsCarrinho);
                sr.printVendas();

                try {
                    sr.mudarTelaVenda(event);
                } catch (Exception e) {
                    e.printStackTrace();
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
        AluguelBO aluguelController = new AluguelBO();

        if (listaVendas.size()==0) {
            listaVendas = new ArrayList<>(aluguelController.listarVendas());
        }else{

        }
        printVendas(listaVendas);
    }

    public void procurarVenda(ActionEvent event) throws Exception {
        AluguelBO VendaController = new AluguelBO();
        String search = srchVenda.getText();

        Venda VendaBase = new Venda();
        VendaBase.setTitulo(search);

        List<Venda> clear = new ArrayList<Venda>();
        listaVendas = clear;

        listaVendas = VendaController.pesquisarVendas(VendaBase);

        printVendas(listaVendas);

        Stage stage = (Stage) confirm.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/VE/SrchItem.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage openStage = new Stage();
        openStage.setScene(new Scene(root1));
        openStage.show();

        System.out.println("Procurando por: " + search);
    }

    public void addItem(Venda item) {
        System.out.println(item.getTitulo() + " addItem");

        itemsCarrinho.add(item);

        for (Venda venda : itemsCarrinho) {
            System.out.println(venda.getTitulo() + " forEach");
        }
    }

    public void printVendas(List<Venda> vendas){
        try {
                for (Venda venda : vendas) {

                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/VE/ListaItem.fxml"));
                    HBox hBox = fxmlLoader.load();
                    ListaItemController ldc = fxmlLoader.getController();

                    ldc.setData(venda);
                    itemsLayout.getChildren().add(hBox);
                }
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the exception appropriately, e.g., show an error message.
            }
    }

    public List<Venda> getItemsCarrinho() {
        return itemsCarrinho;
    }

    public void setItemsCarrinho(List<Venda> items) {
        itemsCarrinho = items;
    }
}
