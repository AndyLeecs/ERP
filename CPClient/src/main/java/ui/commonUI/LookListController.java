package ui.commonUI;

import java.io.IOException;

import java.util.ArrayList;

import VO.listVO.InfoListVO;
import bl.listbl.ListblController;
import blservice.listblservice.Listblservice;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

public class LookListController {
    //表单查看与审批的界面。
    @FXML
    Button filter;
    @FXML Button approve;
    @FXML Button open;
    @FXML
    ComboBox<String> comboBox;
    @FXML
    VBox vBox;
    boolean isManager;
    Listblservice service=new ListblController();
    ArrayList<InfoListVO> arr0=new ArrayList<InfoListVO>();
    ArrayList<InfoListController>arr1=new ArrayList<InfoListController>();
    @FXML public void open(){

    }
    @FXML public void onApprove(){

    }

    @FXML public void onFilter(){

    }
    
    public void set(boolean isManager){
    	this.isManager=isManager;
    	if(isManager==true){
    	ArrayList <String >arr =new ArrayList<String>();
    	arr.add("已审批");
    	arr.add("待审批");
    	comboBox.getItems().addAll(arr);
    	getOnApproveList();
    	}
    	else{
    		comboBox.setVisible(false);
    		filter.setVisible(false);
    		approve.setVisible(false);
    		getApprovedList();
    	}
    }
    
    public void getApprovedList(){
    	
    
			arr0=service.openInfoList();

    	arr1=new ArrayList<InfoListController>();
    	refresh();
    }
    
    public void getOnApproveList(){
    	arr0=service.openApproved();
    	arr1=new ArrayList<InfoListController>();
    	refresh();
    }
    public void refresh(){
    	for(int i=0;i<arr0.size();i++){
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/listUI/InfoListItem.fxml"));
			try {
				loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			vBox.getChildren().add(loader.getRoot());
			InfoListController ct=loader.getController();
			arr1.add(ct);
			ct.set(arr0.get(i));
			
    	}
    }
}
