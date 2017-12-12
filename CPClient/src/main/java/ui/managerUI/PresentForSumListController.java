package ui.managerUI;

import java.util.ArrayList;
import java.util.Stack;

import VO.goodsVO.GoodsVO;
import bl.goodsbl.Goods;
import blservice.goodsblservice.GoodsBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**     
* @author 李安迪
* @date 2017年12月12日
* @description
*/
public class PresentForSumListController {
		
		@FXML public ImageView allSelectBtn;
		@FXML public ImageView newGoodsORCategoryBtn;
		@FXML public ImageView moveBtn;
		@FXML public ImageView changeNameBtn;
		@FXML public ImageView deleteBtn;
		
		@FXML public ImageView editBtn;
		@FXML public Button saveGoodsInfoBtn;
		
		@FXML public TextField searchField;
		@FXML public Button searchBtn;

		@FXML public TextField goodsID;
	    @FXML public TextField goodsName;
	    @FXML public TextField goodsType;
	    @FXML public TextField goodsBuyPrice;
	    @FXML public TextField goodsSellPrice;
	    @FXML public TextField recentBuyPrice;
	    @FXML public TextField recentSellPrice;
	    @FXML public TextField goodsStoreNum;

	    private String presentGoodsCategory;
	    
	    private ManagerController managerController;

	    public void setManagerController(ManagerController managerController){
	    	this.managerController = managerController;
	    }
	    
	    @FXML
	    public void initialize(){
	    	
	    	System.out.println("init");
	//    	managerController = controller;
	    }

		@FXML
		public void setAllSelectBtn(){

		}

		@FXML
		public void setNewGoodsORCategoryBtn(){

		}

		@FXML
		public void setMoveBtn(){

		}

		@FXML
		public void setChangeNameBtn(){

		}

		@FXML
		public void setDeleteBtn(){

		}

		@FXML
		public void setEditBtn(){
			
			System.out.println("edit");
			
		    goodsName.setEditable(true);
		    goodsBuyPrice.setEditable(true);
		    goodsSellPrice.setEditable(true);
		    goodsStoreNum.setEditable(true);
		    recentBuyPrice.setEditable(true);
		    recentSellPrice.setEditable(true);

		    goodsName.setStyle("-fx-background-color: #FFECEC");
	        goodsBuyPrice.setStyle("-fx-background-color: #FFECEC");
	        goodsSellPrice.setStyle("-fx-background-color: #FFECEC");
	        goodsStoreNum.setStyle("-fx-background-color: #FFECEC");
	        recentBuyPrice.setStyle("-fx-background-color: #FFECEC");
	        recentSellPrice.setStyle("-fx-background-color: #FFECEC");
		}

		@FXML
	    public void setSaveGoodsInfoBtn(){
	        goodsName.setEditable(false);
	        goodsBuyPrice.setEditable(false);
	        goodsSellPrice.setEditable(false);
	        goodsStoreNum.setEditable(false);
	        recentBuyPrice.setEditable(false);
	        recentSellPrice.setEditable(false);

	        goodsName.setStyle("-fx-background-color: transparent");
	        goodsBuyPrice.setStyle("-fx-background-color: transparent");
	        goodsSellPrice.setStyle("-fx-background-color: transparent");
	        goodsStoreNum.setStyle("-fx-background-color: transparent");
	        recentBuyPrice.setStyle("-fx-background-color: transparent");
	        recentSellPrice.setStyle("-fx-background-color: transparent");

	        GoodsVO goodsVO = new GoodsVO(goodsID.getText(),presentGoodsCategory,goodsName.getText(),goodsType.getText()
	                ,changeStringToDouble(goodsBuyPrice.getText()),changeStringToDouble(goodsBuyPrice.getText())
	        ,changeStringToDouble(recentBuyPrice.getText()),changeStringToDouble(recentSellPrice.getText()));
	    }

		@FXML
		public void setSearchField(){

		}

		@FXML
		public void setSearchBtn(){

		}

		public double changeStringToDouble(String str){
		    if(!str.contains(".")){
		        return Double.parseDouble(str);
	        }else{
		        str.substring(0);
		        return Double.parseDouble(str);
	        }
	    }




		
		

	
}
