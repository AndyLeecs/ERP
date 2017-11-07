package mainUI;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginController {
	@FXML public AnchorPane root;
	@FXML public TextField usernameTxt;
	@FXML public TextField passwordTxt;
	@FXML public Button loginBtn;
	
	String username = "";
	String password = "";
	
	@FXML
	public void onLoginBtnClicked() {
		this.username = usernameTxt.getText();
		this.password = passwordTxt.getText();
		
		Platform.runLater(()->{
			try {
				new ui.saleUI.SaleWin();
				root.getScene().getWindow().hide();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

}
