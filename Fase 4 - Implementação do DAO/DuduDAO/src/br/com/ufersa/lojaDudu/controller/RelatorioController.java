package br.com.ufersa.lojaDudu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RelatorioController extends NavController {
    @FXML private TextField srchDateIni;
    @FXML private TextField srchDateEnd;
    @FXML private Button puCliente;
    @FXML private Button puItem;
    @FXML private Button relatorio;
    
    public void procurarDateIni(ActionEvent event) throws Exception {
        String search = srchDateIni.getText();

        System.out.println("Procurando a partir de: " + search);
    }
    public void procurarDateEnd(ActionEvent event) throws Exception {
        String search = srchDateEnd.getText();

        System.out.println("Procurando até: " + search);
    }

    public void abrirPopUpClientes(ActionEvent event) throws Exception {
        System.out.println("Abrindo Pop-Up <Procurar por Clientes>");
    }
    public void abrirPopUpItems(ActionEvent event) throws Exception {
        System.out.println("Abrindo Pop-Up <Procurar por Items>");
    }
    public void gerarRelatorio(ActionEvent event) throws Exception {
        System.out.println("Abrindo Pop-Up <Gerar Relatorio>");
    }

}
