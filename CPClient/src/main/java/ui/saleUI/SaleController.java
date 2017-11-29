package ui.saleUI;

import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.util.Duration;

public class SaleController {

	@FXML public MenuButton newBtn;
	
	public Transition buttonTransition(){
		TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), newBtn);
		transition.setByX(0);
		transition.setByY(20);
		transition.play();
		return transition;
	}
	
	@FXML public void start() {
		buttonTransition();
	}
	
	@FXML
	public void onNewBtnClicked() {
		buttonTransition();
	}
	
}
