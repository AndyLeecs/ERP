package ui.commonUI;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import ui.mainUI.loginUI.User;

public class CommonController {
    @FXML public AnchorPane root;
    @FXML public ImageView logOutBtn;

    @FXML
    public void logOut() {
        Platform.runLater(()-> {
                try {
                    root.getScene().getWindow().hide();
                    User.getInstance().logout();
                    new ui.mainUI.loginUI.LoginWin();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        });
    }
}