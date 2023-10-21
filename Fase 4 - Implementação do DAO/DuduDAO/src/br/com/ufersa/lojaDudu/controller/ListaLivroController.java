package br.com.ufersa.lojaDudu.controller;

import java.io.IOException;

import br.com.ufersa.lojaDudu.model.entity.Livro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ListaLivroController {
    @FXML private Label id;
    @FXML private Label titulo;
    @FXML private Label autor;
    @FXML private Label genero;
    @FXML private Label ano;
    @FXML private Label quant_pag;
    @FXML private Label quant_stq;
    @FXML private Label preco_uni;
    @FXML private Button delete;
    @FXML private Button editar;

    private Livro selectedLivro;

    @FXML
    void deletePU(ActionEvent event) {
        System.out.println("<Abrindo Pop-Up Confirmação>");

    }

    @FXML
    void editarPU(ActionEvent event) {
        System.out.println("<Abrindo Pop-Up AddEditLivro>");

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/ufersa/lojaDudu/view/VE/AddEditLivro.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            
            // preenche a tela aberta con os dados desse funcionario
            AddEditLivroController aef = fxmlLoader.getController();
            aef.setData(getSelectedLivro());

            stage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void setData(Livro livros) {
        
        setSelectedLivro(livros);
        id.setText(Long.toString(livros.getId()));
        titulo.setText(livros.getTitulo());
        autor.setText(livros.getAutor());
        genero.setText(livros.getGenero());
        ano.setText(livros.getAnoLancamento());
        quant_pag.setText(Integer.toString(livros.getPaginas()));
        quant_stq.setText(Integer.toString(livros.getQuantEstq()));
        preco_uni.setText(Double.toString(livros.getValorAluguel()));
    }
    
    // visibilidade dos controles para somente gerentes
    public void userPermissions(Boolean controlVisibility) {
        editar.setVisible(controlVisibility);
        editar.setManaged(controlVisibility);
        delete.setVisible(controlVisibility);
        delete.setManaged(controlVisibility);
    }
    
    public Livro getSelectedLivro() { return selectedLivro; }

    public void setSelectedLivro(Livro selectedLivro) {
        this.selectedLivro = selectedLivro;
    }

}
