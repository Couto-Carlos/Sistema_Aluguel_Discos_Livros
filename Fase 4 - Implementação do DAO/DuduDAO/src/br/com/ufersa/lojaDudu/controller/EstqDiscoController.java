package br.com.ufersa.lojaDudu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufersa.lojaDudu.model.entity.Disco;
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

public class EstqDiscoController extends NavController {
    @FXML private TextField srchDisco;
    @FXML private Button addDisco;
    @FXML private VBox discosLayout;
    
    public void procurarDisco(ActionEvent event) throws Exception {
        String search = srchDisco.getText();

        System.out.println("Procurando por: " + search);
    }

    public void adicionarDisco(ActionEvent event) throws Exception {
        System.out.println("Disco Adicionado.");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/ufersa/lojaDudu/view/VE/AddEditDisco.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }
    
    public void initialize() {
        try {
            List<Disco> discos = new ArrayList<>(discosTeste());

            for (Disco disco : discos) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/ufersa/lojaDudu/view/VE/ListaDisco.fxml"));
                HBox hBox = fxmlLoader.load();
                ListaDiscoController ldc = fxmlLoader.getController();
                ldc.setData(disco);
                ldc.userPermissions(true);
                discosLayout.getChildren().add(hBox);
                
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., show an error message.
        }
    }

    private List<Disco> discosTeste() {
        List<Disco> ls = new ArrayList<>();
        
        Disco disco1 = new Disco("Disco1", "Banda1", "Unico", 1, 999.99);
        ls.add(disco1);
        Disco disco2 = new Disco("Disco2", "Banda2", "Unico", 2, 999.99);
        ls.add(disco2);
        Disco disco3 = new Disco("Disco3", "Banda3", "Unico", 3, 999.99);
        ls.add(disco3);
        Disco disco4 = new Disco("Disco4", "Banda4", "Unico", 4, 999.99);
        ls.add(disco4);
        Disco disco5 = new Disco("Disco5", "Banda5", "Unico", 5, 999.99);
        ls.add(disco5);
        Disco disco6 = new Disco("Disco6", "Banda6", "Unico", 6, 999.99);
        ls.add(disco6);
        ls.add(disco6);
        ls.add(disco6);
        ls.add(disco6);
        ls.add(disco6);
        ls.add(disco6);
        ls.add(disco6);
        ls.add(disco6);
        ls.add(disco6);
        

        return ls;
        
    }

}
