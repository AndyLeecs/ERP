package ui.stockmanUI;

import VO.goodsVO.GoodsVO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class GoodsController {

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

    private String presentLocationStr = "根目录";
    
    private void initTreeView(){
        //在ScrollPane上配置并加入TreeView
        rootTreeItem = new TreeItem("根目录");
        rootTreeItem.setExpanded(true);

        for(int i =0;i<5;i++) {
            TreeItem item = new TreeItem("目录" + i);
            rootTreeItem.getChildren().add(item);
        }

        TreeView treeView = new TreeView<>(rootTreeItem);
        vBox.getChildren().add(treeView);

        //设置右键菜单
        ContextMenu menu = new ContextMenu();
        menu.setStyle("-fx-background-color: #FF7575");

        MenuItem newGoodsBar = new MenuItem("新建商品");
        
        newGoodsBar.setOnAction(e->{
            Platform.runLater(()->{
                try {
                    new ui.stockmanUI.NewGoodsORCategoryWin();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });

            //通过命名来区分商品项和分类项 除此之外有别的方法则可用别的方法替换 （比如分类有文件夹图片区分）
            //命名格式： 商品：小台灯 分类：彩灯
            //判断当前节点是否可添加商品
            TreeItem selectItem = (TreeItem) treeView.getSelectionModel().getSelectedItem();

            if((selectItem.toString().contains("分类") && selectItem.isLeaf()) || (selectItem.toString().contains("分类") && selectItem.getChildren().toString().contains("商品"))) {

                NewGoodsORCategoryController controller = new NewGoodsORCategoryController();
                TreeItem<String> goodsTreeItem = new TreeItem<>(controller.getNewName());

                selectItem.getChildren().add(goodsTreeItem);
            }else{
                System.out.print("此节点下不可添加商品");
            }

            /*
            switch (controller.getList().get(0)){
                case "goods":
                    TreeItem treeItem = new TreeItem(controller.getList().get(1));
                    TreeView treeView1 = new TreeView(treeItem);
                    vBox.getChildren().add(treeView1);

                    break;
                case "category":
                    rootTreeItem.getChildren().add( new TreeItem<>(controller.getList().get(1)));
                    break;
            }*/

        });

        MenuItem newCategoryBar = new MenuItem("新建分类");
        newCategoryBar.setOnAction(e->{
            Platform.runLater(()->{
                try {
                    new ui.stockmanUI.NewGoodsORCategoryWin();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });

            //通过命名来区分商品项和分类项 除此之外有别的方法则可用别的方法替换 （比如分类有文件夹图片区分）
            //命名格式： 商品：小台灯 分类：彩灯
            //判断当前节点是否可添加分类
            TreeItem selectItem = (TreeItem) treeView.getSelectionModel().getSelectedItem();

            if((selectItem.toString().contains("分类") && selectItem.isLeaf()) || (selectItem.toString().contains("分类") && selectItem.getChildren().toString().contains("分类"))) {

                NewGoodsORCategoryController controller = new NewGoodsORCategoryController();
                TreeItem<String> categoryTreeItem = new TreeItem<>(controller.getNewName());

                selectItem.getChildren().add(categoryTreeItem);
            }else{
                System.out.print("此节点下不可添加分类");
            }
        });

        MenuItem deleteBar = new MenuItem("删除");
        deleteBar.setOnAction(e ->{
            TreeItem selectItem = (TreeItem) treeView.getSelectionModel().getSelectedItem();
            rootTreeItem.getChildren().remove(selectItem);
        });

        MenuItem refactorBar = new MenuItem("改名");
        refactorBar.setOnAction(e->{

            Platform.runLater(()->{
                try {
                    new ui.stockmanUI.NewGoodsORCategoryWin();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });

            NewGoodsORCategoryController controller = new NewGoodsORCategoryController();
            TreeItem selectItem = (TreeItem) treeView.getSelectionModel().getSelectedItem();
            selectItem.setValue(controller.getNewName());
        });

        menu.getItems().add(newGoodsBar);
        menu.getItems().add(deleteBar);
        menu.getItems().add(newCategoryBar);
        menu.getItems().add(refactorBar);
        treeView.setContextMenu(menu);
    }

    /**
     * 初始化页面时 更新当前位置
     */
    @FXML
    public void initialize(){
        presentLocation.setText(setPresentLocation());
        initTreeView();
    }

    private void init(){
        presentLocation.setText(setPresentLocation());
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
        Platform.runLater(()->{
            try {
                new ui.stockmanUI.NewGoodsORCategoryWin();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        NewGoodsORCategoryController controller = new NewGoodsORCategoryController();
        TreeItem item = new TreeItem(controller.getList().get(1));
        switch (controller.getList().get(0)){
            case "goods":

                break;
            case "category":
                rootTreeItem.getChildren().add(item);
                break;
        }

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

	//分离多个嵌套分类的方法
    /*
	public String getPresentLocation(String str){
	    String tmp[] = presentLocation.getText().split("/");

    }*/

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
	        double ret = 0;

	        ret = Double.parseDouble(tmp[0]) + Double.parseDouble(tmp[1])/(Math.pow(10,tmp[1].length()));
	        return ret;
        }
    }
}
