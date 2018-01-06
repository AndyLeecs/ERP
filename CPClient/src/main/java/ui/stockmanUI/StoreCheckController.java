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

import java.io.IOException;

public class StoreCheckController {
    @FXML
    VBox vBox;
    @FXML
    TextField beginTime;
    @FXML
    TextField endTime;
    @FXML
    Button findButton ;
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
                }
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

}
