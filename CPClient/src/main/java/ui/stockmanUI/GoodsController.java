package ui.stockmanUI;

import VO.goodsVO.GoodsVO;
import blservice.goodsblservice.GoodsBLService;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.util.Stack;

public class GoodsController{

    @FXML public Label presentLocation;

    @FXML public Button goodsNameSearchBtn;
    @FXML public Button goodsTypeSearchBtn;
    @FXML public Button goodsIDSearchBtn;

	@FXML public ImageView editBtn;
	@FXML public Button saveGoodsInfoBtn;
	
	@FXML public TextField searchField;
	@FXML public Button searchBtn;

	@FXML public TextField goodsID;
    @FXML public TextField goodsName;
    @FXML public TextField goodsType;
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

    Stack<TreeItem> stack = new Stack<>();//存放目录的引用 便于增减改名商品
    
    private void initTreeView(){
        //在ScrollPane上配置并加入TreeView
        rootTreeItem = new TreeItem("分类：根目录");
        rootTreeItem.setExpanded(true);

        for(int i =0;i<5;i++) {
            TreeItem item = new TreeItem("分类：" + i);
            item.setGraphic(new ImageView("img/folderIcon.png"));
            rootTreeItem.getChildren().add(item);

            TreeItem item1 = new TreeItem("商品：" + i);
            item.getChildren().add(item1);
        }

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
	    goodsName.setEditable(true);
	    goodsType.setEditable(true);
	    goodsBuyPrice.setEditable(true);
	    goodsSellPrice.setEditable(true);
	    goodsStoreNum.setEditable(true);
	    recentBuyPrice.setEditable(true);
	    recentSellPrice.setEditable(true);

	    goodsName.setStyle("-fx-background-color: #FFECEC");
        goodsType.setStyle("-fx-background-color: #FFECEC");
        goodsBuyPrice.setStyle("-fx-background-color: #FFECEC");
        goodsSellPrice.setStyle("-fx-background-color: #FFECEC");
        goodsStoreNum.setStyle("-fx-background-color: #FFECEC");
        recentBuyPrice.setStyle("-fx-background-color: #FFECEC");
        recentSellPrice.setStyle("-fx-background-color: #FFECEC");
	}

    /**
     * 保存商品信息
     */
	@FXML
    private void setSaveGoodsInfoBtn(){
        goodsName.setEditable(false);
        goodsType.setEditable(false);
        goodsBuyPrice.setEditable(false);
        goodsSellPrice.setEditable(false);
        goodsStoreNum.setEditable(false);
        recentBuyPrice.setEditable(false);
        recentSellPrice.setEditable(false);

        goodsName.setStyle("-fx-background-color: transparent");
        goodsType.setStyle("-fx-background-color: transparent");
        goodsBuyPrice.setStyle("-fx-background-color: transparent");
        goodsSellPrice.setStyle("-fx-background-color: transparent");
        goodsStoreNum.setStyle("-fx-background-color: transparent");
        recentBuyPrice.setStyle("-fx-background-color: transparent");
        recentSellPrice.setStyle("-fx-background-color: transparent");

        GoodsVO goodsVO = new GoodsVO(goodsID.getText()
                ,presentLocation.getText()
                ,goodsName.getText()
                ,goodsType.getText()
                ,changeStringToDouble(goodsBuyPrice.getText())
                ,changeStringToDouble(goodsBuyPrice.getText())
                ,changeStringToDouble(recentBuyPrice.getText())
                ,changeStringToDouble(recentSellPrice.getText()));
    }

    /**
     * 模糊查找商品输入框
     */
	@FXML
    private void setSearchField(){

	}

    /**
     * 模糊查找商品确认按钮
     */
	@FXML
    private void setSearchBtn(){
	    if(searchField.getText()!=null){
	        GoodsBLService goodsBLService = null;
            goodsBLService.findGoods(searchField.getText(),"");
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
            break;
            case "新建分类": tmp = "分类：";
                stack.peek().setValue(tmp + "" + name.getText());
            break;
            case "修改名称": tmp = stack.peek().getValue().toString();
            System.out.println("原始名称为："+ tmp);
            System.out.println(tmp.substring(0,3));
                stack.peek().setValue(tmp.substring(0,3) + name.getText());
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
    }

    @FXML
    public void onGoodsTypeSearchBtnClicked(){
        searchField.setPromptText("模糊查找" + goodsTypeSearchBtn.getText());
    }

    @FXML
    public void onGoodsIDSearchBtnClicked(){
        searchField.setPromptText("模糊查找" + goodsIDSearchBtn.getText());
    }
    /**
     * 将输入的String类型的金额转化为double型
     * @param str
     * @return
     */
	private double changeStringToDouble(String str){
	    if(!str.contains(".")){
	        return Double.parseDouble(str);
        }else{
	        String[] tmp = str.split(".");
	        double ret = Double.parseDouble(tmp[0]) + Double.parseDouble(tmp[1])/(Math.pow(10,tmp[1].length()));
	        return ret;
        }
    }
}
