package ui.mainUI;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import ui.mainUI.loginUI.User;
/**
 * 
 * 问：可以考虑把头像和左边栏vbox也加进来吗？
 * 再问：vbox可能不行，导致头像可能没法显示在最上面？
 * 以后再说吧
 *
 */
public class BackgroundController {
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