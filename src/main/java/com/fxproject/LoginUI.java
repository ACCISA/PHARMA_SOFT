package com.fxproject;

import com.func.ScriptPython;
import com.func.Utils;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
// test git commit
public class LoginUI extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        double width = 640;
        double height = 480;

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth() - width) / 2);
        stage.setY((screenBounds.getHeight() - height) / 2);

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("login-ui.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 567, 279);
        stage.setTitle("Login");
        stage.getIcons().add(new Image("C:\\Users\\darra\\IdeaProjects\\FXProject\\src\\main\\java\\com\\fxproject\\concordia-logo.png"));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        System.out.println("[Login] Login UI Started");
        Utils.runScript();
    }

    @Override
    public void init() throws Exception {
        // DB connection create when init
        com.db.Connections.connect();
        super.init();
    }

    @Override
    public void stop() throws Exception {
        com.db.Connections.disconnect();
        super.stop();
    }

    public static void createUI() {
        launch();
    }
}