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
    GoodsController goodsController;
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
                goodsID = goodsBLService.newGoods(name.getText(),goodsController.treeView.getSelectionModel().getSelectedItem().getParent().getValue().toString().substring(0,3));
                this.newName = name.getText();
                list.add(type);
                break;

            case "商品分类":
                type = "goodsCategory";
                TreeItem<String> currentNode = goodsController.treeView.getSelectionModel().getSelectedItem();
                String tmp = name.getText();
                while(!currentNode.getParent().getValue().contains("根节点")){
                    tmp = currentNode.getParent().getValue().toString().substring(3) + "/" + tmp;
                }
                goodsBLService.newGoodsCategory(tmp);//这里路径要注意下是整个路径
                this.newName = name.getText();
                list.add(type);
                break;

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
