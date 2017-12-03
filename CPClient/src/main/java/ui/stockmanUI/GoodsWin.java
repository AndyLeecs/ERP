package ui.stockmanUI;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GoodsWin extends Stage{
	@FXML AnchorPane root;
	@FXML AnchorPane root2;
	
	public GoodsWin() throws IOException{
		root = FXMLLoader.load(getClass().getResource("Stockman.fxml"));
		root2 = FXMLLoader.load(getClass().getResource("Goods.fxml"));
		root.getChildren().addAll(root2);
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("Stock.css").toExternalForm());
		scene.setFill(Color.TRANSPARENT);
		
		this.setScene(scene);
		this.initStyle(StageStyle.DECORATED);
		this.show();
	}
}