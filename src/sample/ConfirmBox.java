package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    public static boolean display(String title, String message) {
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        window.setMinHeight(90);
        Label label = new Label();
        label.setText(message);

        Button yesButtom = new Button("SIM");
        Button noButtom = new Button("NÃO");

        yesButtom.setOnAction(e -> {
            answer = true;
            window.close();
        });

        noButtom.setOnAction(e -> {
            answer = false;
            window.close();
        });

        HBox botoes = new HBox(10);
        VBox layout = new VBox(5);
        botoes.getChildren().addAll( yesButtom, noButtom);
        botoes.setAlignment(Pos.CENTER);

        layout.getChildren().addAll(label, botoes);
        layout.setAlignment(Pos.CENTER);

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }

    static boolean answer;
}
