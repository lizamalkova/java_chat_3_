package client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NickController {

        @FXML
        private TextField loginField;
        @FXML
        private TextField passwordField;
        @FXML
        private TextField newNicknameField;
        @FXML
        private TextArea textArea;

        private Controller controller;

        public void setController(Controller controller) {
            this.controller = controller;
        }

        @FXML
        public void tryToChangeNick(ActionEvent actionEvent) {
            String login = loginField.getText().trim();
            String password = passwordField.getText().trim();
            String nickname = newNicknameField.getText().trim();

            controller.tryToChangeNick(login, password, nickname);
        }

        public void addMessage(String msg) { textArea.appendText(msg + "\n"); }
    }


