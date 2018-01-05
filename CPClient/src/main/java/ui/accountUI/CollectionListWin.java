package ui.accountUI;

import java.io.IOException;

import VO.accountVO.CollectionListVO;
import blservice.serviceFactory.AccountBLFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CollectionListWin extends Stage{
	@FXML
	AnchorPane root;
	public CollectionListWin(CollectionListWinController controller) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/accountUI/CollectionList.fxml"));
		loader.setController(controller);
		controller.setService(AccountBLFactory.getCollectionListService());
		root = loader.load();
		controller.init();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/css/forms/Forms.css").toExternalForm());
		scene.setFill(Color.TRANSPARENT);
		this.setScene(scene);
		this.initStyle(StageStyle.DECORATED);
		this.show();
	}
	
	public CollectionListWin(String listId) throws IOException{
		this(new CollectionListWinApproveController(
				(CollectionListVO) AccountBLFactory.getCollectionListService().getList(listId)));
	}
}
