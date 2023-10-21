package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.entity.Relatorio;

public class ListaRelatorioController {


    @FXML private Label cod_alug;
    @FXML private Label cpf_cliente;
    @FXML private Label cod_obj;
    @FXML private Label data_ini;
    @FXML private Label data_end;

    public void setData(Relatorio relatorio) {
        cod_alug.setText("" + relatorio.getNome());
        cpf_cliente.setText("" + relatorio.getTitulo());
        cod_obj.setText("" + relatorio.getValorAluguel());
        data_ini.setText("" + relatorio.getDataAquisicao());
        data_end.setText("" + relatorio.getDataDevolucao());
    }
    // TODO: inserir todos os valores
    // ver nas outras listar

    // acho q é só setData pq não tem botões
    
}