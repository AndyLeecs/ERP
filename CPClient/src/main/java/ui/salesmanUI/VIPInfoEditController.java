package ui.salesmanUI;

import VO.VIPVO.VIPVO;
import VO.goodsVO.GoodsVO;
import bl.VIPbl.VIPBLServiceImpl;
import blservice.VIPblservice.VIPBLService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.rmi.RemoteException;

/**
 * Created by julia98 on 2017/12/22.
 */
public class VIPInfoEditController {
    @FXML public AnchorPane root;
    @FXML public TextField name;
    @FXML public TextField id;
    @FXML public TextField category;
    @FXML public TextField grade;
    @FXML public TextField phoneNumber;
    @FXML public TextField address;
    @FXML public TextField email;
    @FXML public TextField postcode;
    @FXML public TextField collectionLimit;
    @FXML public TextField collection;
    @FXML public TextField clerk;
    @FXML public TextField payment;
    @FXML public Button saveVIPInfoBtn;

    VIPBLService vipBLService = new VIPBLServiceImpl();


    public void init(String vip) throws RemoteException {
        System.out.println(vip);
        VIPVO vipVO = vipBLService.getVIP(vip);
        name.setText(vipVO.getName());
        id.setText(vipVO.getId());
        category.setText(vipVO.getCategory());
        grade.setText(vipVO.getGrade());
        phoneNumber.setText(vipVO.getPhoneNumber());
        address.setText(vipVO.getAddress());
        email.setText(vipVO.getEmail());
        postcode.setText(vipVO.getPostCode());
        collectionLimit.setText(""+vipVO.getCollectionLimit());
        collection.setText(""+vipVO.getCollection());
        clerk.setText(vipVO.getClerk());
        payment.setText(""+vipVO.getPayment());

    }

    @FXML
    public void setSaveVIPInfoBtn(){
        VIPVO vipvo = new VIPVO(id.getText()
                ,category.getText()
                ,grade.getText()
                ,name.getText()
                ,phoneNumber.getText()
                ,email.getText()
                ,address.getText()
                ,postcode.getText()
                ,Double.parseDouble(collection.getText())
                ,Double.parseDouble(collectionLimit.getText())
                ,Double.parseDouble(payment.getText())
                ,clerk.getText()
        );

        vipBLService.modifyVIP(vipvo);
        Platform.runLater(()->{
            root.getScene().getWindow().hide();
        });
    }
}

