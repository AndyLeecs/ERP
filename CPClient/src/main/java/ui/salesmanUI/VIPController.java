package ui.salesmanUI;

import VO.VIPVO.VIPVO;
import bl.VIPbl.VIPBLServiceImpl;
import blservice.VIPblservice.VIPBLService;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import ui.stockmanUI.GoodsInfoEditWin;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by julia98 on 2017/12/22.
 */
public class VIPController {
    @FXML public Label presentLocation;
    @FXML public Button vipNameSearchBtn;
    @FXML public Button vipTypeSearchBtn;
    @FXML public Button vipIDSearchBtn;

    @FXML public VBox vBox;
    @FXML public VBox vipVBox;
    @FXML public ImageView editBtn;

    @FXML public TextField searchField;
    @FXML public Button searchBtn;

    private String vipTypeSearch = "";//保存模糊查找的类型
    ArrayList<VIPVO> vipvos = new ArrayList<>();//存放模糊查找到的vip列表
    VIPBLService vipBLService = new VIPBLServiceImpl();
    protected TreeView<String> treeView;
    private TreeItem<String> rootTreeItem;

    //初始TreeView 加载所有商品和分类
    private void initTreeView() {

        presentLocation.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> System.out.println("标签被点击"));
        //在ScrollPane上配置并加入TreeView
        rootTreeItem = new TreeItem<String>("分类：根目录");
        rootTreeItem.setExpanded(true);

        //setNode(rootTreeItem);
        //以下为demo

        for (int i = 0; i < 5; i++) {
            TreeItem<String> item = new TreeItem<String>("分类：" + i);
            item.setGraphic(new ImageView("img/folderIcon.png"));
            rootTreeItem.getChildren().add(item);
        }

        //以上为demo

        treeView = new TreeView<>(rootTreeItem);
        vBox.getChildren().add(treeView);
        treeView.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
                {
                    TreeItem<String> vipItem = treeView.getSelectionModel().getSelectedItem();
                    System.out.println(vipItem.getValue().toString() + "被点击");

                    if (vipItem.getValue().toString().contains("商品")) {
                        System.out.println("是商品项 可以进行下一步操作");
                        vipVBox.getChildren().clear();
                        //为了测试运行结果 先注释下面一行从数据库获取对应商品信息的语句
                        //newVIPPane(vipBLService.getVIP());
                    }

                }

        );
    }

        /**
         * 编辑会员信息
         */
    @FXML
    private void setEditBtn(){
        try {
            new GoodsInfoEditWin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 模糊查找会员确认按钮
     */
    @FXML
    private void setSearchBtn(){
        if(searchField.getText()!=null){
            switch (this.vipTypeSearch){
                case "客户名":
                    this.vipTypeSearch = "name";
                    break;
                case "客户ID":
                    this.vipTypeSearch = "id";
                    break;
                case "客户电话":
                    this.vipTypeSearch = "phoneNumber";
                    break;
            }
            vipvos = (ArrayList<VIPVO>)vipBLService.findVIP(searchField.getText(),this.vipTypeSearch);
            vipVBox.getChildren().clear();
            for(int i =0;i<vipvos.size();i++){
                newVIPPane(vipvos.get(i));
            }
        }
    }

    @FXML
    public void onVIPNameSearchBtnClicked(){
        searchField.setPromptText("模糊查找" + vipNameSearchBtn.getText());
        this.vipTypeSearch = vipNameSearchBtn.getText();
    }

    @FXML
    public void onVIPIDSearchBtnClicked(){
        searchField.setPromptText("模糊查找" + vipIDSearchBtn.getText());
        this.vipTypeSearch = vipIDSearchBtn.getText();
    }

    @FXML
    public void onVIPPhoneNumberSearchBtnClicked(){
        searchField.setPromptText("模糊查找" + vipTypeSearchBtn.getText());
        this.vipTypeSearch = vipTypeSearchBtn.getText();
    }

    private  void newVIPPane(VIPVO vipvo){}



}
