package com.example.clientchat;

import com.example.clientchat.controllers.AuthController;
import com.example.clientchat.controllers.ClientController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class ClientChat extends Application {

    private Stage stage;
    private Stage authStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.stage = primaryStage;

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(ClientChat.class.getResource("hello-view.fxml"));

        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        this.stage.setTitle("Java FX Application");
        this.stage.setScene(scene);

        ClientController controller = fxmlLoader.getController();
        controller.userList.getItems().addAll("Пользователь_1", "Пользователь_2");

        primaryStage.show();

        connectToServer(controller);

        FXMLLoader authLoader = new FXMLLoader();
        authLoader.setLocation(ClientChat.class.getResource("authDialog.fxml"));
        AnchorPane authDialogPanel = authLoader.load();

        authStage = new Stage();
        authStage.initOwner(primaryStage);
        authStage.initModality(Modality.WINDOW_MODAL);

        authStage.setScene(new Scene(authDialogPanel));
        AuthController authController = authLoader.getController();
        authController.setClientChat(this);
        authController.initializeMessageHandler();

        authStage.showAndWait();
        controller.initializeMessageHandler();
    }

    private void connectToServer(ClientController clientController) {
        boolean resultConnectedToServer = Network.getInstance().connect();
        if (!resultConnectedToServer) {
            String errorMessage = "Невозможно установить сетевое соединение";
            System.err.println(errorMessage);
            showErrorDialog(errorMessage);
        }

        clientController.setApplication(this);

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                Network.getInstance().close();
            }
        });
    }

    public void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }

    public Stage getAuthStage() {
        return authStage;
    }
}