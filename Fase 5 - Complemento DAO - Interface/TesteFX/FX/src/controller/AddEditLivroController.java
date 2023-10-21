package controller;

import model.bo.LivroBO;
import model.entity.Disco;
import model.entity.Livro;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddEditLivroController {

    @FXML
    private TextField nome;
    @FXML
    private TextField autor;
    @FXML
    private TextField genero;
    @FXML
    private TextField ano; // DATE
    @FXML
    private TextField paginas;
    @FXML
    private TextField quantEstq;
    @FXML
    private TextField preco;
    @FXML
    private Button confirm;
    @FXML
    private Label erroTitulo;

    private Livro selectedLivro;

    @FXML
    void confirmar(ActionEvent event) throws Exception {
        System.out.println("pop-up aberto");
        Stage stage = (Stage) confirm.getScene().getWindow();

        Livro livro = new Livro();
        livro.setTitulo(nome.getText());
        livro.setAutor(autor.getText());
        livro.setGenero(genero.getText());
        livro.setdataLancamento(Date.valueOf(ano.getText()));
        livro.setQuantidadePaginas(Integer.parseInt(paginas.getText()));
        livro.setQuantidadeExemplares(Integer.parseInt(quantEstq.getText()));
        livro.setValorAluguel(Float.parseFloat(preco.getText()));

        LivroBO livroController = new LivroBO();

        if (selectedLivro == null) {
            System.out.println("CRIARLIVRO");
            Livro autenticaLivro = livroController.pesquisaTitulo(livro);
            if (autenticaLivro == null) {
                livroController.criar(livro);

                List<Livro> clear = new ArrayList<Livro>();
                TelaEstqLivroController.listaLivros = clear;

                TelaEstqLivroController.listaLivros = livroController.listar();

                NavController e = new NavController();
                e.mudarTelaEstqLivros(event);
                stage.close();
            } else {
                erroTitulo.setVisible(true);
            }
        } else {
            System.out.println("EDITARLIVRO");
            livro.setId(selectedLivro.getId());

            Livro autenticaLivro = livroController.pesquisaTitulo(livro);
            if (autenticaLivro == null || autenticaLivro.getTitulo().equals(selectedLivro.getTitulo())) {
                livroController.alterar(livro);

                List<Livro> clear = new ArrayList<Livro>();
                TelaEstqLivroController.listaLivros = clear;

                TelaEstqLivroController.listaLivros = livroController.listar();

                NavController e = new NavController();
                e.mudarTelaEstqLivros(event);
                stage.close();
            } else {
                erroTitulo.setVisible(true);
            }
        }

    }

    public void setData(Livro livro) {

        setSelectedlLivro(livro);
        nome.setText(livro.getTitulo());
        autor.setText(livro.getAutor());
        genero.setText(livro.getGenero());

        ano.setText("" + livro.getdataLancamento());
        paginas.setText("" + livro.getQuantidadePaginas());
        quantEstq.setText("" + livro.getQuantidadeExemplares());
        preco.setText("" + livro.getValorAluguel());
    }

    public void setSelectedlLivro(Livro selectedLivro) {
        this.selectedLivro = selectedLivro;
    }

    public Livro getSelectedlLivro() {
        return selectedLivro;
    }

}
