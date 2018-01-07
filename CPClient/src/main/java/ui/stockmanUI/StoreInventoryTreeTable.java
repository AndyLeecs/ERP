package ui.stockmanUI;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.cells.editors.TextFieldEditorBuilder;
import com.jfoenix.controls.cells.editors.base.GenericEditableTreeTableCell;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import VO.storeVO.StoreVO;
import VO.storeVO.storeInventoryVO;
import bl.storebl.StoreblController;
import blservice.storeblservice.StoreBLService;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class StoreInventoryTreeTable {
	ObservableList<T> Obs= FXCollections.observableArrayList();
	ArrayList<String> S0=new ArrayList<String>();
	
   // private Class<T> type;
	

/*
 * TreeTable 的父类，具有添加栏目和添加数据的功能
 */
	/*public FatherTreeTable(Class<T> type){
		this.type=type;
	}*/
	
	public  FlowPane addColumn(){
		ArrayList<JFXTreeTableColumn<T,String>> A0=new ArrayList<JFXTreeTableColumn<T,String>>();
		for(int i=0;i<S0.size();i++){
			A0.add(new JFXTreeTableColumn<>(S0.get(i)));
			}
		for(int i=0;i<A0.size();i++){
			A0.get(i).setPrefWidth(150);
			//下一句话设置数据合法性，不知道要不要加。

			A0.get(i).setCellFactory((TreeTableColumn<T, String> param)-> new GenericEditableTreeTableCell<>(
		            new TextFieldEditorBuilder()));;
		}
		
		A0.get(0).setCellValueFactory((TreeTableColumn.CellDataFeatures<T, String> param) -> { return param.getValue().getValue().p1;});
		A0.get(1).setCellValueFactory((TreeTableColumn.CellDataFeatures<T, String> param) -> { return param.getValue().getValue().p2;});
		A0.get(2).setCellValueFactory((TreeTableColumn.CellDataFeatures<T, String> param) -> { return param.getValue().getValue().p3;});
		A0.get(3).setCellValueFactory((TreeTableColumn.CellDataFeatures<T, String> param) -> { return param.getValue().getValue().p4;});
		A0.get(4).setCellValueFactory((TreeTableColumn.CellDataFeatures<T, String> param) -> { return param.getValue().getValue().p5;});
		A0.get(5).setCellValueFactory((TreeTableColumn.CellDataFeatures<T, String> param) -> { return param.getValue().getValue().p6;});
		A0.get(6).setCellValueFactory((TreeTableColumn.CellDataFeatures<T, String> param) -> { return param.getValue().getValue().p7;});
		
        final TreeItem<T> root=new RecursiveTreeItem<>(Obs, RecursiveTreeObject::getChildren); ;

        JFXTreeTableView<T> treeView = new JFXTreeTableView<T>(root);
        treeView.setShowRoot(false);
        treeView.setEditable(true);
       
        treeView.getColumns().setAll(A0);
    		FlowPane main = new FlowPane();
            main.setPadding(new Insets(10));
            main.getChildren().add(treeView);
    		JFXButton okbtn = new JFXButton("导出报表");
    		okbtn.setOnAction((action)->btnAction1());
    		main.getChildren().add(okbtn);
            return main;
        
	}
		
	private void btnAction1(){
		System.out.println("Print Sth.");
	}

	 private final class T extends RecursiveTreeObject<T>{
		  StringProperty p1;
		  StringProperty p2;
		  StringProperty p3;
		  StringProperty p4;
		  StringProperty p5;
		  StringProperty p6;
		  StringProperty p7;
		  
		  public T (String p1,String p2,String p3,String p4,String p5,String p6,String p7 ){
			  this.p1=new SimpleStringProperty (p1);
			  this.p2=new SimpleStringProperty (p2);
			  this.p3=new SimpleStringProperty (p3);
			  this.p4=new SimpleStringProperty (p4);
			  this.p5=new SimpleStringProperty (p5);
			  this.p6=new SimpleStringProperty (p6);
			  this.p7=new SimpleStringProperty (p7);
			  
		  }
		  
	}

	public void start(Stage primaryStage) {
		S0.add("行号");
	    S0.add("商品编号");
	    S0.add("商品名称");
	    S0.add("库存数量");
	    S0.add("库存均价");
	    S0.add("型号");
	    S0.add("出厂日期");

	    Obs.add(new T("1","G1","佩奇灯","30","20.25","Model1","2017-05-26"));
	  /*  StoreBLService service=new StoreblController();
	    storeInventoryVO inventoryVO=service.store_inventory();
	    for(int i=0;i<inventoryVO.storeVO_Arr.size();i++){
	    	StoreVO vo=inventoryVO.storeVO_Arr.get(i);
	       T t=new T(Integer.toString(i),vo.ID,vo.name,Integer.toString(vo.Num),Double.toString(vo.averagePrice),inventoryVO.Model.get(i),
	    		   inventoryVO.Date.get(i) );
	       Obs.add(t);
	    }*/
	    //------
	    
	    
		FlowPane main=addColumn();
		
		Scene scene = new Scene(main, 1100, 500);
		
        primaryStage.setScene(scene);
        primaryStage.setTitle("库存盘点");
        primaryStage.show();
		
	}
	

}
 


	
