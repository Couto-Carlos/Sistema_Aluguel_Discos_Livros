package controller;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.bo.AluguelBO;
import model.entity.Cliente;
import model.entity.Disco;
import model.entity.Relatorio;

public class TelaRelatorioController extends NavController {

    @FXML
    private Label vendaTotal;
    @FXML
    private Label vendaDiscos;
    @FXML
    private Label vendaLivros;
    @FXML
    private TextField srchCliente;
    @FXML
    private Label lucroSemana;
    @FXML
    private VBox aluguelLayout;
    @FXML
    private DatePicker pickDate;

    static List<Relatorio> listaRelatorios = new ArrayList<>();

    @FXML
    void pesquisarData(ActionEvent event) throws Exception {

        LocalDate search = pickDate.getValue(); // data retorna LocalDate
        Date sqlDate = Date.valueOf(search);

        Relatorio relatorioBase = new Relatorio();
        relatorioBase.setDataDevolucao(sqlDate);

        AluguelBO relatorioController = new AluguelBO();

        List<Relatorio> clear = new ArrayList<Relatorio>();
        listaRelatorios = clear;

        
        listaRelatorios = relatorioController.pesquisarRelatorios(relatorioBase);
        if(listaRelatorios.size() == 0){
            Date dataNula = new Date(0, 0, 0);
            listaRelatorios.add(new Relatorio("----","-----",00,dataNula,dataNula));
        }

        NavController e = new NavController();
        e.mudarTelaRelatorio(event);

        System.out.println(search);
    }

    @FXML
    void procurarCliente(ActionEvent event) throws Exception {
        Relatorio relatorioBase = new Relatorio();
        relatorioBase.setNome(srchCliente.getText());

        AluguelBO relatorioController = new AluguelBO();

        List<Relatorio> clear = new ArrayList<Relatorio>();
        listaRelatorios = clear;

        listaRelatorios = relatorioController.pesquisarRelatoriosNome(relatorioBase);
        if(listaRelatorios.size() == 0){
            listaRelatorios = relatorioController.listarRelatorios();
        }

        NavController e = new NavController();
        e.mudarTelaRelatorio(event);
    }

    public void initialize() {
        // ------ Parte de Teste -------//
        isGerente();
        showUserLogin();

        AluguelBO controllerRelatorio = new AluguelBO();

        vendaLivros.setText("" + controllerRelatorio.mostrarLivrosSemanal());
        vendaDiscos.setText("" + controllerRelatorio.mostrarDiscosSemanal());
        vendaTotal.setText("" + (controllerRelatorio.mostrarDiscosSemanal() + controllerRelatorio.mostrarLivrosSemanal()));
        lucroSemana.setText("" + controllerRelatorio.mostrarLucroSemanal());
        // -----------------------------//

        System.out.println(listaRelatorios.size());
        if(listaRelatorios.size() == 0){
            listaRelatorios = new ArrayList<>(controllerRelatorio.listarRelatorios());
        }else{

        }
        printRelatorios(listaRelatorios);
    }

    public void printRelatorios(List<Relatorio> relatorios) {
        try {
            for (Relatorio relatorio : relatorios) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/VE/ListaRelatorio.fxml"));
                HBox hBox = fxmlLoader.load();

                ListaRelatorioController lc = fxmlLoader.getController();
                lc.setData(relatorio);

                aluguelLayout.getChildren().add(hBox);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    // TODO: VendaTotal coloca a soma de todas as vendas, pegar do BD

    // TODO: VendaDiscos venda das vendas de discos pegar do BD
    // TODO: VendaLivros venda das vendas de livros pegar do BD

    // TODO: LucroSemana soma de todos os preços das vendas feitas

    // TODO: AluguelLayout coloca os items dinamicos em uma lista

    // TODO: pesquisarData busca uma data no Banco de Dados e filtra a lista de
    // alugueis

}
