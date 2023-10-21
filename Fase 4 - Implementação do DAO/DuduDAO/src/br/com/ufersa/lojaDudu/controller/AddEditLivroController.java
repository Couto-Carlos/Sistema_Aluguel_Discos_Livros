package br.com.ufersa.lojaDudu.controller;

import br.com.ufersa.lojaDudu.model.entity.Livro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddEditLivroController {
    
    @FXML private TextField nome;
    @FXML private TextField autor;
    @FXML private TextField genero;
    @FXML private TextField ano;
    @FXML private TextField paginas;
    @FXML private TextField quantEstq;
    @FXML private TextField preco;
    @FXML private Button confirm;

    @FXML void confirmar(ActionEvent event) {
        System.out.println("pop-up aberto");
        Stage stage = (Stage) confirm.getScene().getWindow();
        stage.close();
    }

    public void setData(Livro livro) {

        nome.setText(livro.getTitulo());
        autor.setText(livro.getAutor());
        genero.setText(livro.getGenero());
        ano.setText(livro.getAnoLancamento());
        paginas.setText(Integer.toString(livro.getPaginas()));
        quantEstq.setText(Integer.toString(livro.getQuantEstq()));
        preco.setText(Double.toString(livro.getValorAluguel()));
    }

}
