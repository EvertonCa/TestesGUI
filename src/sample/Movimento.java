package sample;

import javafx.animation.SequentialTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.animation.*;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Movimento {

    public static void display()
    {
        window.setTitle("Properties");

        botaoSair = new Button("SAIR");
        botaoSair.setOnAction(e -> window.close());

        circulo.setFill(Color.BLACK);
        circulo.setWidth(10);
        circulo.setHeight(5);
        circulo.setLayoutX(50);
        circulo.setLayoutY(50);

        List<Double> posicaoX = new ArrayList<>();
        List<Double> posicaoY = new ArrayList<>();

        posicaoX.add(100.0);
        posicaoY.add(50.0);
        posicaoX.add(100.0);
        posicaoY.add(100.0);
        posicaoX.add(150.0);
        posicaoY.add(100.0);
        posicaoX.add(150.0);
        posicaoY.add(150.0);
        posicaoX.add(200.0);
        posicaoY.add(150.0);

        SequentialTransition tocaTudo = new SequentialTransition();
        tocaTudo.setNode(circulo);

        for(int i = 0; i < 5; i++)
        {
            TranslateTransition animacao = new TranslateTransition();
            animacao.setDuration(Duration.seconds(3));
            animacao.setNode(circulo);
            animacao.setToX(posicaoX.get(i));
            animacao.setToY(posicaoY.get(i));
            tocaTudo.getChildren().add(animacao);

            RotateTransition gira = new RotateTransition();
            gira.setDuration(Duration.seconds(1));
            gira.setNode(circulo);
            gira.setByAngle(90.0);
            tocaTudo.getChildren().add(gira);
        }

        tocaTudo.play();



        Pane layout = new Pane();
        layout.getChildren().add(circulo);

        scene1 = new Scene(layout, 600, 600);
        window.setScene(scene1);
        window.showAndWait();
    }

    private static void setCirculo(double x, double y)
    {
        circulo.setLayoutX(x);
        circulo.setLayoutY(y);
    }

    private static Stage window = new Stage();
    private static Scene scene1, scene2;
    private static Button botaoSair, botao;
    private static Rectangle circulo = new Rectangle();
}
