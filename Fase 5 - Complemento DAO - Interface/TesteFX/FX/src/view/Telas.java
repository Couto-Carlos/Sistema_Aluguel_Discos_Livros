package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application {
    private static Stage primaryStage;


    public static void main (String[] args) {
        launch();
    }


    public static Stage getPrimaryStage() {
        return primaryStage;
    }
    public static void setPrimaryStage(Stage primaryStage) {
        Telas.primaryStage = primaryStage;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        setPrimaryStage(primaryStage);
        primaryStage.setTitle("Livros e Discos do Dudu");
        primaryStage.show();
        telaLogin();
    }


    public static void telaLogin() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("../view/VE/TelaLogin.fxml"));

        Scene cena = new Scene(root);

        primaryStage.setScene(cena);
    }

    public static void telaVenda() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("../view/VE/TelaVenda.fxml"));

        Scene cena = new Scene(root);

        primaryStage.setScene(cena);
    }

    public static void telaEstqDiscos() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("../view/VE/TelaEstqDiscos.fxml"));

        Scene cena = new Scene(root);

        primaryStage.setScene(cena);
    }

    public static void telaEstqLivros() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("../view/VE/TelaEstqLivros.fxml"));

        Scene cena = new Scene(root);

        primaryStage.setScene(cena);
    }

    public static void telaFuncionarios() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("../view/VE/TelaFuncionarios.fxml"));

        Scene cena = new Scene(root);

        primaryStage.setScene(cena);
    }

    public static void telaRelatorio() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaRelatorio.fxml"));

        Scene cena = new Scene(root);

        primaryStage.setScene(cena);
    }
    
    public static void telaClientes() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaClientes.fxml"));

        Scene cena = new Scene(root);

        primaryStage.setScene(cena);
    }
}