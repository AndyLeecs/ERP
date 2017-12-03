package ui.stockmanUI;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StockmanWin extends Stage{
	@FXML AnchorPane root;
	
	public StockmanWin() throws IOException{
		root = FXMLLoader.load(getClass().getResource("Stockman.fxml"));
	
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("Stock.css").toExternalForm());
		scene.setFill(Color.TRANSPARENT);
		
		this.setScene(scene);
		this.initStyle(StageStyle.DECORATED);
		this.show();
	}
}