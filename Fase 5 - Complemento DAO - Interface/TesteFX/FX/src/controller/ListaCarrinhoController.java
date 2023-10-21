package controller;

import model.entity.Venda;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ListaCarrinhoController {    
    
    @FXML private Label id;
    @FXML private Label titulo;
    @FXML private Label quant_uni;
    @FXML private Label preco_uni;
    @FXML private Button delete;

    private Venda selectedVenda;

    @FXML
    void deletePU(ActionEvent event) {
        try {

            TelaVendaController.getCarrinhoVenda().remove(selectedVenda);

            SrchItemController si = new SrchItemController();
            si.getItemsCarrinho().remove(selectedVenda);

            NavController e = new NavController();
            e.mudarTelaVenda(event);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setData() { // apenas para teste (REMOVA)
        titulo.setText("....");
        quant_uni.setText("....");
        preco_uni.setText("....");
    }
    public void setData(Venda venda) {

        setSelectedVenda(venda);
        
        titulo.setText(venda.getTitulo());
        // +venda.getTitulo()
        quant_uni.setText("" + venda.getQuantidadeExemplares());
        // +venda.getQuantidadeExemplares()
        preco_uni.setText("" + venda.getValorAluguel());
        // +venda.getValorAluguel()
    }


    public Venda getSelectedVenda() {
        return selectedVenda;
    }

    public void setSelectedVenda(Venda selectedVenda) {
        this.selectedVenda = selectedVenda;
    }

}
