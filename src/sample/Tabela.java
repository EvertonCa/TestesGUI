package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Tabela {

    public static void display()
    {
        window.setTitle("TableView");
        window.setMinWidth(250);

        botao = new Button("Ok!");
        botao.setOnAction(e -> window.close());


        //Name column
        TableColumn<Produto, String> nameColumn = new TableColumn<>("Nome");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));

        //Price column
        TableColumn<Produto, Double> priceColumn = new TableColumn<>("Preco");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("preco"));

        //Quantity column
        TableColumn<Produto, Integer> quantityColumn = new TableColumn<>("Quantidade");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantidade"));

        table = new TableView<>();
        table.setItems(getProduto());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(table, botao);
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.setAlignment(Pos.CENTER);

        scene = new Scene(vBox);
        window.setScene(scene);
        window.showAndWait();
    }

    public static ObservableList<Produto> getProduto(){
        ObservableList<Produto> produtos = FXCollections.observableArrayList();
        produtos.add(new Produto("Laptop", 859.00, 20));
        produtos.add(new Produto("Bouncy Ball", 2.49, 198));
        produtos.add(new Produto("Toilet", 99.00, 74));
        produtos.add(new Produto("The Notebook DVD", 19.99, 12));
        produtos.add(new Produto("Corn", 1.49, 856));
        return produtos;
    }

    private static TableView<Produto> table;
    private static Stage window = new Stage();
    private static Scene scene;
    private static Button botao;
}
