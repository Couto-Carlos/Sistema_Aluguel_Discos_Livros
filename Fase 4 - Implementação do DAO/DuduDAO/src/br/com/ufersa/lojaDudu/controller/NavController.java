package br.com.ufersa.lojaDudu.controller;

// import br.com.ufersa.lojaDudu.model.entity.Funcionario; 
import br.com.ufersa.lojaDudu.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

public class NavController {

    @FXML private Label nomeUsuario;
    @FXML private Label funcUsuario;
    @FXML private Circle funcColor;
    
    public void mudarTelaVenda(ActionEvent event) throws Exception {
        Telas.telaVenda();
    }
    public void mudarTelaEstqLivros(ActionEvent event) throws Exception {
        Telas.telaEstqLivros();
    }
    public void mudarTelaEstqDiscos(ActionEvent event) throws Exception {
        Telas.telaEstqDiscos();
    }
    public void mudarTelaClientes(ActionEvent event) throws Exception {
        Telas.telaClientes();
    }
    public void mudarTelaRelatorio(ActionEvent event) throws Exception {
        Telas.telaRelatorio();
    }
    public void mudarTelaFuncionarios(ActionEvent event) throws Exception {
        Telas.telaFuncionarios();
    }
    public void mudarTelaLogin(ActionEvent event) throws Exception {
        Telas.telaLogin();
    }

    /* Usado quando conectar com o DAO (Muda a cor da Funcao do Usuario logado no app)
    public void userLogin(Funcionario func) {
        nomeUsuario.setText(func.getNome());
        funcUsuario.setText(func.getFuncao());
        if (func.getFuncao() == "Funcionario") {
            funcColor.setStyle("-fx-stroke: #6ee364");
            funcColor.setStyle("-fx-fill: #5eb357");
            funcUsuario.setStyle("-fx-text-fill: #5eb357");
        } else 
        if (func.getFuncao() == "Administrador") {
            funcColor.setStyle("-fx-stroke: #a45cff");
            funcColor.setStyle("-fx-fill: #883de9");
            funcUsuario.setStyle("-fx-text-fill: #883de9");
        } else {
            funcColor.setStyle("-fx-stroke: grey");
            funcColor.setStyle("-fx-fill: white");
            funcUsuario.setStyle("-fx-text-fill: grey");
        }
    }
    */
}
