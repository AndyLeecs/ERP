package ui.mainUI;

import java.io.IOException;
import java.rmi.RemoteException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXPopup.PopupHPosition;
import com.jfoenix.controls.JFXPopup.PopupVPosition;
import com.jfoenix.controls.JFXRippler;
import com.jfoenix.controls.JFXRippler.RipplerMask;
import com.jfoenix.controls.JFXRippler.RipplerPos;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import ui.mainUI.loginUI.User;
import ui.stockmanUI.GoodsWin;
import ui.stockmanUI.StockmanWin;

public class BackgroundController {
    @FXML public AnchorPane root;
    @FXML public ImageView logOutBtn;
    @FXML public JFXHamburger hamburger1;
    protected JFXButton label1;

    public void setClick() {
    			try {
    				new StockmanWin();
    				root.getScene().getWindow().hide();
    			} catch (IOException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
    }
    @FXML public void initialize() throws RemoteException {
    	JFXRippler rippler = new JFXRippler(hamburger1, RipplerMask.CIRCLE, RipplerPos.BACK);
		rippler.setStyle("-jfx-rippler-fill: PINK;");

        JFXListView<JFXButton> list = new JFXListView<>();
        list.setStyle( 
        		"    -fx-background-insets: 0;\n" + 
        		"    -jfx-cell-horizontal-margin: 0.0;\n" + 
        		"    -jfx-cell-vertical-margin: 5.0;\n" + 
        		"    -jfx-vertical-gap: 10;\n" + 
        		"    -jfx-expanded: false;\n" + 
        		"    -fx-pref-width: 200;\n" + 
        		"}");
        label1 = new JFXButton("返回主界面");
        list.getItems().add(label1);
       
        label1.setOnMouseClicked(e->{
        	setClick();
        /*	try {
				new GoodsWin();
				root.getScene().getWindow().hide();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
		});
  
        JFXButton personalInfoBtn = new JFXButton("个人信息");
        list.getItems().add(personalInfoBtn);
        JFXButton messageBtn = new JFXButton("消息");
        list.getItems().add(messageBtn);
        messageBtn.setOnMouseClicked(e->{
        	System.out.println("clicked message");
        	Platform.runLater(()-> {
                try {
                    new ui.mainUI.MessageWin();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
        });
        });
        
        JFXButton settingBtn = new JFXButton("偏好设置");
        list.getItems().add(settingBtn);
        
        root.getChildren().add(rippler);
        AnchorPane.setLeftAnchor(rippler, 1100.0);
        AnchorPane.setTopAnchor(rippler, 20.0);
        JFXPopup popup = new JFXPopup(list);
        rippler.setOnMouseClicked(e -> popup.show(rippler, PopupVPosition.TOP, PopupHPosition.RIGHT));
	
    }
    
    @FXML
    public void onMessageBtnClicked(){
    	Platform.runLater(()-> {
            try {
                new ui.mainUI.MessageWin();
            } catch (Exception e) {
                e.printStackTrace();
            }
    });
    }
    
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