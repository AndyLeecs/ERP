package ui.commonUI;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class CommonController {
    @FXML public AnchorPane root;
    @FXML public ImageView logOut;

    @FXML
    public void logOut() {
        Platform.runLater(new Runnable() {
            public void run() {
                try {
                    root.getScene().getWindow().hide();
                    new mainUI.LoginWin();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}