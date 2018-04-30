package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuDrop {

    public static void display()
    {
        window.setTitle("Menu");
        window.setMinWidth(250);


        fileMenu = new Menu("Arquivo");

        MenuItem newFile = new MenuItem("Novo");
        newFile.setOnAction(e -> System.out.println("Clicou em NOVO"));

        fileMenu.getItems().add(newFile);
        fileMenu.getItems().add(new MenuItem("Abrir"));
        fileMenu.getItems().add(new MenuItem("Salvar"));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Configuração"));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Sair"));

        editMenu = new Menu("_Editar");
        editMenu.getItems().add(new MenuItem("blabla"));
        editMenu.getItems().add(new MenuItem("bleble"));
        editMenu.getItems().add(new MenuItem("blibli"));

        MenuItem opcaoApagada = new MenuItem("Apagado");
        opcaoApagada.setDisable(true);

        editMenu.getItems().add(opcaoApagada);

        ajuda = new Menu("Ajuda");
        CheckMenuItem mostrarLinhas = new CheckMenuItem("Mostrar Linhas");
        mostrarLinhas.setOnAction(e -> {
            if(mostrarLinhas.isSelected())
                System.out.println("Selecionado!");
            else
                System.out.println("Nao Selecionado!");
        });
        mostrarLinhas.setSelected(true);

        ajuda.getItems().addAll(mostrarLinhas);

        dificuldade = new Menu("Dificuldade");
        ToggleGroup toggleDificuldade = new ToggleGroup();

        RadioMenuItem facil = new RadioMenuItem("Facil");
        RadioMenuItem medio = new RadioMenuItem("Médio");
        RadioMenuItem dificil = new RadioMenuItem("Dificil");

        facil.setToggleGroup(toggleDificuldade);
        medio.setToggleGroup(toggleDificuldade);
        dificil.setToggleGroup(toggleDificuldade);

        dificuldade.getItems().addAll(facil, medio, dificil);

        barraMenu = new MenuBar();
        barraMenu.getMenus().addAll(fileMenu, editMenu, ajuda, dificuldade);

        layout = new BorderPane();
        layout.setTop(barraMenu);

        scene = new Scene(layout, 400, 300);
        window.setScene(scene);
        window.showAndWait();
    }

    private static Stage window = new Stage();
    private static Scene scene;
    private static BorderPane layout;
    private static Menu fileMenu, editMenu, ajuda, dificuldade;
    private static MenuBar barraMenu;
}
