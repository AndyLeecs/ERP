package ui.stockmanUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * Created by julia98 on 2017/12/11.
 */
public class GoodsInfoEditWin extends Stage {
    @FXML
    AnchorPane root;

    public GoodsInfoEditWin() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/stockmanUI/GoodsInfoEdit.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css/stockmanUI/Stock.css").toExternalForm());
        scene.setFill(Color.TRANSPARENT);

        this.setScene(scene);
        this.initStyle(StageStyle.DECORATED);
        this.show();
    }
}
