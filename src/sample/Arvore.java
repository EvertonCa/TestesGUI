package sample;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TreeView;
import javafx.scene.control.TreeItem;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

import java.awt.*;

public class Arvore {
    public static void display()
    {
        window.setTitle("TreeView");
        window.setMinWidth(250);

        botao = new Button("Ok!");
        botao.setOnAction(e -> pegaEscolha());

        TreeItem<String> root, ramo1, ramo2, ramo3;

        root = new TreeItem<>();
        root.setExpanded(true);

        ramo1 = makeBranch("NomeDoRamo1", root);
        makeBranch("Blablabla", ramo1);
        makeBranch("Blablabla", ramo1);
        makeBranch("Blablabla", ramo1);

        ramo2 = makeBranch("NomeDoRamo2", root);
        makeBranch("Blablabla", ramo2);
        makeBranch("Blablabla", ramo2);
        makeBranch("Blablabla", ramo2);

        ramo3 = makeBranch("NomeDoRamo3", root);
        makeBranch("Blablabla", ramo3);
        makeBranch("Blablabla", ramo3);
        makeBranch("Blablabla", ramo3);

        tree = new TreeView<>(root);
        tree.setShowRoot(false);

        tree.getSelectionModel().selectedItemProperty()
                .addListener((v, oldValue, newValue) -> {
                    if (newValue != null)
                        System.out.println(newValue.getValue());
                });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().add(tree);
        layout.getChildren().add(botao);


        scene = new Scene(layout, 250,450);

        window.setScene(scene);
        window.showAndWait();

    }

    private static void pegaEscolha()
    {
        window.close();
    }

    private static TreeItem<String> makeBranch(String titulo, TreeItem<String> pai)
    {
        TreeItem<String> item= new TreeItem<>(titulo);
        item.setExpanded(true);
        pai.getChildren().add(item);
        return item;
    }

    static Stage window = new Stage();
    static Scene scene;
    static Button botao;
    static TreeView<String> tree;

}
