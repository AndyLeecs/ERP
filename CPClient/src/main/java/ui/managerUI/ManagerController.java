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

	@FXML private PresentForSumListController presentForSumListController;
	@FXML
	public void onNewPresentForMembershipClicked(){
		Platform.runLater(()->{
		try {
			new PresentForMembershipWin();
			root.getScene().getWindow().hide();
		} catch (Exception e) {
			e.printStackTrace();
		}
	});
	}
	@FXML
	public void onNewPresentForSpecialPackageClicked(){
		Platform.runLater(()->{
		try {
			new PresentForSpecialPackageWin();
			root.getScene().getWindow().hide();
		} catch (Exception e) {
			e.printStackTrace();
		}
	});
	}
	@FXML
	public void onNewPresentForSumClicked(){
		Platform.runLater(()->{
		try {
			new PresentForSumWin();
			root.getScene().getWindow().hide();
		} catch (Exception e) {
			e.printStackTrace();
		}
	});
	}
	@FXML
	public void onShowPresentForMembershipClicked(){
		Platform.runLater(()->{
		try {
			new PresentForMembershipListWin();
			root.getScene().getWindow().hide();
		} catch (Exception e) {
			e.printStackTrace();
		}
	});
	}
	@FXML
	public void onShowPresentForSpecialPackageClicked(){
		Platform.runLater(()->{
		try {
			new PresentForSpecialPackageListWin();
			root.getScene().getWindow().hide();
		} catch (Exception e) {
			e.printStackTrace();
		}
	});
	}
	@FXML
	public void onShowPresentForSumClicked(){
//   	 Platform.runLater(new Runnable() {
//	     public void run() {
//	    	 try {
	    	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/managerUI/PresentForSumList.fxml"));
	    	        Parent root = null;
					try {
						root = loader.load();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    	        PresentForSumListController controller = loader.getController();
	    	        controller.setManagerController(this);

//	    	        Scene scene = new Scene(root);
//	    	        Stage stage = new Stage();
//		    	AnchorPane presentroot = FXMLLoader.load(getClass().getResource("/fxml/managerUI/PresentForSumList.fxml"));
				centerPane.setCenter(root);

//			 } catch (Exception e) {
//				e.printStackTrace();
//			 }
//	     }
//	 });
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
