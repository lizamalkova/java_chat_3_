package server;

import java.sql.SQLException;

public interface AuthService {
  //  public String getNicknameByLoginAndPassword(String login, String password);


    boolean registration(String login, String password, String nickname) throws SQLException;
    boolean changeNickname(String login, String password, String newNickname) throws SQLException;
}
