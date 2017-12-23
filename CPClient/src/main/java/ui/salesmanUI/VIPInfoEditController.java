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
    @FXML public TextField vipName;
    @FXML public TextField vipType;
    @FXML public TextField vipID;
    @FXML public TextField vipCategory;
    @FXML public Button saveVIPInfoBtn;

    VIPBLService vipBLService = new VIPBLServiceImpl();

    @FXML
    public void initialize(){
        vipName.setEditable(true);

        vipName.setStyle("-fx-background-color: #FFECEC");
    }

    @FXML
    public void setSaveVIPInfoBtn(){
        vipName.setStyle("-fx-background-color: transparent");

/*        VIPVO vipVO = new VIPVO();

        vipBLService.modifyVIP(vipVO);*/
        Platform.runLater(()->{
            root.getScene().getWindow().hide();
        });
    }
}

