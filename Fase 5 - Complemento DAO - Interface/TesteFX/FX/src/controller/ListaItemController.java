package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.entity.Venda;

public class ListaItemController {
    
    @FXML private Label titulo;
    @FXML private Label quant_uni;
    @FXML private Label preco_uni;
    @FXML private Button add;
    
    private Venda selectedItem;


    @FXML
    void adicionar(ActionEvent event) {
        System.out.println("<Produto Adicionado>");
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/VE/SrchItem.fxml"));
        
        try {
            Parent root = fxmlLoader.load();
            
            SrchItemController cl = fxmlLoader.getController();
            cl.addItem(selectedItem);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setData() {
        titulo.setText("....");
        quant_uni.setText("....");
        preco_uni.setText("....");
    }
    public void setData(Venda venda) {

        this.selectedItem = venda;
        
        titulo.setText(venda.getTitulo());
        // +venda.getTitulo()
        quant_uni.setText("" + venda.getQuantidadeExemplares());
        // +venda.getQuantidadeExemplares()
        preco_uni.setText("" + venda.getValorAluguel());
        // +venda.getValorAluguel()
    }
}
