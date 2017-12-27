package ui.stockmanUI;

import java.rmi.RemoteException;

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
    public GoodsVO goodsVO;
    public static String goods;
    GoodsBLService goodsBLService = new GoodsBLServiceImpl();

    @FXML
    public void initialize() throws RemoteException{
        init(goods);
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

        goodsName.setText(goodsVO.getGoodsName());
        goodsType.setText(goodsVO.getGoodsType());
        goodsID.setText(goodsVO.getGoodsID());
        goodsCategory.setText(goodsVO.getGoodsCategory());
        goodsSellPrice.setText(""+ goodsVO.getGoodsSellPrice());
        goodsBuyPrice.setText(""+ goodsVO.getGoodsBuyPrice());
        recentBuyPrice.setText(""+ goodsVO.recentBuyPrice());
        recentSellPrice.setText(""+ goodsVO.recentSellPrice());
    }

    public void init(String goods) throws RemoteException{
        System.out.println("controller" + goods);
        goodsVO = goodsBLService.getGoods(goods.substring(0,goods.indexOf('/')),goods.substring(goods.indexOf('/')+1,goods.length()));
        System.out.println(goodsVO.getGoodsName());
    }

    @FXML
    public void setSaveGoodsInfoBtn() throws RemoteException{
        goodsName.setStyle("-fx-background-color: transparent");
        goodsType.setStyle("-fx-background-color: transparent");
        goodsCategory.setStyle("-fx-background-color: transparent");
        goodsBuyPrice.setStyle("-fx-background-color: transparent");
        goodsSellPrice.setStyle("-fx-background-color: transparent");
        recentBuyPrice.setStyle("-fx-background-color: transparent");
        recentSellPrice.setStyle("-fx-background-color: transparent");

        goodsVO.setGoodsName(goodsName.getText());
        goodsVO.setGoodsType(goodsType.getText());
        goodsVO.setGoodsCategory(goodsCategory.getText());
        goodsVO.setGoodsBuyPrice(Double.parseDouble(goodsBuyPrice.getText()));
        goodsVO.setGoodsSellPrice(Double.parseDouble(goodsSellPrice.getText()));
        goodsVO.setRecentBuyPrice(Double.parseDouble(recentBuyPrice.getText()));
        goodsVO.setRecentSellPrice(Double.parseDouble(recentSellPrice.getText()));

        goodsBLService.modifyGoods(goodsVO);
        Platform.runLater(()->{
            root.getScene().getWindow().hide();
        });
    }
}
