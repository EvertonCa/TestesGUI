package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Teste GUI");
        botaoDeConfirmBox = new Button("Mudar Tema");
        botaoDeConfirmBox.setStyle("-fx-background-color: cornsilk");
        botaoParaFecharPrograma = new Button("FECHAR");

        //metodo chamado quando o botão para fechar o programa é clicado.
        window.setOnCloseRequest(e -> {
            e.consume(); //"consome" o request do sistema para fechar o programa e deixa a ação do botao para o metodo.
            fecharPrograma();
        });

        botaoDeConfirmBox.setOnAction(e -> {
            boolean result = ConfirmBox.display("TITULO DA JANELA", "Você tem certeza?");
            if(result)
            {
                setUserAgentStylesheet(STYLESHEET_CASPIAN);
            }
        });

        botaoParaFecharPrograma.setOnAction(e -> {
            fecharPrograma();
        });

        botao1 = new Button("AlertBox BorderPane");
        botao2 = new Button("DropDown List ");
        botao3 = new Button("ComboBox");
        botao4 = new Button("ListView");
        botao5 = new Button("TreeView");
        botao6 = new Button("TableView");
        botao7 = new  Button("Menu");

        botao1.setOnAction(e -> AlertBox.display("TITULO", "MENSAGEM DE TESTE"));
        botao2.setOnAction(e -> DropDownList.display());
        botao3.setOnAction(e -> ComboBoxW.display());
        botao4.setOnAction(e -> ListViewW.display());
        botao5.setOnAction(e -> Arvore.display());
        botao6.setOnAction(e -> Tabela.display());
        botao7.setOnAction(e -> MenuDrop.display());


        VBox menuEsquerdo = new VBox(5);
        menuEsquerdo.getChildren().addAll(botao1, botao2, botao3, botao4, botao5, botao6, botao7);
        menuEsquerdo.setAlignment(Pos.CENTER);

        HBox menuSuperior = new HBox(5);
        menuSuperior.getChildren().addAll(botaoDeConfirmBox, botaoParaFecharPrograma);
        menuSuperior.setAlignment(Pos.CENTER_LEFT);

        GridPane grid = new GridPane(); //layout formato "tabela"
        grid.setPadding(new Insets(10,10,10,10)); //bordas do layout em px
        grid.setVgap(8); //gap vertical entre os elementos
        grid.setHgap(10); //gap horizontal entre os elementos

        Label nameLabel = new Label("Usuario:");
        grid.setConstraints(nameLabel, 0, 0); //posiciona o objeto no indice da matriz

        TextField nameInput = new TextField("Texto Padrão Editavel");
        grid.setConstraints(nameInput, 1,0);

        Label passwordLabel = new Label("Senha:");
        grid.setConstraints(passwordLabel, 0, 1); //posiciona o objeto no indice da matriz

        TextField passwordInput = new TextField();
        passwordInput.setPromptText("Senha"); // mostra fantasma do texto
        grid.setConstraints(passwordInput, 1,1);

        Button login = new Button("LOGIN");
        login.setOnAction(e ->{
            System.out.println("Usuario: " + nameInput.getText());
            System.out.println("Senha: " + passwordInput.getText());
        });
        grid.setConstraints(login, 1, 2);

        grid.getChildren().addAll(nameLabel, nameInput, passwordLabel, passwordInput, login);

        CheckBox box1 = new CheckBox("Blabla");
        box1.setSelected(true);
        CheckBox box2 = new CheckBox("Bleble");

        Button checkBoxButtom = new Button("Verifica");
        checkBoxButtom.setOnAction(e -> {
            verificaOpcoes(box1, box2);
        });

        VBox menuDireito = new VBox(10);
        menuDireito.getChildren().addAll(box1, box2, checkBoxButtom);
        menuDireito.setAlignment(Pos.TOP_CENTER);
        menuDireito.setPadding(new Insets(10, 10, 10, 10));


        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuSuperior);
        borderPane.setLeft(menuEsquerdo);
        borderPane.setCenter(grid);
        borderPane.setRight(menuDireito);

        Scene scene = new Scene(borderPane, 600, 600);
        scene.getStylesheets().add("Theme.css");
        window.setScene(scene);
        window.show();
    }

    private void fecharPrograma()
    {
        boolean resposta = ConfirmBox.display("Fechar programa", "Você tem certeza que deseja fechar?");
        if(resposta)
            window.close();

    }

    private void verificaOpcoes(CheckBox box1, CheckBox box2)
    {
        if(box1.isSelected())
        {
            System.out.println("Selecionou " + box1.getText());
        }
        if(box2.isSelected())
        {
            System.out.println("Selecionou " + box2.getText());
        }

    }

    Stage window;
    Button botaoDeConfirmBox, botaoParaFecharPrograma, botao1, botao2, botao3, botao4, botao5, botao6, botao7;

}