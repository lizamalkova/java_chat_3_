package server;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleAuthService implements AuthService {
    private static Connection connection;
    private static Statement stmt;

    static void connection() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:mainDB.db");
            stmt = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class UserData {
        String login;
        String password;
        String nickname;

        public UserData(String login, String password, String nickname) {
            this.login = login;
            this.password = password;
            this.nickname = nickname;
        }
    }



    public SimpleAuthService() {

    }

    public static String getNicknameByLoginAndPassword(String login, String password) {
        connection();
        String sql = String.format("SELECT nickname FROM chat where login = '%s' and password = '%s'", login, password);

        try {
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                return rs.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean registration(String login, String password, String nickname) throws SQLException {
        connection();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM chat WHERE login = '" + login + "'");
        ResultSet resultSet1 = stmt.executeQuery("SELECT * FROM chat WHERE nickname = '" + nickname + "'");
        if ( resultSet.next() || resultSet1.next()){
            return false;
        } else {
            String sql = String.format("INSERT INTO chat (login, password, nickname) VALUES ('%s', '%s', '%s')", login, password, nickname);

            try {
                boolean rs = stmt.execute(sql);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    public boolean changeNickname(String login, String password, String newNickname) throws SQLException {
        connection();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM chat where login = '" + login + "' and password = '" + password + "'");
        if ( resultSet.next()){
            String nick = resultSet.getString("nickname");
            String sql = String.format("UPDATE chat SET nickname = '"+ newNickname +"' WHERE nickname = '" +nick +"'");

            try {
                boolean rs = stmt.execute(sql);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return true;
        } else {
            return false;

        }
    }
}
