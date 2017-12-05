package ui.stockmanUI;

import VO.goodsVO.GoodsVO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class GoodsController {
	
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
    @FXML
    public void initialize(){

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
