package ui.stockmanUI;

import VO.storeVO.StoreLogVO;
import VO.storeVO.storeCheckVO;
import bl.storebl.StoreblController;
import blservice.storeblservice.StoreBLService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import util.GreatListType;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

public class StoreCheckController {
    @FXML
    VBox vBox;
    @FXML
    TextField beginTime;
    @FXML
    TextField endTime;
    @FXML
    Button findButton ;
    @FXML Label inStore;
    @FXML Label outStore;
    @FXML JFXButton inventoryBtn;
    StoreBLService storeblservice=new StoreblController();//持有库存接口
   @FXML  public void find(){
	   if(vBox.getChildren().size()!=0){
	   vBox.getChildren().remove(0, vBox.getChildren().size());
	   }
        if(checkInput()){
            storeCheckVO vo=storeblservice.store_check(beginTime.getText(),endTime.getText());
            if(vo!=null){
            	/*if(vo.logArr==null){
            		System.out.println("没有初始化");
            	}*/
            	int inNum=0;
            	int outNum=0;
                for(StoreLogVO v:vo.logArr){
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/stockmanUI/StoreLogItem.fxml"));
                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    vBox.getChildren().add(loader.getRoot());
                    StoreLogItemController itemController=loader.getController();
                    itemController.set(v);
                    if(v.type.equals(GreatListType.SALE)||v.type.equals(GreatListType.STOCK_RETURN)
                    		||v.type.equals(GreatListType.PRESENT)||v.type.equals(GreatListType.LOSS)){
                    	outNum=outNum+v.num;
                    }else{
                    	inNum=inNum+v.num;
                    }
                }
                inStore.setText(Integer.toString(inNum));
                outStore.setText(Integer.toString(outNum));
            }else{
                System.out.println("没有VO！！");
            }
        }
    }
@FXML public  void initialize(){
	 beginTime.clear();
	 beginTime.setPromptText("请输入开始时间");
	 endTime.clear();
	 endTime.setPromptText("请输入结束时间");
}
    boolean checkInput(){
       //检查输入合法性
       return true;
    }
    
    @FXML public void openInventory(){
    	StoreInventoryTreeTable treetable=new StoreInventoryTreeTable();
        Stage stage=new Stage();
    	treetable.start(stage);
    }

}
