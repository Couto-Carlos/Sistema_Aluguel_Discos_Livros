package br.com.ufersa.lojaDudu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufersa.lojaDudu.model.entity.Livro;
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

public class EstqLivroController extends NavController {
    @FXML private TextField srchLivro;
    @FXML private Button addLivro;
    @FXML private VBox livrosLayout;
    
    public void procurarLivro(ActionEvent event) throws Exception {
        String search = srchLivro.getText();

        System.out.println("Procurando por: " + search);
    }

    public void adicionarLivro(ActionEvent event) throws Exception {
        System.out.println("Livro Adicionado.");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/ufersa/lojaDudu/view/VE/AddEditLivro.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }
    
    public void initialize() {
        try {
            List<Livro> livros = new ArrayList<>(livroTeste());

            for (Livro livro : livros) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/ufersa/lojaDudu/view/VE/ListaLivro.fxml"));
                HBox hBox = fxmlLoader.load();
                ListaLivroController ldc = fxmlLoader.getController();
                ldc.setData(livro);
                ldc.userPermissions(true);
                livrosLayout.getChildren().add(hBox);
                
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., show an error message.
        }
    }

    private List<Livro> livroTeste() {
        List<Livro> ls = new ArrayList<>();
        
        Livro livro1 = new Livro("livro1", "autor1", "Unico", "01/01/2001", 10, 1, 999.99);
        ls.add(livro1);
        Livro livro2 = new Livro("livro2", "autor2", "Unico", "01/01/2002", 20, 1, 999.99);
        ls.add(livro2);
        Livro livro3 = new Livro("livro3", "autor3", "Unico", "01/01/2003", 30, 1, 999.99);
        ls.add(livro3);
        Livro livro4 = new Livro("livro4", "autor4", "Unico", "01/01/2004", 40, 1, 999.99);
        ls.add(livro4);
        Livro livro5 = new Livro("livro5", "autor5", "Unico", "01/01/2005", 50, 1, 999.99);
        ls.add(livro5);
        Livro livro6 = new Livro("livro6", "autor6", "Unico", "01/01/2006", 60, 1, 999.99);
        ls.add(livro6);
        ls.add(livro6);
        ls.add(livro6);
        ls.add(livro6);
        ls.add(livro6);
        ls.add(livro6);
        ls.add(livro6);
        ls.add(livro6);
        ls.add(livro6);
        

        return ls;
        
    }
}
