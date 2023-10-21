package controller;

import model.bo.DiscoBO;
import model.entity.Disco;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddEditDiscoController {

    @FXML
    private Label erroTitulo;

    @FXML
    private TextField nome;
    @FXML
    private TextField banda;
    @FXML
    private TextField estilo;
    @FXML
    private TextField quantEstq;
    @FXML
    private TextField preco;
    @FXML
    private Button confirm;

    private Disco selectedDisco;

    @FXML
    void confirmar(ActionEvent event) throws Exception {
        System.out.println("pop-up aberto");
        Stage stage = (Stage) confirm.getScene().getWindow();
        Disco disco = new Disco();

        disco.setTitulo(nome.getText());
        disco.setNomeBanda(banda.getText());
        disco.setEstilo(estilo.getText());
        disco.setQuantidadeExemplares(Integer.parseInt(quantEstq.getText()));
        disco.setValorAluguel(Float.parseFloat(preco.getText()));

        DiscoBO discoController = new DiscoBO();

        if (selectedDisco == null) {
            Disco autenticarDisco = discoController.autenticarTitulo(disco);
            if (autenticarDisco == null) {
                discoController.criar(disco);

                List<Disco> clear = new ArrayList<Disco>();
                TelaEstqDiscoController.listaDiscos = clear;

                TelaEstqDiscoController.listaDiscos = discoController.listar();

                NavController e = new NavController();
                e.mudarTelaEstqDiscos(event);
                stage.close();
            } else {
                erroTitulo.setVisible(true);
                // TEXT NO ADDEDITDISCOCONTROLLER JÁ EXISTE ESTE TITULO
            }

        } else {
            disco.setId(selectedDisco.getId());

            System.out.println("AUTENTICAR ALTERAR");
            Disco autenticarDisco = discoController.autenticarTitulo(disco);
            if (autenticarDisco == null || autenticarDisco.getTitulo().equals(selectedDisco.getTitulo())) {
                discoController.alterar(disco);

                List<Disco> clear = new ArrayList<Disco>();
                TelaEstqDiscoController.listaDiscos = clear;

                TelaEstqDiscoController.listaDiscos = discoController.listar();

                NavController e = new NavController();
                e.mudarTelaEstqDiscos(event);
                stage.close();
            } else {
                erroTitulo.setVisible(true);
                // TEXT NO ADDEDITDISCOCONTROLLER JÁ EXISTE ESTE TITULO
            }
        }

    }

    public void setData(Disco disco) {

        setSelectedDisco(disco);
        System.out.println(disco.getId());
        nome.setText(disco.getTitulo());
        banda.setText(disco.getNomeBanda());
        estilo.setText(disco.getEstilo());
        quantEstq.setText("" + disco.getQuantidadeExemplares());
        preco.setText("" + disco.getValorAluguel());
    }

    public Disco getSelectedDisco() {
        return selectedDisco;
    }

    public void setSelectedDisco(Disco selectedDisco) {
        this.selectedDisco = selectedDisco;
    }

}
