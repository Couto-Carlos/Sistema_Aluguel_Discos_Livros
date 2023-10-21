package controller;

import view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import model.entity.Funcionario;

public class NavController {

    @FXML private Label nomeUsuario;
    @FXML private Label funcUsuario;
    @FXML private Circle funcColor;

    @FXML
    private Button funcBotao;

    public static Funcionario funcionarioLogado;
    
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

    public Boolean isGerente(){
        System.out.println(funcionarioLogado.getFuncao());

        if (funcionarioLogado.getFuncao().equals("Gerente")) {
            System.out.println("é gerente");
            return true;
        }else{
            funcBotao.setManaged(false);
            funcBotao.setVisible(false);
            return false;
        }
    }

    public static Funcionario getFuncionarioLogado() {
        return funcionarioLogado;
    }
    public static void setFuncionarioLogado(Funcionario funcionarioLogado) {
        NavController.funcionarioLogado = funcionarioLogado;
    }
    // Usado quando conectar com o DAO (Muda a cor da Funcao do Usuario logado no app)
    public void showUserLogin() {
        nomeUsuario.setText(funcionarioLogado.getLogin());
        funcUsuario.setText(funcionarioLogado.getFuncao());
        if (funcionarioLogado.getFuncao().equals("Funcionario")) {
            funcColor.setStyle("-fx-stroke: #6ee364");
            funcColor.setStyle("-fx-fill: #5eb357");
            funcUsuario.setStyle("-fx-text-fill: #5eb357");
        } else 
        if (funcionarioLogado.getFuncao().equals("Gerente")) {
            funcColor.setStyle("-fx-stroke: #a45cff");
            funcColor.setStyle("-fx-fill: #883de9");
            funcUsuario.setStyle("-fx-text-fill: #883de9");
        } else {
            funcColor.setStyle("-fx-stroke: grey");
            funcColor.setStyle("-fx-fill: white");
            funcUsuario.setStyle("-fx-text-fill: grey");
        }
    }
    
}
