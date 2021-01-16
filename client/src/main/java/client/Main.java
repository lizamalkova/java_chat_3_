package client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main extends Application {
   /* private static Connection connection;
    private static Statement stmt;

    static void connection() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:mainDB.db");
            stmt = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        primaryStage.setTitle("СпэйсЧат");
        primaryStage.setScene(new Scene(root, 650, 350));
        primaryStage.show();
    }


    public static void main(String[] args) throws SQLException {

       /* try{
            connection();
            stmt.executeUpdate("INSERT INTO chat (login, password, nickname) VALUES ('Bob', 'Tbz11', 80);");
        } catch (Exception e){

        }*/
        launch(args);
    }
}
