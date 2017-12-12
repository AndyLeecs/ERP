package ui.stockmanUI;

import VO.goodsVO.GoodsVO;
import bl.goodsbl.Goods;
import blservice.goodsblservice.GoodsBLService;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

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
    private TreeItem rootTreeItem;

    @FXML Pane notice;
    @FXML Label noticeLabel;
    @FXML private TextField name;
    @FXML Button sureBtn;
    @FXML Button cancelBtn;

    @FXML VBox goodsVBox;
    @FXML Pane goodsPane;
    private String goodsTypeSearch = "";//保存模糊查找的类型
    GoodsBLService goodsBLService = new Goods();//
    private ArrayList<GoodsVO> goodsVOArrayList = new ArrayList<>();//存放模糊查找到的商品列表

    Stack<TreeItem> stack = new Stack<>();//存放目录的引用 便于增减改名商品

    //初始TreeView 加载所有商品和分类
    private void initTreeView(){
        //在ScrollPane上配置并加入TreeView
        rootTreeItem = new TreeItem("分类：根目录");
        rootTreeItem.setExpanded(true);

        ArrayList<String> newGoodsVOS = (ArrayList<String>) goodsBLService.getAllCategory();
        for(int i =0;i<newGoodsVOS.size();i++){
            TreeItem eachGoodsCategory = new TreeItem("分类：" + newGoodsVOS.get(i));
            eachGoodsCategory.setGraphic(new ImageView("img/folderIcon.png"));
            rootTreeItem.getChildren().add(eachGoodsCategory);

            ArrayList<GoodsVO> sameCategoryGoods = (ArrayList<GoodsVO>) goodsBLService.findGoods(newGoodsVOS.get(i),"goodsCategory");
            for(int j = 0;j<sameCategoryGoods.size();j++){
                TreeItem goods = new TreeItem("商品：" + sameCategoryGoods.get(j).getGoodsName());
                eachGoodsCategory.getChildren().add(goods);
            }
        }
        //以下为demo
        /*
        for(int i =0;i<5;i++) {
            TreeItem item = new TreeItem("分类：" + i);
            item.setGraphic(new ImageView("img/folderIcon.png"));
            rootTreeItem.getChildren().add(item);

            TreeItem item1 = new TreeItem("商品：" + i);
            item.getChildren().add(item1);
        }*/

        TreeView treeView = new TreeView<>(rootTreeItem);
        vBox.getChildren().add(treeView);

        //设置右键菜单
        ContextMenu menu = new ContextMenu();
        menu.setStyle("-fx-background-color: #FF7575");

        MenuItem newGoodsBar = new MenuItem("新建商品");
        newGoodsBar.setGraphic(new ImageView("img/add.png"));
        
        newGoodsBar.setOnAction(e->{

            //通过命名来区分商品项和分类项 除此之外有别的方法则可用别的方法替换 （比如分类有文件夹图片区分）
            //命名格式： 商品：小台灯 分类：彩灯
            //判断当前节点是否可添加商品
            TreeItem selectItem = (TreeItem) treeView.getSelectionModel().getSelectedItem();

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
                    goodsBLService.deleteGoodsCategory(selectItem.getValue().toString().substring(3));
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
     * 初始化页面时 更新当前位置
     */
    @FXML
    public void initialize(){
        notice.setVisible(false);
        initTreeView();
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
	        for(int i =0;i<goodsVOArrayList.size();i++){
	            Pane newGoodsPane = new Pane(goodsPane);

	            //复杂的新建商品页面逻辑

	            ImageView imageView = new ImageView("img/lamp1.JPG");
	            imageView.setLayoutX(0);
	            imageView.setLayoutY(0);

	            Label greenLabel = new Label();
	            greenLabel.setLayoutX(233);
	            greenLabel.setLayoutY(41);
	            greenLabel.setStyle("-fx-background-color:  #4F9D9D");

	            Label goodsIDLabel = new Label("商品编号");
	            goodsIDLabel.setLayoutX(245);
	            goodsIDLabel.setLayoutY(119);

                Label goodsStoreLabel = new Label("库存数量");
                goodsStoreLabel.setLayoutX(245);
                goodsStoreLabel.setLayoutY(116);

                Label goodsBuyPriceLabel = new Label("进价");
                goodsBuyPriceLabel.setLayoutX(245);
                goodsBuyPriceLabel.setLayoutY(119);

                Label goodsSellPriceLabel = new Label("销售价");
                goodsSellPriceLabel.setLayoutX(245);
                goodsSellPriceLabel.setLayoutY(119);

                Label recentBuyPriceLabel = new Label("最近进价");
                recentBuyPriceLabel.setLayoutX(245);
                recentBuyPriceLabel.setLayoutY(119);

                Label recentSellPriceLabel = new Label("最近销售价");
                recentSellPriceLabel.setLayoutX(245);
                recentSellPriceLabel.setLayoutY(119);

	            Label newGoodsName = new Label(goodsVOArrayList.get(i).getGoodsName());
	            newGoodsName.setLayoutX(251);
	            newGoodsName.setLayoutY(48);
	            newGoodsName.setPrefSize(75,37);
	            newGoodsName.setStyle("-fx-background-color: transparent");
	            newGoodsName.setStyle("-fx-background-radius: 20");
	            newGoodsName.setStyle("-fx-border-radius: 20");

                Label newGoodsType = new Label(goodsVOArrayList.get(i).getGoodsType());
                newGoodsType.setLayoutX(364);
                newGoodsType.setLayoutY(62);
                newGoodsType.setPrefSize(89,17);
                newGoodsType.setStyle("-fx-background-color: transparent");
                newGoodsType.setStyle("-fx-background-radius: 20");
                newGoodsType.setStyle("-fx-border-radius: 20");

                Label newGoodsCategory = new Label(goodsVOArrayList.get(i).getGoodsCategory());
                newGoodsCategory.setLayoutX(470);
                newGoodsCategory.setLayoutY(62);
                newGoodsCategory.setPrefSize(75,37);
                newGoodsCategory.setStyle("-fx-background-color: transparent");
                newGoodsCategory.setStyle("-fx-background-radius: 20");
                newGoodsCategory.setStyle("-fx-border-radius: 20");

                Label newGoodsID = new Label(goodsVOArrayList.get(i).getGoodsID());
                newGoodsID.setLayoutX(311);
                newGoodsID.setLayoutY(114);
                newGoodsID.setPrefSize(213,17);
                newGoodsID.setStyle("-fx-background-color: transparent");
                newGoodsID.setStyle("-fx-background-radius: 20");
                newGoodsID.setStyle("-fx-border-radius: 20");

                Label newGoodsInventory = new Label(" ");//后期获取商品库存
                newGoodsInventory.setLayoutX(337);
                newGoodsInventory.setLayoutY(154);
                newGoodsInventory.setPrefSize(39,32);
                newGoodsInventory.setStyle("-fx-background-color: transparent");
                newGoodsInventory.setStyle("-fx-background-radius: 20");
                newGoodsInventory.setStyle("-fx-border-radius: 20");

                Label newGoodsBuyPrice = new Label("" + goodsVOArrayList.get(i).getGoodsBuyPrice());
                newGoodsBuyPrice.setLayoutX(331);
                newGoodsBuyPrice.setLayoutY(224);
                newGoodsBuyPrice.setPrefSize(89,45);
                newGoodsBuyPrice.setStyle("-fx-background-color: transparent");
                newGoodsBuyPrice.setStyle("-fx-background-radius: 20");
                newGoodsBuyPrice.setStyle("-fx-border-radius: 20");

                Label newGoodsSellPrice = new Label("" + goodsVOArrayList.get(i).getGoodsSellPrice());
                newGoodsSellPrice.setLayoutX(331);
                newGoodsSellPrice.setLayoutY(297);
                newGoodsSellPrice.setPrefSize(89,17);
                newGoodsSellPrice.setStyle("-fx-background-color: transparent");
                newGoodsSellPrice.setStyle("-fx-background-radius: 20");
                newGoodsSellPrice.setStyle("-fx-border-radius: 20");

                Label newRecentBuyPrice = new Label("" + goodsVOArrayList.get(i).recentBuyPrice());
                newRecentBuyPrice.setLayoutX(556);
                newRecentBuyPrice.setLayoutY(224);
                newRecentBuyPrice.setPrefSize(89,17);
                newRecentBuyPrice.setStyle("-fx-background-color: transparent");
                newRecentBuyPrice.setStyle("-fx-background-radius: 20");
                newRecentBuyPrice.setStyle("-fx-border-radius: 20");

                Label newRecentSellPrice = new Label("" + goodsVOArrayList.get(i).recentSellPrice());
                newRecentSellPrice.setLayoutX(556);
                newRecentSellPrice.setLayoutY(297);
                newRecentSellPrice.setPrefSize(89,17);
                newRecentSellPrice.setStyle("-fx-background-color: transparent");
                newRecentSellPrice.setStyle("-fx-background-radius: 20");
                newRecentSellPrice.setStyle("-fx-border-radius: 20");

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

                newGoodsPane.setStyle("-fx-background-color: #FFB5B5");
	            goodsVBox.getChildren().add(newGoodsPane);
            }
        }
	}

    /**
     * 新建分类，新建商品，修改名称出现的提示框
     * 其中stack存放TreeItem的引用
     * 此方法只是修改对应目录名称，新建工作已在上一层做好
     */
    @FXML
    public void onSureBtnClicked(){
        String tmp = "";
        switch (noticeLabel.getText()){
            case "新建商品": tmp = "商品：";
                stack.peek().setValue(tmp + "" + name.getText());
                goodsBLService.newGoods(name.getText(),stack.peek().getParent().getValue().toString().substring(0,3));
            break;

            case "新建分类": tmp = "分类：";
                stack.peek().setValue(tmp + "" + name.getText());
                goodsBLService.newGoodsCategory(name.getText(),"");
            break;

            case "修改名称": tmp = stack.peek().getValue().toString();
            System.out.println("原始名称为："+ tmp);
            System.out.println("修改后为：" + tmp.substring(0,3));
                stack.peek().setValue(tmp.substring(0,3) + name.getText());

                if(tmp.substring(0,3).contains("分类"))
                    goodsBLService.modifyGoodsCategory(name.getText());
                else{
                    System.out.println("原来商品名：" + tmp.substring(3) + "新商品名：" + name.getText());
                    ArrayList<GoodsVO> arrayList = (ArrayList<GoodsVO>) goodsBLService.findGoods(tmp.substring(3),"goodsName");
                    GoodsVO goodsVO = arrayList.get(0);
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
}
