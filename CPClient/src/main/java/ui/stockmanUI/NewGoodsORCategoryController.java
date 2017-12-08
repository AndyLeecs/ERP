package ui.stockmanUI;

import blservice.goodsblservice.GoodsBLService;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;


public class NewGoodsORCategoryController {
    @FXML private AnchorPane root;
    @FXML private TextField name;
    @FXML public ChoiceBox nameType;
    @FXML Button sureBtn;
    @FXML Button cancelBtn;

    private static String type = "";
    private static String goodsID = "";

    GoodsBLService goodsBLService;
    private ArrayList<String> list = new ArrayList();
    private String newName = "";

    /**
     * 一个ArrayList存放 0：商品或分类 1：名称
     * @return
     */
    protected ArrayList<String> getList() {
        return list;
    }

    /**
     * 一个String存放名称
     * @return
     */
    protected String getNewName() {
        return newName;
    }

    @FXML
    public void onSureBtnClicked(){
        if(name.getText() == null) return;
        switch (name.getText()) {
            case "商品":
                type = "goods";
                goodsID = goodsBLService.newGoods(name.getText(),"");
                this.newName = name.getText();
                list.add(type);
            case "商品分类":
                type = "goodsCategory";
                goodsBLService.newGoodsCategory(name.getText(),"");
                this.newName = name.getText();
                list.add(type);
            default:
                list.add(name.getText());
                root.getScene().getWindow().hide();
        }
    }

    @FXML
    public void onCancelBtnClicked(){
        root.getScene().getWindow().hide();
    }
}
