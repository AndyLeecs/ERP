package ui.stockmanUI;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import mainUI.LoginWin;

import java.io.IOException;

/**
 * 
 * @author julia98
 * @since 2017.12.03
 *
 */
public class StockmanController {
	@FXML public AnchorPane root;
	@FXML public MenuButton newBtn;
	@FXML public MenuButton lookBtn;
	@FXML public Button goodsManageBtn;
	@FXML public Button draftBtn;
	
	@FXML public MenuItem newPresentListBtn;
	@FXML public MenuItem newStockOverflowListBtn;
	@FXML public MenuItem newStockLostListBtn;
	@FXML public MenuItem newAlarmListBtn;
	@FXML public MenuItem lookPresentListBtn;
	@FXML public MenuItem lookStockOverflowListBtn;
	@FXML public MenuItem lookStockLostListBtn;
	@FXML public MenuItem lookAlarmListBtn;
	@FXML public MenuItem messageBtn;
	@FXML public MenuItem personalInfoBtn;
	
	@FXML public void init() {
	
	}
	
	 @FXML public void newPresentList() {
		
	 }
	
     @FXML public void newStockOverflowList() {
		
	 }
     
     @FXML public void newStockLostList() {
    	 
     }
     
     @FXML public void newAlarmList() {
    	 
     }
     
     @FXML public void lookPresentList() {
    	 
     }
     
     @FXML public void lookStockOverflowList() {
    	 
     }
     
     @FXML public void lookStockLostList() {
    	 
     }
     
     @FXML public void lookAlarmList() {
    	 
     }
     
     @FXML public void message() {
    	 
     }
     
     @FXML public void personalInfo() {
    	 
     }
     
     @FXML public void draft() {
    	 
     }
     @FXML 
     public void goodsManage() throws IOException{

    	 Platform.runLater(()-> {
		    try {
				new GoodsWin();
				root.getScene().getWindow().hide();
				//new ui.saleUI.SaleWin();
			} catch (Exception e) {
				e.printStackTrace();
			}
	});
     }
     
     @FXML 
     public void logOut() {
    	     Platform.runLater(()-> {
				    try {
						new LoginWin();
						root.getScene().getWindow().hide();
						//new ui.saleUI.SaleWin();
					} catch (Exception e) {
						e.printStackTrace();
					}
			});   	 
     }
}
