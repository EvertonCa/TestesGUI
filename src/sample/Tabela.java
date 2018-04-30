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

        botaoSair = new Button("SAIR");
        botaoSair.setOnAction(e -> window.close());


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

        nameInput = new TextField();
        nameInput.setPromptText("Nome");
        nameInput.setMinWidth(100);

        priceInput = new TextField();
        priceInput.setPromptText("Preço");
        priceInput.setMinWidth(100);

        quantityInput = new TextField();
        quantityInput.setPromptText("Quantidade");
        quantityInput.setMinWidth(100);

        botaoAdd = new Button("Adicionar");
        botaoAdd.setOnAction(e -> addicionarProdutos());
        botaoDeletar = new Button("Apagar");
        botaoDeletar.setOnAction(e -> deletarProduto());

        table = new TableView<>();
        table.setItems(getProduto());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);

        HBox hboxInputs = new HBox(10);
        hboxInputs.setPadding(new Insets(10,10,10,10));
        hboxInputs.getChildren().addAll(nameInput, priceInput, quantityInput);

        HBox hboxBotoes = new HBox(10);
        hboxBotoes.setPadding(new Insets(10,10,10,10));
        hboxBotoes.setAlignment(Pos.CENTER);
        hboxBotoes.getChildren().addAll(botaoAdd, botaoDeletar, botaoSair);

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(table, hboxInputs, hboxBotoes);
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

    public static void addicionarProdutos()
    {
        Produto produto = new Produto();
        produto.setNome(nameInput.getText());
        produto.setPreco(Double.parseDouble(priceInput.getText()));
        produto.setQuantidade(Integer.parseInt(quantityInput.getText()));
        table.getItems().add(produto);
        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();
    }

    public static void deletarProduto()
    {
        ObservableList<Produto> produtosSelecionados, todosOsProdutos;
        todosOsProdutos = table.getItems();
        produtosSelecionados = table.getSelectionModel().getSelectedItems();

        produtosSelecionados.forEach(todosOsProdutos::remove);
    }

    private static TableView<Produto> table;
    private static Stage window = new Stage();
    private static Scene scene;
    private static Button botaoSair, botaoAdd, botaoDeletar;
    private static TextField nameInput, priceInput, quantityInput;

}
