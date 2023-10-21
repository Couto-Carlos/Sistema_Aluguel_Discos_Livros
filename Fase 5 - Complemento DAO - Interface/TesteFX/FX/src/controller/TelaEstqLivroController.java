package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import model.bo.LivroBO;
import model.entity.Disco;
import model.entity.Livro;
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

public class TelaEstqLivroController extends NavController {

    @FXML
    private Button botaoAdicionar;
    @FXML
    private TextField srchLivro;
    @FXML
    private VBox livrosLayout;

    static List<Livro> listaLivros = new ArrayList<>();

    public void procurarLivro(ActionEvent event) throws Exception {
        String search = srchLivro.getText();
        Livro livroBase = new Livro();
        livroBase.setTitulo(search);

        List<Livro> clear = new ArrayList<Livro>();
        listaLivros = clear;

        LivroBO livroController = new LivroBO();
        listaLivros = livroController.pesquisaTotal(livroBase);

        printLivros(listaLivros);

        NavController e = new NavController();
        e.mudarTelaEstqLivros(event);

        System.out.println("Procurando por: " + search);
    }

    public void adicionarLivro(ActionEvent event) throws Exception {
        System.out.println("Livro Adicionado.");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/VE/AddEditLivro.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void initialize() {
        isGerente();
        showUserLogin();
        LivroBO controllerLivro = new LivroBO();
        System.out.println(listaLivros.size());
        if (listaLivros.size() == 0) {
            listaLivros = new ArrayList<>(controllerLivro.listar());
        } else {
            System.out.println("LISTA COM ITENS");
        }

        printLivros(listaLivros);
    }

    public void printLivros(List<Livro> livros) {
        try {

            for (Livro livro : livros) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/VE/ListaLivro.fxml"));
                HBox hBox = fxmlLoader.load();
                ListaLivroController ldc = fxmlLoader.getController();
                ldc.setData(livro);
                ldc.userPermissions(isGerente());
                botaoAdicionar.setDisable(!isGerente());
                livrosLayout.getChildren().add(hBox);

            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., show an error message.
        }
    }
}
