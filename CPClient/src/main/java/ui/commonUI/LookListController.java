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
import resultmessage.ApproveRM;
import ui.accountUI.list.collection.CollectionListWin;
import util.GreatListType;

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
         for(int i=0;i<arr1.size();i++){
        	 if(arr1.get(i).isChosen.isSelected()){
        		try {
					new CollectionListWin(arr0.get(i).id) ;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println("----");
				}
        	 }
         }
    }
    @FXML public void onApprove(){
        //批量审批
        int size=arr1.size();
    	for(int i=0;i<size;i++){
    		if(arr1.get(i).isChosen.isSelected()){
             ApproveRM rm=  service.approve(arr0.get(i).id, arr0.get(i).type);
             if(rm.equals(ApproveRM.OK)){
            	 arr0.remove(i);
            	 arr1.remove(i);
            	 size--;
            	 i--;
             }else{
            	 //打印错误信息；
            	 break;
             }
    			
    		}
    	}
    	
    	getOnApproveList();
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
    	
    
			
    	arr0=service.openApproved();
    	arr1=new ArrayList<InfoListController>();
    	refresh();
    }
    
    public void getOnApproveList(){
    	
    	arr0=service.openInfoList();
    	arr1=new ArrayList<InfoListController>();
    	refresh();
    }
    public void refresh(){
 	   if(vBox.getChildren().size()!=0){
 		   vBox.getChildren().remove(0, vBox.getChildren().size());
 		   }
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
