package week5.SocketChat.Client;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class ClientMain extends Application {
    private Button sendButton;
    @FXML
        private Button myButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        /*primaryStage.setTitle("JChat");
        sendButton = new Button("Send");
        sendButton.setOnAction(e -> System.out.println("Test"));
        StackPane layout = new StackPane();
        layout.getChildren().add(sendButton);
        Scene scene = new Scene(layout, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();*/

       /* Parent root = FXMLLoader.load(getClass().getResource("/FXMLDocument.fxml"));

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        myButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("YYYYAAAP!");
            }
        });
        primaryStage.show();*/
    }



}
