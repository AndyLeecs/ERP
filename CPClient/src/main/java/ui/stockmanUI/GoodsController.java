package ui.stockmanUI;

import VO.goodsVO.GoodsCategoryVO;
import VO.goodsVO.GoodsVO;
import bl.goodsbl.GoodsBLServiceImpl;
import bl.goodsbl.GoodsCategory;
import blservice.goodsblservice.GoodsBLService;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class GoodsController{

    @FXML public Label presentLocation;

    @FXML public Button goodsNameSearchBtn;
    @FXML public Button goodsTypeSearchBtn;
    @FXML public Button goodsIDSearchBtn;

	@FXML public ImageView editBtn;

    @FXML public TextField searchField;
	@FXML public Button searchBtn;

	@FXML public TextField goodsID;
    @FXML public TextField goodsName;
    @FXML public TextField goodsType;
    @FXML public TextField goodsCategory;
    @FXML public TextField goodsBuyPrice;
    @FXML public TextField goodsSellPrice;
    @FXML public TextField recentBuyPrice;
    @FXML public TextField recentSellPrice;
    @FXML public TextField goodsStoreNum;

    @FXML public VBox vBox;
    protected TreeView<String> treeView;
    private TreeItem<String> rootTreeItem;

    @FXML Pane notice;
    @FXML Label noticeLabel;
    @FXML private TextField name;
    @FXML Button sureBtn;
    @FXML Button cancelBtn;

    @FXML VBox goodsVBox;
    @FXML Pane goodsPane;
    private String goodsTypeSearch = "";//保存模糊查找的类型
    GoodsBLService goodsBLService = new GoodsBLServiceImpl();//
    private ArrayList<GoodsVO> goodsVOArrayList = new ArrayList<>();//存放模糊查找到的商品列表

    Stack<TreeItem<String>> stack = new Stack<>();//存放目录的引用 便于增减改名商品

    //初始化节点的方法
    private void setNode(TreeItem<String> node){
        ArrayList<String> list = (ArrayList<String>) goodsBLService.getAllCategory(node.getValue().toString().substring(3));
        if(list != null){
            for(int i =0;i<list.size();i++){
                TreeItem<String> son = new TreeItem<>("分类：" + list.get(i));
                son.setGraphic(new ImageView("img/folderIcon.png"));
                node.getChildren().add(son);
                setNode(son);
            }
        }else{
            ArrayList<GoodsVO> goods = (ArrayList<GoodsVO>) goodsBLService.findGoods(node.getValue().toString().substring(3),"goodsCategory");
            if(goods!=null) {
                for (int i = 0; i < goods.size(); i++) {
                    node.getChildren().add(new TreeItem<>("商品：" + goods.get(i).getGoodsName()));
                }
            }
        }
    }

    //初始TreeView 加载所有商品和分类
    private void initTreeView(){

        presentLocation.addEventHandler(MouseEvent.MOUSE_CLICKED,event -> System.out.println("标签被点击"));
        //在ScrollPane上配置并加入TreeView
        rootTreeItem = new TreeItem<String>("分类：根目录");
        rootTreeItem.setExpanded(true);

        //setNode(rootTreeItem);
        //以下为demo

        for(int i =0;i<5;i++) {
            TreeItem<String> item = new TreeItem<String>("分类：" + i);
            item.setGraphic(new ImageView("img/folderIcon.png"));
            rootTreeItem.getChildren().add(item);
           
            TreeItem<String> item1 = new TreeItem<String>("商品：" + i);
           
            item.getChildren().add(item1);

        }

        //以上为demo

        treeView = new TreeView<>(rootTreeItem);
        vBox.getChildren().add(treeView);
        treeView.addEventHandler(MouseEvent.MOUSE_CLICKED,event ->
                {
                    TreeItem<String> goodsItem = treeView.getSelectionModel().getSelectedItem();
                    System.out.println(goodsItem.getValue().toString() + "被点击");

                    if(goodsItem.getValue().toString().contains("商品")) {
                        System.out.println("是商品项 可以进行下一步操作");
                        goodsVBox.getChildren().clear();
                        //为了测试运行结果 先注释下面一行从数据库获取对应商品信息的语句
                        newGoodsPane(goodsBLService.getGoods(goodsItem.getValue().toString().substring(3),goodsItem.getParent().getValue().substring(3)));
                    }

                }

                    );

        //设置右键菜单
        ContextMenu menu = new ContextMenu();
        menu.setStyle("-fx-background-color: #FF7575");

        MenuItem newGoodsBar = new MenuItem("新建商品");
        newGoodsBar.setGraphic(new ImageView("img/add.png"));
        
        newGoodsBar.setOnAction(e->{

            //通过命名来区分商品项和分类项 除此之外有别的方法则可用别的方法替换 （比如分类有文件夹图片区分）
            //命名格式： 商品：小台灯 分类：彩灯
            //判断当前节点是否可添加商品
            TreeItem<String> selectItem = (TreeItem<String>) treeView.getSelectionModel().getSelectedItem();

            System.out.println("选中项文字 " + selectItem.getValue().toString());
            System.out.println("选中项子节点文字" + selectItem.getChildren().toString());

            if((selectItem.getValue().toString().contains("分类") && selectItem.isLeaf()) || (selectItem.getValue().toString().contains("分类") && selectItem.getChildren().toString().contains("商品"))) {

                TreeItem<String> goodsTreeItem = new TreeItem<>("商品："+rootTreeItem.getChildren().size());
                selectItem.getChildren().add(goodsTreeItem);
                stack.push(goodsTreeItem);
                noticeLabel.setText("新建商品");
                notice.setVisible(true);
            }else{
                presentLocation.setText("此节点下不可添加商品");
                System.out.println("此节点下不可添加商品");
            }

        });

        MenuItem newCategoryBar = new MenuItem("新建分类");
        newCategoryBar.setGraphic(new ImageView("img/folder.png"));
        newCategoryBar.setOnAction(e->{


                //通过命名来区分商品项和分类项 除此之外有别的方法则可用别的方法替换 （比如分类有文件夹图片区分）
                //命名格式： 商品：小台灯 分类：彩灯
                //判断当前节点是否可添加分类
                TreeItem selectItem = (TreeItem) treeView.getSelectionModel().getSelectedItem();

            System.out.println("选中项文字 " + selectItem.getValue().toString());
            System.out.println("选中项子节点文字" + selectItem.getChildren().toString());

                if ((selectItem.toString().contains("分类") && selectItem.isLeaf()) || (selectItem.toString().contains("分类") && selectItem.getChildren().toString().contains("分类"))) {

                    TreeItem<String> categoryTreeItem = new TreeItem<>("分类："+rootTreeItem.getChildren().size());
                    categoryTreeItem.setGraphic(new ImageView("img/folderIcon.png"));
                    selectItem.getChildren().add(categoryTreeItem);
                    stack.push(categoryTreeItem);
                    noticeLabel.setText("新建分类");
                    notice.setVisible(true);
                } else {
                    presentLocation.setText("此节点下不可添加分类");
                    System.out.println("此节点下不可添加分类");
                }
        });

        MenuItem deleteBar = new MenuItem("删除");
        deleteBar.setGraphic(new ImageView("img/delete.png"));
        deleteBar.setOnAction(e ->{
            TreeItem selectItem = (TreeItem) treeView.getSelectionModel().getSelectedItem();
            selectItem.getParent().getChildren().remove(selectItem);

            System.out.println("判断删除的是商品还是分类：" + selectItem.getValue().toString().substring(0,2));

            switch (selectItem.getValue().toString().substring(0,2)){
                case "商品":
                    System.out.println("删除商品所属分类：" + selectItem.getParent().getValue().toString().substring(3)+ " 删除商品名称：" + selectItem.getValue().toString().substring(3));
                    goodsBLService.deleteGoods(selectItem.getParent().getValue().toString().substring(3),selectItem.getValue().toString().substring(3));//
                    break;

                case "分类":
                    System.out.println("删除分类名称：" + selectItem.getValue().toString().substring(3));
                    GoodsCategoryVO goodsCategoryVO = new GoodsCategoryVO(selectItem.getValue().toString().substring(3),selectItem.getParent().getValue().toString().substring(3));
                    goodsBLService.deleteGoodsCategory(goodsCategoryVO);
                    break;
            }
        });

        MenuItem refactorBar = new MenuItem("改名");
        refactorBar.setGraphic(new ImageView("img/survey.png"));
        refactorBar.setOnAction(e->{

            TreeItem selectItem = (TreeItem) treeView.getSelectionModel().getSelectedItem();
            stack.push(selectItem);
            noticeLabel.setText("修改名称");
            notice.setVisible(true);
        });

        menu.getItems().add(newGoodsBar);
        menu.getItems().add(newCategoryBar);
        menu.getItems().add(refactorBar);
        menu.getItems().add(deleteBar);
        treeView.setContextMenu(menu);
    }

    /**
     * 初始化页面
     * 清除商品搜索项goodsVBox中的商品项
     */
    @FXML
    public void initialize(){
        notice.setVisible(false);
        initTreeView();
        //goodsVBox.getChildren().clear();
    }


    /**
     * 编辑商品信息
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
     * 模糊查找商品确认按钮
     */
	@FXML
    private void setSearchBtn(){
	    if(searchField.getText()!=null){
	        switch (this.goodsTypeSearch){
                case "商品名":
                    this.goodsTypeSearch = "goodsName";
                    break;
                case "商品型号":
                    this.goodsTypeSearch = "goodsType";
                    break;
                case "商品编号":
                    this.goodsTypeSearch = "goodsID";
                    break;
            }
            goodsVOArrayList = (ArrayList<GoodsVO>)goodsBLService.findGoods(searchField.getText(),this.goodsTypeSearch);
	        goodsVBox.getChildren().clear();
	        for(int i =0;i<goodsVOArrayList.size();i++){
	            newGoodsPane(goodsVOArrayList.get(i));
            }
        }
	}

	//临时包装一下刚生成的只有id，名称和种类的商品
    GoodsVO tmpVO = new GoodsVO("0"
            ,"商品分类"
            ,"商品名称"
            ,"商品种类"
            ,0
            ,0
            ,0
            ,0);
    /**
     * 新建分类，新建商品，修改名称出现的提示框
     * 其中stack存放TreeItem的引用
     * 此方法只是修改对应目录名称，新建工作已在上一层做好
     */
    @FXML
    public void onSureBtnClicked(){
        String tmp = "";
        switch (noticeLabel.getText()){
            case "新建商品":
                tmp = "商品：";
                stack.peek().setValue(tmp + "" + name.getText());
                String id = goodsBLService.newGoodsID();
                tmpVO.setGoodsID(id);
                tmpVO.setGoodsName(name.getText());
                tmpVO.setGoodsCategory(stack.peek().getParent().getValue().toString().substring(0,3));
                goodsBLService.initAndSaveGoods(tmpVO);
            break;

            case "新建分类":
                tmp = "分类：";
                stack.peek().setValue(tmp + "" + name.getText());
                GoodsCategoryVO goodsCategoryVO = new GoodsCategoryVO(name.getText(),stack.peek().getParent().getValue().toString().substring(3));
                goodsBLService.newGoodsCategory(goodsCategoryVO);
                //以下部分由于数据层没有搭好暂不能正常运行 故加注释
                /*
                ArrayList<String> arrayList = (ArrayList<String>) goodsBLService.getAllCategory(""); //参数为空 表示返回所有分类名
                for(int i = 0;i<arrayList.size();i++){
                    if(name.getText().equals(arrayList.get(i))){
                        noticeLabel.setText("分类名称重复，请换其他分类名称");
                    }
                    if(i == arrayList.size() - 1){
                        stack.peek().setValue(tmp + "" + name.getText());
                    }
                }*/
            break;

            case "修改名称":
                tmp = stack.peek().getValue().toString();
                System.out.println("原始名称为："+ tmp);
                System.out.println("修改后为：" + tmp.substring(0,3));
                stack.peek().setValue(tmp.substring(0,3) + name.getText());
                if(tmp.substring(0,3).contains("分类")){
                    System.out.println("原来分类名：" + tmp.substring(3) + "新分类名：" + name.getText());
                    GoodsCategoryVO goodsCategoryVOOld = new GoodsCategoryVO(tmp,stack.peek().getParent().getValue().substring(3));
                    GoodsCategoryVO goodsCategoryVONew = new GoodsCategoryVO(name.getText(),stack.peek().getParent().getValue().substring(3));
                    goodsBLService.modifyGoodsCategory(goodsCategoryVOOld,goodsCategoryVONew);

                }

                //惰性删除ui上该分类 对于数据库内数据不改动
                if(tmp.substring(0,3).contains("商品")){
                    System.out.println("原来商品名：" + tmp.substring(3) + "新商品名：" + name.getText());
                    GoodsVO goodsVO = goodsBLService.getGoods(tmp.substring(3),stack.peek().getParent().getValue().toString().substring(3));
                    goodsVO.setGoodsName(name.getText());
                    goodsBLService.modifyGoods(goodsVO);
                }
            break;
        }
        notice.setVisible(false);
        name.clear();
        stack.pop();
    }

    @FXML
    public void onCancelBtnClicked(){
        notice.setVisible(false);
        name.clear();
        stack.pop();
    }

    @FXML
    public void onGoodsNameSearchBtnClicked(){
        searchField.setPromptText("模糊查找" + goodsNameSearchBtn.getText());
        this.goodsTypeSearch = goodsNameSearchBtn.getText();
    }

    @FXML
    public void onGoodsTypeSearchBtnClicked(){
        searchField.setPromptText("模糊查找" + goodsTypeSearchBtn.getText());
        this.goodsTypeSearch = goodsTypeSearchBtn.getText();
    }

    @FXML
    public void onGoodsIDSearchBtnClicked(){
        searchField.setPromptText("模糊查找" + goodsIDSearchBtn.getText());
        this.goodsTypeSearch = goodsIDSearchBtn.getText();
    }

    public void newGoodsPane(GoodsVO goodsVO) {
        //复杂的新建商品页面逻辑
        Pane newPane = new Pane();
        newPane.setPrefSize(663,435);
        newPane.setLayoutX(0);
        newPane.setLayoutY(0);

        ImageView imageView = new ImageView("img/lamp1.JPG");
        imageView.setLayoutX(0);
        imageView.setLayoutY(0);
        imageView.setFitWidth(200);
        imageView.setFitHeight(200);
        newPane.getChildren().add(imageView);

        Label greenLabel = new Label();
        greenLabel.setLayoutX(233);
        greenLabel.setLayoutY(41);
        greenLabel.setPrefSize(12,37);
        greenLabel.setStyle("-fx-background-color:  #4F9D9D");
        newPane.getChildren().add(greenLabel);

        Label goodsIDLabel = new Label("商品编号");
        goodsIDLabel.setLayoutX(245);
        goodsIDLabel.setLayoutY(119);
        goodsIDLabel.setPrefSize(52,17);
        goodsIDLabel.setFont(Font.font(13));
        goodsIDLabel.setTextFill(Color.gray(0,0.63));
        newPane.getChildren().add(goodsIDLabel);

        Label goodsStoreLabel = new Label("库存数量");
        goodsStoreLabel.setLayoutX(245);
        goodsStoreLabel.setLayoutY(161);
        goodsStoreLabel.setPrefSize(52,17);
        goodsStoreLabel.setFont(Font.font(13));
        goodsStoreLabel.setTextFill(Color.gray(0,0.63));
        newPane.getChildren().add(goodsStoreLabel);

        Label goodsBuyPriceLabel = new Label("进价");
        goodsBuyPriceLabel.setLayoutX(258);
        goodsBuyPriceLabel.setLayoutY(238);
        goodsBuyPriceLabel.setPrefSize(52,17);
        goodsBuyPriceLabel.setFont(Font.font(13));
        goodsBuyPriceLabel.setTextFill(Color.gray(0,0.63));
        newPane.getChildren().add(goodsBuyPriceLabel);

        Label goodsSellPriceLabel = new Label("销售价");
        goodsSellPriceLabel.setLayoutX(251);
        goodsSellPriceLabel.setLayoutY(300);
        goodsSellPriceLabel.setPrefSize(39,36);
        goodsSellPriceLabel.setFont(Font.font(13));
        goodsSellPriceLabel.setTextFill(Color.gray(0,0.63));
        newPane.getChildren().add(goodsSellPriceLabel);

        Label recentBuyPriceLabel = new Label("最近进价");
        recentBuyPriceLabel.setLayoutX(462);
        recentBuyPriceLabel.setLayoutY(238);
        recentBuyPriceLabel.setPrefSize(52,17);
        recentBuyPriceLabel.setFont(Font.font(13));
        recentBuyPriceLabel.setTextFill(Color.gray(0,0.63));
        newPane.getChildren().add(recentBuyPriceLabel);

        Label recentSellPriceLabel = new Label("最近销售价");
        recentSellPriceLabel.setLayoutX(462);
        recentSellPriceLabel.setLayoutY(311);
        recentSellPriceLabel.setPrefSize(65,17);
        recentSellPriceLabel.setFont(Font.font(13));
        recentSellPriceLabel.setTextFill(Color.gray(0,0.63));
        newPane.getChildren().add(recentSellPriceLabel);

        Label newGoodsName = new Label(goodsVO.getGoodsName());
        newGoodsName.setLayoutX(251);
        newGoodsName.setLayoutY(48);
        newGoodsName.setPrefSize(75, 37);
        newGoodsName.setFont(Font.font(18));
        newGoodsName.setStyle("-fx-background-color: transparent");
        newGoodsName.setStyle("-fx-background-radius: 20");
        newGoodsName.setStyle("-fx-border-radius: 20");
        newPane.getChildren().add(newGoodsName);

        Label newGoodsType = new Label(goodsVO.getGoodsType());
        newGoodsType.setLayoutX(364);
        newGoodsType.setLayoutY(62);
        newGoodsType.setPrefSize(89, 32);
        newGoodsType.setFont(Font.font(16));
        newGoodsType.setStyle("-fx-background-color: transparent");
        newGoodsType.setStyle("-fx-background-radius: 20");
        newGoodsType.setStyle("-fx-border-radius: 20");
        newPane.getChildren().add(newGoodsType);

        Label newGoodsCategory = new Label(goodsVO.getGoodsCategory());
        newGoodsCategory.setLayoutX(470);
        newGoodsCategory.setLayoutY(62);
        newGoodsCategory.setPrefSize(89, 32);
        newGoodsCategory.setFont(Font.font(16));
        newGoodsCategory.setStyle("-fx-background-color: transparent");
        newGoodsCategory.setStyle("-fx-background-radius: 20");
        newGoodsCategory.setStyle("-fx-border-radius: 20");
        newPane.getChildren().add(newGoodsCategory);

        Label newGoodsID = new Label(goodsVO.getGoodsID());
        newGoodsID.setLayoutX(311);
        newGoodsID.setLayoutY(114);
        newGoodsID.setPrefSize(213, 17);
        newGoodsID.setStyle("-fx-background-color: transparent");
        newGoodsID.setStyle("-fx-background-radius: 20");
        newGoodsID.setStyle("-fx-border-radius: 20");
        newPane.getChildren().add(newGoodsID);

        Label newGoodsInventory = new Label(" ");//后期获取商品库存
        newGoodsInventory.setLayoutX(337);
        newGoodsInventory.setLayoutY(154);
        newGoodsInventory.setPrefSize(39, 32);
        newGoodsInventory.setFont(Font.font(16));
        newGoodsInventory.setStyle("-fx-background-color: transparent");
        newGoodsInventory.setStyle("-fx-background-radius: 20");
        newGoodsInventory.setStyle("-fx-border-radius: 20");
        newPane.getChildren().add(newGoodsInventory);

        Label newGoodsBuyPrice = new Label("" + goodsVO.getGoodsBuyPrice());
        newGoodsBuyPrice.setLayoutX(331);
        newGoodsBuyPrice.setLayoutY(224);
        newGoodsBuyPrice.setPrefSize(89, 45);
        newGoodsBuyPrice.setFont(Font.font(24));
        newGoodsBuyPrice.setStyle("-fx-background-color: transparent");
        newGoodsBuyPrice.setStyle("-fx-background-radius: 20");
        newGoodsBuyPrice.setStyle("-fx-border-radius: 20");
        newPane.getChildren().add(newGoodsBuyPrice);

        Label newGoodsSellPrice = new Label("" + goodsVO.getGoodsSellPrice());
        newGoodsSellPrice.setLayoutX(331);
        newGoodsSellPrice.setLayoutY(297);
        newGoodsSellPrice.setPrefSize(89, 17);
        newGoodsSellPrice.setFont(Font.font(24));
        newGoodsSellPrice.setStyle("-fx-background-color: transparent");
        newGoodsSellPrice.setStyle("-fx-background-radius: 20");
        newGoodsSellPrice.setStyle("-fx-border-radius: 20");
        newPane.getChildren().add(newGoodsSellPrice);

        Label newRecentBuyPrice = new Label("" + goodsVO.recentBuyPrice());
        newRecentBuyPrice.setLayoutX(556);
        newRecentBuyPrice.setLayoutY(224);
        newRecentBuyPrice.setPrefSize(89, 17);
        newRecentBuyPrice.setFont(Font.font(24));
        newRecentBuyPrice.setStyle("-fx-background-color: transparent");
        newRecentBuyPrice.setStyle("-fx-background-radius: 20");
        newRecentBuyPrice.setStyle("-fx-border-radius: 20");
        newPane.getChildren().add(newRecentBuyPrice);

        Label newRecentSellPrice = new Label("" + goodsVO.recentSellPrice());
        newRecentSellPrice.setLayoutX(556);
        newRecentSellPrice.setLayoutY(297);
        newRecentSellPrice.setPrefSize(89, 17);
        newRecentSellPrice.setFont(Font.font(24));
        newRecentSellPrice.setStyle("-fx-background-color: transparent");
        newRecentSellPrice.setStyle("-fx-background-radius: 20");
        newRecentSellPrice.setStyle("-fx-border-radius: 20");
        newPane.getChildren().add(newRecentSellPrice);

        ImageView edit = new ImageView("img/edit.png");
        edit.setLayoutX(631);
        edit.setLayoutY(23);
        edit.setFitHeight(25);
        edit.setFitWidth(25);
        edit.setOnMousePressed(event -> {
            try {
                new GoodsInfoEditWin();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        newPane.getChildren().add(edit);

        newPane.setStyle("-fx-background-color: #FFB5B5");
        System.out.println("new Pane init Success!");
        goodsVBox.getChildren().add(newPane);
    }
}