package ui.stockmanUI;

import VO.goodsVO.GoodsVO;
import bl.goodsbl.GoodsBLServiceImpl;
import blservice.goodsblservice.GoodsBLService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


/**
 * Created by julia98 on 2017/12/11.
 */
public class GoodsInfoEditController {
    @FXML public AnchorPane root;
    @FXML public TextField goodsName;
    @FXML public TextField goodsType;
    @FXML public TextField goodsID;
    @FXML public TextField goodsCategory;
    @FXML public TextField goodsStoreNum;
    @FXML public TextField goodsSellPrice;
    @FXML public TextField goodsBuyPrice;
    @FXML public TextField recentBuyPrice;
    @FXML public TextField recentSellPrice;
    @FXML public Button saveGoodsInfoBtn;

    GoodsBLService goodsBLService = new GoodsBLServiceImpl();

    @FXML
    public void initialize(){
        goodsName.setEditable(true);
        goodsType.setEditable(true);
        goodsBuyPrice.setEditable(true);
        goodsSellPrice.setEditable(true);
        recentBuyPrice.setEditable(true);
        recentSellPrice.setEditable(true);

        goodsName.setStyle("-fx-background-color: #FFECEC");
        goodsType.setStyle("-fx-background-color: #FFECEC");
        goodsBuyPrice.setStyle("-fx-background-color: #FFECEC");
        goodsSellPrice.setStyle("-fx-background-color: #FFECEC");
        recentBuyPrice.setStyle("-fx-background-color: #FFECEC");
        recentSellPrice.setStyle("-fx-background-color: #FFECEC");
    }

    @FXML
    public void setSaveGoodsInfoBtn(){
        goodsName.setStyle("-fx-background-color: transparent");
        goodsType.setStyle("-fx-background-color: transparent");
        goodsCategory.setStyle("-fx-background-color: transparent");
        goodsBuyPrice.setStyle("-fx-background-color: transparent");
        goodsSellPrice.setStyle("-fx-background-color: transparent");
        recentBuyPrice.setStyle("-fx-background-color: transparent");
        recentSellPrice.setStyle("-fx-background-color: transparent");

        GoodsVO goodsVO = new GoodsVO(goodsID.getText()
                ,goodsCategory.getText()
                ,goodsName.getText()
                ,goodsType.getText()
                ,changeStringToDouble(goodsBuyPrice.getText())
                ,changeStringToDouble(goodsBuyPrice.getText())
                ,changeStringToDouble(recentBuyPrice.getText())
                ,changeStringToDouble(recentSellPrice.getText()));

        goodsBLService.modifyGoods(goodsVO);
        Platform.runLater(()->{
            root.getScene().getWindow().hide();
        });
    }

    /**
     * 将输入的String类型的金额转化为double型
     * @param str
     * @return
     */
    private double changeStringToDouble(String str){
        if(!str.contains(".")){
            return Double.parseDouble(str);
        }else{
            String[] tmp = str.split(".");
            double ret = Double.parseDouble(tmp[0]) + Double.parseDouble(tmp[1])/(Math.pow(10,tmp[1].length()));
            return ret;
        }
    }
}
