package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import java.awt.*;

public class PropertiesW {
    public static void display()
    {
        window.setTitle("Properties");
        window.setMinWidth(250);

        botaoSair = new Button("SAIR");
        botaoSair.setOnAction(e -> window.close());

        TextField userInput = new TextField();
        userInput.setMaxWidth(300);

        Label primeiroLabel = new Label("Bem vindo: ");
        Label segundoLabel = new Label();

        Pessoa pessoa = new Pessoa();
        pessoa.primeiroNomeProperty().addListener( (v, oldValue, newValue) -> {
            System.out.println("Nome mudou para " + newValue);
            System.out.println("primeiroNomeProperty(): " + pessoa.primeiroNomeProperty());
            System.out.println("Get Primeiro Nome: " + pessoa.getPrimeiroNome());
        } );

        botao = new Button("Enviar");
        botao.setOnAction( e ->
        {
            pessoa.setPrimeiroNome("Exemplo");
        });

        segundoLabel.textProperty().bind(userInput.textProperty());

        HBox layoutText = new HBox(10);
        layoutText.getChildren().addAll(userInput);
        layoutText.setAlignment(Pos.CENTER);

        HBox layoutMensagens = new HBox(primeiroLabel, segundoLabel);
        layoutMensagens.setAlignment(Pos.CENTER);

        HBox layoutBotoes = new HBox(10);
        layoutBotoes.getChildren().addAll(botao, botaoSair);
        layoutBotoes.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(layoutText,layoutBotoes, layoutMensagens);

        scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();


    }

    private static Stage window = new Stage();
    private static Scene scene;
    private static Button botaoSair, botao;
}
