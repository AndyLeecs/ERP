package ui.stockmanUI;

import VO.goodsVO.GoodsVO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Stack;

public class GoodsController{

    @FXML public Label presentLocation;
	@FXML public ImageView allSelectBtn;
	@FXML public ImageView newGoodsORCategoryBtn;
	@FXML public ImageView moveBtn;
	@FXML public ImageView changeNameBtn;
	@FXML public ImageView deleteBtn;
	
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

    private String presentLocationStr = "根目录";
    
    private void initTreeView(){
        //在ScrollPane上配置并加入TreeView
        rootTreeItem = new TreeItem("分类：根目录");
        rootTreeItem.setExpanded(true);

        for(int i =0;i<5;i++) {
            TreeItem item = new TreeItem("分类：" + i);
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
                System.out.println("此节点下不可添加商品");
            }

        });

        MenuItem newCategoryBar = new MenuItem("新建分类");
      
        newCategoryBar.setOnAction(e->{


                //通过命名来区分商品项和分类项 除此之外有别的方法则可用别的方法替换 （比如分类有文件夹图片区分）
                //命名格式： 商品：小台灯 分类：彩灯
                //判断当前节点是否可添加分类
                TreeItem selectItem = (TreeItem) treeView.getSelectionModel().getSelectedItem();

            System.out.println("选中项文字 " + selectItem.getValue().toString());
            System.out.println("选中项子节点文字" + selectItem.getChildren().toString());

                if ((selectItem.toString().contains("分类") && selectItem.isLeaf()) || (selectItem.toString().contains("分类") && selectItem.getChildren().toString().contains("分类"))) {

                    TreeItem<String> categoryTreeItem = new TreeItem<>("分类："+rootTreeItem.getChildren().size());

                    selectItem.getChildren().add(categoryTreeItem);
                    stack.push(categoryTreeItem);
                    noticeLabel.setText("新建分类");
                    notice.setVisible(true);
                } else {
                    System.out.println("此节点下不可添加分类");
                }
        });

        MenuItem deleteBar = new MenuItem("删除");
        deleteBar.setOnAction(e ->{
            TreeItem selectItem = (TreeItem) treeView.getSelectionModel().getSelectedItem();
            selectItem.getParent().getChildren().remove(selectItem);
            //rootTreeItem.getChildren().remove(selectItem);
        });

        MenuItem refactorBar = new MenuItem("改名");
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
        //presentLocation.setText(setPresentLocation());
        notice.setVisible(false);
        initTreeView();
    }

    /**
     * 回到根目录
     */
    @FXML
    private void setAllSelectBtn(){

	}

    /**
     * 1. 若当前为根目录 弹出提示框 新建分类还是新建商品
     * 2. 若当前不为根目录 则判断当前目录为分类目录还是商品目录 若为商品目录则不能新建分类目录
     * 3. 新建分类需填入分类名
     * 4. 新建商品需填入商品名（单击确定之后 调用getGoodsID方法产生商品编号）
     * 5. 当新建分类后 当前页面添加分类Btn 并设定fx：id 和事件响应方法（打开分类内为空）
     * 6. 当新建商品后 当前页面添加商品Btn 并设定fx：id 和事件响应方法（商品信息为初始化信息）
     */
	@FXML
    protected void setNewGoodsORCategoryBtn(){

	}

    /**
     * 移动商品位置
     */
	@FXML
    private void setMoveBtn(){

	}

    /**
     * 改变商品名或分类名
     */
	@FXML
    private void setChangeNameBtn(){

	}

    /**
     * 删除商品或分类
     */
	@FXML
    private void setDeleteBtn(){

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

	}

    /**
     * 设定当前位置
     */
    private String setPresentLocation(){
		return presentLocationStr;

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
