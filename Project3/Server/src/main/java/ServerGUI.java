import java.util.HashMap;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;

import javafx.event.EventHandler;
import javafx.geometry.Insets;

import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.net.ServerSocket;
import java.net.Socket;


public class ServerGUI extends Application{

    ListView<String> listItems = new ListView<String>();


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        primaryStage.setTitle("Server");
        //create a listview to see every action from the clients
        listItems.setStyle("-fx-background-color: white; -fx-border-color: pink");
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(70));
        root.setStyle("-fx-background-color: white");
        root.setCenter(listItems);

        Scene serverCommunication = new Scene(root, 700, 600);

        primaryStage.setScene(serverCommunication);
        primaryStage.show();
    }

}
