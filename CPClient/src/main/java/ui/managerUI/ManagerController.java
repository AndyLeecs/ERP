package ui.managerUI;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mainUI.LoginWin;

/**     
* @author 李安迪
* @date 2017年12月12日
* @description
*/
public class ManagerController {
	@FXML public AnchorPane root;
	@FXML public BorderPane centerPane;
	
	@FXML public MenuItem newPresentForMembership;
	@FXML public MenuItem showPresentForMembership;
	@FXML public MenuItem newPresentForSpecialPackage;
	@FXML public MenuItem showPresentForSpecialPackage;
	@FXML public MenuItem newPresentForSum;
	@FXML public MenuItem showPresentForSum;

	@FXML
	public void onNewPresentForMembershipClicked(){
		Platform.runLater(()->{
		try {
	    	AnchorPane presentroot = FXMLLoader.load(getClass().getResource("/fxml/managerUI/PresentForMembership.fxml"));
			centerPane.setCenter(presentroot);
		} catch (Exception e) {
			e.printStackTrace();
		}
	});
	}
	@FXML
	public void onNewPresentForSpecialPackageClicked(){
		Platform.runLater(()->{
		try {
	    	AnchorPane presentroot = FXMLLoader.load(getClass().getResource("/fxml/managerUI/PresentForSpecialPackage.fxml"));
			centerPane.setCenter(presentroot);
		} catch (Exception e) {
			e.printStackTrace();
		}
	});
	}
	@FXML
	public void onNewPresentForSumClicked(){
		Platform.runLater(()->{
		try {
   		 Strategy strategy = new PresentForSumNewStrategy();
   		 PresentForSumController controller = 
   				    new PresentForSumController(strategy,this);
   		 FXMLLoader loader = new FXMLLoader(
   				    getClass().getResource(
   				        "/fxml/managerUI/PresentForSum.fxml"));
   				loader.setController(controller);
   				AnchorPane presentroot = loader.load();
//	    	AnchorPane presentroot = FXMLLoader.load(getClass().getResource("/fxml/managerUI/PresentForSum.fxml"));
			centerPane.setCenter(presentroot);
		} catch (Exception e) {
			e.printStackTrace();
		}
	});
	}
	@FXML
	public void onShowPresentForMembershipClicked(){
		Platform.runLater(()->{
		try {
	    	AnchorPane presentroot = FXMLLoader.load(getClass().getResource("/fxml/managerUI/PresentForMembershipList.fxml"));
			centerPane.setCenter(presentroot);
		} catch (Exception e) {
			e.printStackTrace();
		}
	});
	}
	@FXML
	public void onShowPresentForSpecialPackageClicked(){
		Platform.runLater(()->{
		try {
	    	AnchorPane presentroot = FXMLLoader.load(getClass().getResource("/fxml/managerUI/PresentForSpecialPackageList.fxml"));
			centerPane.setCenter(presentroot);
		} catch (Exception e) {
			e.printStackTrace();
		}
	});
	}
	@FXML
	public void onShowPresentForSumClicked(){
   	 Platform.runLater(new Runnable() {
	     public void run() {
	    	 try {

		    	AnchorPane presentroot = FXMLLoader.load(getClass().getResource("/fxml/managerUI/PresentForSumList.fxml"));
				centerPane.setCenter(presentroot);

			 } catch (Exception e) {
				e.printStackTrace();
			 }
	     }
	 });
	}
    
    @FXML 
    public void logOut() {
    	
   	     Platform.runLater(()-> {
				    try {
				    	System.out.println("log out");
						root.getScene().getWindow().hide();
						new LoginWin();
						//new ui.saleUI.SaleWin();
					} catch (Exception e) {
						e.printStackTrace();
					}
			});   	 
    }
}
