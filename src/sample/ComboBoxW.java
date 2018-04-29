package sample;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

import java.awt.*;

public class ComboBoxW {
    public static void display()
    {
        window.setTitle("ComboBox");
        window.setMinWidth(250);

        botao = new Button("Ok!");
        botao.setOnAction(e -> pegaEscolha(true));

        comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Texto 1", "Texto 2", "Text0 3");

        comboBox.setPromptText("Texto inicial");
        comboBox.setEditable(true);

        comboBox.setOnAction( e -> pegaEscolha(false));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().add(comboBox);
        layout.getChildren().add(botao);


        scene = new Scene(layout, 250,250);

        window.setScene(scene);
        window.showAndWait();

    }

    private static void pegaEscolha(boolean fecha)
    {
        System.out.println("Texto selecionado: " + comboBox.getValue());
        if(fecha)
            window.close();
    }

    static Stage window = new Stage();
    static Scene scene;
    static Button botao;
    static ComboBox <String> comboBox;

}
