package ui.stockmanUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import util.StoreListType;

public class StoreListController {
//采取折中策略，先跳转，再加载。
	@ FXML Button findButton;
	@ FXML Button filter;
	@ FXML ComboBox<String> combobox;
	@ FXML TextField findTextField;
	@FXML Label typeLabel;
	@FXML VBox  vBox;
	
	public void set(StoreListType type){
         if(type.equals(StoreListType.ALARM)){
        	 typeLabel.setText("库存报警单");
        	 filter.setVisible(false);
        	 combobox.setVisible(false);
        	 loadAlarmWin();
         }else{
        	 if(type.equals(StoreListType.PRESENT)){
        		 typeLabel.setText("库存赠送单");
        		 loadPresentWin();
        	 }
        	 if(type.equals(StoreListType.OVERFLOW)){
        		 typeLabel.setText("库存报溢单");
        		 loadReportWin();
        	 }
        	 if(type.equals(StoreListType.LOSS)){
        		 typeLabel.setText("库存报损单");
        		 loadReportWin();
        	 }
         }
		
	}
	
	public void loadAlarmWin(){
		//加载库存报警单的界面
	}
	
	public void loadPresentWin(){
		//加载赠送单的界面
	}
	public  void loadReportWin(){
		//加载库存报告单的界面
	}
}
