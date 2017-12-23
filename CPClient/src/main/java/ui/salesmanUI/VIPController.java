package ui.salesmanUI;

import VO.VIPVO.VIPCategory;
import VO.VIPVO.VIPGrade;
import VO.VIPVO.VIPVO;
import bl.VIPbl.VIPBLServiceImpl;
import blservice.VIPblservice.VIPBLService;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by julia98 on 2017/12/22.
 */
public class VIPController {
    @FXML public Label presentLocation;
    @FXML public Button vipNameSearchBtn;
    @FXML public Button vipPhoneNumberSearchBtn;
    @FXML public Button vipIDSearchBtn;

    @FXML public VBox vBox;
    @FXML public VBox vipVBox;
    @FXML public ImageView editBtn;

    @FXML public TextField searchField;
    @FXML public Button searchBtn;

    @FXML private TextField vipID; //编号
    @FXML private TextField vipCategory; //分类
    @FXML private TextField vipGrade; //级别
    @FXML private TextField vipName; //姓名
    @FXML private TextField vipPhoneNumber;//电话号码
    @FXML private TextField vipEmail; //电子邮箱
    @FXML private TextField vipAddress; //地址
    @FXML private TextField vipPostCode; //邮编
    @FXML private TextField collection;//应收
    @FXML private TextField collectionLimit;//应收额度
    @FXML private TextField payment; //应付
    @FXML private TextField clerk; // 默认业务员

    private String vipTypeSearch = "";//保存模糊查找的类型
    ArrayList<VIPVO> vipvos = new ArrayList<>();//存放模糊查找到的vip列表
    VIPBLService vipBLService = new VIPBLServiceImpl();
    protected TreeView<String> treeView;
    private TreeItem<String> rootTreeItem;

    public void setTextFieldUnable(){
        vipID.setEditable(false);
        vipCategory.setEditable(false);
        vipGrade.setEditable(false);
        vipName.setEditable(false);
        vipPhoneNumber.setEditable(false);
        vipEmail.setEditable(false);
        vipAddress.setEditable(false);
        vipPostCode.setEditable(false);
        collection.setEditable(false);
        collectionLimit.setEditable(false);
        payment.setEditable(false);
        clerk.setEditable(false);
    }

    public void initialize(){
        initTreeView();
        setTextFieldUnable();
    }
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

            TreeItem<String> item1 = new TreeItem<String>("会员：" + i);
            item.getChildren().add(item1);
        }

        //以上为demo

        treeView = new TreeView<>(rootTreeItem);
        vBox.getChildren().add(treeView);
        treeView.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
                {
                    TreeItem<String> vipItem = treeView.getSelectionModel().getSelectedItem();
                    System.out.println(vipItem.getValue().toString() + "被点击");

                    if (vipItem.getValue().toString().contains("会员")) {
                        System.out.println("是会员项 可以进行下一步操作");
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
            new VIPInfoEditWin();
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
        searchField.setPromptText("模糊查找" + vipPhoneNumberSearchBtn.getText());
        this.vipTypeSearch = vipPhoneNumberSearchBtn.getText();
    }

    private void newVIPPane(VIPVO vipvo){
        AnchorPane anchorPane = new AnchorPane();
        GridPane gridPane = new GridPane();
        gridPane.setLayoutX(36);
        gridPane.setLayoutY(42);
        gridPane.setPrefWidth(612);
        gridPane.setPrefHeight(352);

        Label greenLabel = new Label();
        greenLabel.setPrefSize(12,37);
        greenLabel.setStyle("-fx-background-color:  #4F9D9D");
        gridPane.add(greenLabel,0,0);

        Label vipInfoLabel = new Label("客户信息");
        vipInfoLabel.setPrefSize(52,17);
        vipInfoLabel.setFont(Font.font(13));
        vipInfoLabel.setTextFill(Color.gray(0,0.63));
        gridPane.add(vipInfoLabel,0,0);

        Label vipNameLabel = new Label("姓名");
        vipNameLabel.setPrefSize(52,17);
        vipNameLabel.setFont(Font.font(13));
        vipNameLabel.setTextFill(Color.gray(0,0.63));
        gridPane.add(vipNameLabel,0,1);

        Label vipPhoneNumberLabel = new Label("电话");
        vipPhoneNumberLabel.setPrefSize(52,17);
        vipPhoneNumberLabel.setFont(Font.font(13));
        vipPhoneNumberLabel.setTextFill(Color.gray(0,0.63));
        gridPane.add(vipPhoneNumberLabel,0,0);



    }



}
