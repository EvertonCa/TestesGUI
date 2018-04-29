package sample;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

import java.awt.*;

public class DropDownList {
    public static void display()
    {
        window.setTitle("DropDown");
        window.setMinWidth(250);

        botao = new Button("Ok!");

        ChoiceBox <String> dropdown = new ChoiceBox<>();

        dropdown.getItems().add("Texto 1");
        dropdown.getItems().add("Texto 2");
        dropdown.getItems().add("Texto 3");
        dropdown.getItems().addAll("Texto 4", "Texto 5");

        dropdown.setValue("Texto 1");

        //espera por qualquer seleção de item no dropdown
        dropdown.getSelectionModel().selectedIndexProperty().addListener( (v, oldValue, newValue) -> System.out.println(newValue) );

        botao.setOnAction(e -> pegaEscolha(dropdown));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().add(dropdown);
        layout.getChildren().add(botao);


        scene = new Scene(layout, 250,250);

        window.setScene(scene);
        window.showAndWait();

    }

    private static void pegaEscolha(ChoiceBox<String> box)
    {
        System.out.println("Texto selecionado: " + box.getValue());
        window.close();
    }

    static Stage window = new Stage();
    static Scene scene;
    static Button botao;
}
