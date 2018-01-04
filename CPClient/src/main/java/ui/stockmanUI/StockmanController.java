package ui.stockmanUI;

import java.io.IOException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawer.DrawerDirection;
import com.jfoenix.controls.JFXDrawersStack;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import ui.mainUI.BackgroundController;
import ui.mainUI.loginUI.LoginWin;
import util.State;
import util.StoreListType;

/**
 * 
 * @author julia98
 * @since 2017.12.03
 *
 */
public class StockmanController extends BackgroundController{
	@FXML public AnchorPane root;
	@FXML public BorderPane centerPane;
	@FXML public JFXButton newBtn;
	@FXML public JFXButton lookBtn;
	@FXML public JFXButton goodsManageBtn;
	@FXML public JFXButton draftBtn;  //库存查看
	@FXML public ImageView logOutBtn;
	
	//@FXML public MenuItem newPresentListBtn;
	//@FXML public MenuItem newStockOverflowListBtn;
	//@FXML public MenuItem newStockLostListBtn;
	public JFXButton newPresentListBtn = new JFXButton("库存赠送单");
	public JFXButton newStockOverflowListBtn = new JFXButton("库存报溢单");
	public JFXButton newStockLostListBtn = new JFXButton("库存报损单");
	public JFXButton newAlarmListBtn;
	public JFXButton lookPresentListBtn = new JFXButton("库存赠送单");
	public JFXButton lookStockOverflowListBtn = new JFXButton("库存报溢单");
	public JFXButton lookStockLostListBtn = new JFXButton("库存报损单");
	public JFXButton lookAlarmListBtn = new JFXButton("库存报警单");
	public JFXButton messageBtn;
	//@FXML public MenuItem personalInfoBtn;

//	@FXML public MenuItem StoreCheckBtn;
//	@FXML public MenuItem StoreInventoryBtn;
	
	@FXML public Pane addNext;
	@FXML public JFXDrawersStack drawersStack;

    JFXDrawer drawer = new JFXDrawer();
    StackPane drawerPane = new StackPane();

	
	
