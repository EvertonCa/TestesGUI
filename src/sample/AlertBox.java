package sample;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox {

    public static void display(String title, String message) {
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Fechar");

        Button botao1 = new Button("Botão 1");
        Button botao2 = new Button("Botão 2");
        Button botao3 = new Button("Botão 3");
        Button botao4 = new Button("Botão 4");

        closeButton.setOnAction(e -> window.close());

        VBox menuEsquerdo = new VBox(10);
        menuEsquerdo.getChildren().addAll(botao1, botao2, botao3, botao4);
        menuEsquerdo.setAlignment(Pos.CENTER);

        HBox menuSuperior = new HBox();
        menuSuperior.getChildren().addAll(label);
        menuSuperior.setAlignment(Pos.CENTER);

        HBox menuInferior = new HBox();
        menuInferior.getChildren().addAll(closeButton);
        menuInferior.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuSuperior);
        borderPane.setLeft(menuEsquerdo);
        borderPane.setBottom(menuInferior);

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(borderPane);
        window.setScene(scene);
        window.showAndWait();
    }

}
