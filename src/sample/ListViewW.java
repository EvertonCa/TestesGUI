package sample;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

import java.awt.*;

public class ListViewW {
    public static void display()
    {
        window.setTitle("ListView");
        window.setMinWidth(250);

        botao = new Button("Ok!");
        botao.setOnAction(e -> pegaEscolha(true));

        listView = new ListView<>();
        listView.getItems().addAll("Texto 1", "Texto 2", "Texto 3");
        //permite selecionar varios items segurando ctrl
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().add(listView);
        layout.getChildren().add(botao);


        scene = new Scene(layout, 250,250);

        window.setScene(scene);
        window.showAndWait();

    }

    private static void pegaEscolha(boolean fecha)
    {
        ObservableList<String> lista;
        lista = listView.getSelectionModel().getSelectedItems();

        for(String valor:lista)
            System.out.println("Texto selecionado: " + valor);

        if(fecha)
            window.close();
    }

    static Stage window = new Stage();
    static Scene scene;
    static Button botao;
    static ListView <String> listView;

}
