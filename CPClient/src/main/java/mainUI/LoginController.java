package mainUI;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import bl.userbl.User;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import util.LoginRM;
import util.UserType;

public class LoginController {
	@FXML public AnchorPane root;
	@FXML public TextField usernameTxt;
	@FXML public TextField passwordTxt;
	@FXML public Button loginBtn;
	@FXML Label usernameLabel;
	@FXML Label passwordLabel;

	private long displayTime = 1000;

	
	@FXML
	public void onLoginBtnClicked() {
		String username = usernameTxt.getText();
		String password = passwordTxt.getText();
		System.out.println(username+"kkk");
		

		if(username == null||username.equals("")){
			usernameLabel.setText("用户名不能为空哦～");
			passwordTxt.setText("");
			usernameTxt.requestFocus();
//			new Timer().schedule(new TimerTask(){
//				public void run(){
//					usernameLabel.setText("");
//				}
//			}, displayTime);
			return;
		}
		if(password == null||password.equals("")){
			passwordLabel.setText("密码不能为空哦～");
			passwordTxt.requestFocus();
//			new Timer().schedule(new TimerTask(){
//				public void run(){
//					passwordLabel.setText("");
//				}
//			}, displayTime);
			return;
		}
		
		LoginRM loginRM = User.getInstance().login(username, password);
		switch(loginRM){
		case SUCCESS:{
			root.getScene().getWindow().hide();
			openWindow(User.getInstance().getUserType());
			break;
		}
		case USER_NOT_FOUND:{
			usernameLabel.setText("该用户不存在～");
			break;
		}
		case WRONG_PASSWORD:{
			usernameLabel.setText("密码输错啦～");
			break;
		}
		}
		
		
		
	}
	
	private void openWindow(UserType type){
		
		
		Platform.runLater(()->{
			try {
				switch(type){
				case Stockman:{
					new ui.stockmanUI.StockmanWin();
					break;
				}
				case Salesman:{
					new ui.salesmanUI.SaleWin();
					break;
				}
				case Accountant:{
					new ui.accountantUI.AccountantWin();
					break;
				}
				case GeneralManager:{
					new ui.managerUI.ManagerWin();
					break;
				}
				case Administrator:{
					new ui.AdministratorUI.AdministratorWin();
					break;
				}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
	

}
