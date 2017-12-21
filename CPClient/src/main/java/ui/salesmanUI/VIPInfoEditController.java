package ui.salesmanUI;

import bl.VIPbl.VIPBLServiceImpl;
import blservice.VIPblservice.VIPBLService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * Created by julia98 on 2017/12/22.
 */
public class VIPInfoEditController {
    @FXML
    public AnchorPane root;
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

    VIPBLService vipBLService = new VIPBLServiceImpl();

    @FXML
    public void initialize(){
        goodsName.setEditable(true);

        goodsName.setStyle("-fx-background-color: #FFECEC");
    }

    @FXML
    public void setSaveGoodsInfoBtn(){
        goodsName.setStyle("-fx-background-color: transparent");

/*        VIPVO vipVO = new VIPVO();

        vipBLService.modifyVIP(vipVO);*/
        Platform.runLater(()->{
            root.getScene().getWindow().hide();
        });
    }
}

