package mainUI;

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
	}

}
