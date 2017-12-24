package ui.salesmanUI;

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
                        newVIPPane(vipBLService.getVIP(vipItem.getValue().toString().substring(3)));
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
        anchorPane.setPrefSize(703,480);
        anchorPane.setStyle("-fx-background-color: #FFB5B5");
        vipVBox.getChildren().add(anchorPane);
        GridPane gridPane = new GridPane();
        gridPane.setLayoutX(36);
        gridPane.setLayoutY(42);
        gridPane.setPrefWidth(612);
        gridPane.setPrefHeight(352);
        anchorPane.getChildren().add(gridPane);

        Label greenLabel = new Label();
        greenLabel.setPrefSize(12,37);
        greenLabel.setStyle("-fx-background-color:  #4F9D9D");
        gridPane.add(greenLabel,0,0);

        Label vipInfoLabel = new Label("   客户信息");
        vipInfoLabel.setPrefSize(98,23);
        vipInfoLabel.setFont(Font.font(18));
        gridPane.add(vipInfoLabel,0,0);

        Label vipNameLabel = new Label("姓名");
        vipNameLabel.setPrefSize(123,39);
        vipNameLabel.setFont(Font.font(13));
        vipNameLabel.setTextFill(Color.gray(0,0.63));
        gridPane.add(vipNameLabel,0,1);

        Label vipIDLabel = new Label("编号");
        vipIDLabel.setPrefSize(123,39);
        vipIDLabel.setFont(Font.font(13));
        vipIDLabel.setTextFill(Color.gray(0,0.63));
        gridPane.add(vipIDLabel,3,1);

        Label vipCategoryLabel = new Label("分类");
        vipCategoryLabel.setPrefSize(123,39);
        vipCategoryLabel.setFont(Font.font(13));
        vipCategoryLabel.setTextFill(Color.gray(0,0.63));
        gridPane.add(vipCategoryLabel,0,2);

        Label vipGradeLabel = new Label("分类");
        vipGradeLabel.setPrefSize(123,39);
        vipGradeLabel.setFont(Font.font(13));
        vipGradeLabel.setTextFill(Color.gray(0,0.63));
        gridPane.add(vipGradeLabel,3,2);

        Label vipPhoneNumberLabel = new Label("电话");
        vipPhoneNumberLabel.setPrefSize(123,39);
        vipPhoneNumberLabel.setFont(Font.font(13));
        vipPhoneNumberLabel.setTextFill(Color.gray(0,0.63));
        gridPane.add(vipPhoneNumberLabel,0,3);

        Label vipAddressLabel = new Label("地址");
        vipAddressLabel.setPrefSize(123,39);
        vipAddressLabel.setFont(Font.font(13));
        vipAddressLabel.setTextFill(Color.gray(0,0.63));
        gridPane.add(vipAddressLabel,3,3);

        Label vipEmailLabel = new Label("地址");
        vipEmailLabel.setPrefSize(123,39);
        vipEmailLabel.setFont(Font.font(13));
        vipEmailLabel.setTextFill(Color.gray(0,0.63));
        gridPane.add(vipEmailLabel,0,4);

        Label vipPostCodeLabel = new Label("邮编");
        vipPostCodeLabel.setPrefSize(123,39);
        vipPostCodeLabel.setFont(Font.font(13));
        vipPostCodeLabel.setTextFill(Color.gray(0,0.63));
        gridPane.add(vipPostCodeLabel,3,4);

        Label greenLabel2 = new Label();
        greenLabel2.setPrefSize(12,37);
        greenLabel2.setStyle("-fx-background-color:  #4F9D9D");
        gridPane.add(greenLabel2,0,6);

        Label vipCollectPaymentLabel = new Label("   应收应付");
        vipCollectPaymentLabel.setPrefSize(98,23);
        vipCollectPaymentLabel.setFont(Font.font(18));
        gridPane.add(vipCollectPaymentLabel,0,6);

        Label vipCollectLimitLabel = new Label("应收额度");
        vipCollectLimitLabel.setPrefSize(123,39);
        vipCollectLimitLabel.setFont(Font.font(13));
        vipCollectLimitLabel.setTextFill(Color.gray(0,0.63));
        gridPane.add(vipCollectLimitLabel,0,7);

        Label vipCollectLabel = new Label("应收");
        vipCollectLabel.setPrefSize(123,39);
        vipCollectLabel.setFont(Font.font(13));
        vipCollectLabel.setTextFill(Color.gray(0,0.63));
        gridPane.add(vipCollectLabel,3,7);

        Label vipClerkLabel = new Label("业务员");
        vipClerkLabel.setPrefSize(123,39);
        vipClerkLabel.setFont(Font.font(13));
        vipClerkLabel.setTextFill(Color.gray(0,0.63));
        gridPane.add(vipClerkLabel,0,8);

        Label vipPaymentLabel = new Label("业务员");
        vipPaymentLabel.setPrefSize(123,39);
        vipPaymentLabel.setFont(Font.font(13));
        vipPaymentLabel.setTextFill(Color.gray(0,0.63));
        gridPane.add(vipPaymentLabel,3,8);

        ImageView edit = new ImageView("img/edit.png");
        edit.setFitHeight(25);
        edit.setFitWidth(25);
        edit.setOnMousePressed(event -> {
            try {
                new VIPInfoEditWin();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        gridPane.add(edit,4,0);

        TextField vipID = new TextField();
        vipID.setText(vipvo.getId());
        vipID.setEditable(false);
        vipID.setPrefSize(123,27);
        gridPane.add(vipID,4,1);

        TextField vipCategory = new TextField();
        vipCategory.setText(vipvo.getCategory());
        vipCategory.setEditable(false);
        vipCategory.setPrefSize(123,27);
        gridPane.add(vipCategory,1,2);

        TextField vipGrade = new TextField();
        vipGrade.setText(vipvo.getGrade());
        vipGrade.setEditable(false);
        vipGrade.setPrefSize(123,27);
        gridPane.add(vipGrade,4,2);

        TextField vipName = new TextField();
        vipName.setText(vipvo.getName());
        vipName.setEditable(false);
        vipName.setPrefSize(123,27);;
        gridPane.add(vipName,1,1);

        TextField vipPhoneNumber = new TextField();
        vipPhoneNumber.setText(vipvo.getPhoneNumber());
        vipPhoneNumber.setEditable(false);
        vipPhoneNumber.setPrefSize(123,27);;
        gridPane.add(vipPhoneNumber,1,3);

        TextField vipEmail = new TextField();
        vipEmail.setText(vipvo.getEmail());
        vipEmail.setEditable(false);
        vipEmail.setPrefSize(123,27);
        gridPane.add(vipEmail,1,4);

        TextField vipAddress = new TextField();
        vipAddress.setText(vipvo.getAddress());
        vipAddress.setEditable(false);
        vipAddress.setPrefSize(123,27);;
        gridPane.add(vipAddress,4,3);

        TextField vipPostCode = new TextField();
        vipPostCode.setText(vipvo.getPostCode());
        vipPostCode.setEditable(false);
        vipPostCode.setPrefSize(123,27);
        gridPane.add(vipPostCode,4,4);

        TextField collection = new TextField();
        collection.setText(""+vipvo.getCollection());
        collection.setEditable(false);
        collection.setPrefSize(123,27);
        gridPane.add(collection,4,7);

        TextField collectionLimit = new TextField();
        collectionLimit.setText(""+vipvo.getCollectionLimit());
        collectionLimit.setEditable(false);
        collectionLimit.setPrefSize(123,27);
        gridPane.add(collectionLimit,1,7);

        TextField payment = new TextField();
        payment.setText(""+vipvo.getPayment());
        payment.setEditable(false);
        payment.setPrefSize(123,27);;
        gridPane.add(payment,4,8);

        TextField clerk = new TextField();
        clerk.setText(vipvo.getClerk());
        clerk.setEditable(false);
        clerk.setPrefSize(123,27);
        gridPane.add(clerk,1,8);

        Label tmpLabel = new Label();
        tmpLabel.setPrefSize(123,39);
        gridPane.addColumn(2,tmpLabel,tmpLabel,tmpLabel,tmpLabel,tmpLabel,tmpLabel,tmpLabel,tmpLabel);

        System.out.println("new Pane init Success!");
    }
}