	@FXML public void initialize() {
	     
	        //JFXDrawer drawer = new JFXDrawer();
	        //StackPane drawerPane = new StackPane();
		    StackPane.setMargin(drawerPane, new Insets(100));
	        drawerPane.setStyle("-fx-background-color: rgb(39, 72, 98)");
	        drawerPane.getChildren().add(new JFXButton("Drawer Content!"));
	        drawer.setSidePane(drawerPane);
	        drawer.setDefaultDrawerSize(150);
	        drawer.setDirection(DrawerDirection.BOTTOM);
	        drawer.setOverLayVisible(false);
	        drawer.setResizableOnDrag(true);
	        newPresentListBtn.setOnMouseClicked(e-> newPresentList());
	        newStockOverflowListBtn.setOnMouseClicked(e -> newStockOverflowList());
	        newStockLostListBtn.setOnMouseClicked(e -> newStockLostList());
	        lookPresentListBtn.setOnMouseClicked(e-> lookPresentList());
	        lookStockOverflowListBtn.setOnMouseClicked(e -> lookStockOverflowList());
	        lookStockLostListBtn.setOnMouseClicked(e -> lookStockLostList());
	        lookAlarmListBtn.setOnMouseClicked(e -> lookAlarmList());
	}
	
	
	@FXML public void setNewBtn() {
		drawerPane.getChildren().clear();
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(30,30,30,30));
		hbox.getChildren().addAll(newPresentListBtn,newStockOverflowListBtn,newStockLostListBtn);
		//drawerPane.getChildren().addAll(newPresentListBtn,newStockOverflowListBtn,newStockLostListBtn);
		drawerPane.getChildren().add(hbox);
		drawersStack.toggle(drawer);
	}
	
	@FXML public void setLookBtn() {
		drawerPane.getChildren().clear();
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(30,30,30,30));
		hbox.getChildren().addAll(lookPresentListBtn,lookStockOverflowListBtn,lookStockLostListBtn,lookAlarmListBtn);
		drawerPane.getChildren().add(hbox);
		drawersStack.toggle(drawer);
	}
	
	 @FXML public void newPresentList() {
		 Platform.runLater(()->{
			 try {
				 PresentListWin win=new PresentListWin();
//				 root.getScene().getWindow().hide();
				 ;
				 State state=State.IsEditting;
				 win.controller.set(state);

			 } catch (IOException e) {
				 e.printStackTrace();
			 }
		 });
	 }
	
     @FXML public void newStockOverflowList() {
		 Platform.runLater(()->{
			 try {
				 ReportListWin win=new ReportListWin();
//				 root.getScene().getWindow().hide();
				;
				 State state=State.IsEditting;
				 win.controller.set(StoreListType.OVERFLOW,state);

			 } catch (IOException e) {
				 e.printStackTrace();
			 }
		 });
	 }
     
     @FXML public void newStockLostList() {
		 Platform.runLater(()->{
			 try {
				 ReportListWin win=new ReportListWin();
//				 root.getScene().getWindow().hide();
				 State state=State.IsEditting;
				 win.controller.set(StoreListType.LOSS,state);

			 } catch (IOException e) {
				 e.printStackTrace();
			 }
		 });
     }
     

     
     @FXML public void lookPresentList() {
		 Platform.runLater(()->{
			 try {
				 StoreListWin win=new StoreListWin();
				 root.getScene().getWindow().hide();
				 win.controller.set(StoreListType.PRESENT);
			 } catch (IOException e) {
				 e.printStackTrace();
			 }
		 });
     }
     
     @FXML public void lookStockOverflowList() {
		 Platform.runLater(()->{
			 try {
				 StoreListWin win=new StoreListWin();
				 root.getScene().getWindow().hide();
				 win.controller.set(StoreListType.OVERFLOW);
			 } catch (IOException e) {
				 e.printStackTrace();
			 }
		 });
     }
     
     @FXML public void lookStockLostList() {
		Platform.runLater(()->{
			 try {
				 StoreListWin win=new StoreListWin();
				 root.getScene().getWindow().hide();
				 win.controller.set(StoreListType.LOSS);
			 } catch (IOException e) {
				 e.printStackTrace();
			 }
		 });
     }
     
     @FXML public void lookAlarmList() {
    	 Platform.runLater(()->{
 			try {
 				StoreListWin win=new StoreListWin();
 				root.getScene().getWindow().hide();
 		        win.controller.set(StoreListType.ALARM);
 			} catch (IOException e) {
 				e.printStackTrace();
 			}
 		});
     }
     
    
     @FXML public void draft() {
    	 
     }
    
     
     @FXML 
     public void goodsManage() {
		Platform.runLater(()->{
			try {
				new GoodsWin();
				root.getScene().getWindow().hide();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		/*
    	 Platform.runLater(new Runnable() {
    	     public void run() {
    	    	 try {
			    	AnchorPane goodsroot = FXMLLoader.load(getClass().getResource("/fxml/stockmanUI/GoodsBLServiceImpl.fxml"));
					centerPane.setCenter(goodsroot);
	
				 } catch (Exception e) {
					e.printStackTrace();
				 }
    	     }
    	 });
    	 */
     }
     
     @FXML 
     public void logOut() {
    	     Platform.runLater(()-> {
				    try {
						root.getScene().getWindow().hide();
						new LoginWin();
						//new ui.saleUI.SaleWin();
					} catch (Exception e) {
						e.printStackTrace();
					}
			});   	 
     }

     @FXML public void StoreCheck(){
		 Platform.runLater(()->{
			 try {
				 StoreCheckWin win=new StoreCheckWin();
				 root.getScene().getWindow().hide();

			 } catch (IOException e) {
				 e.printStackTrace();
			 }
		 });

	 }

	 @FXML public void StoreInventory(){

	 }
}
