package ui.loadingUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * Created by julia98 on 2017/12/29.
 */
public class LoadingFXController {
	@FXML AnchorPane root;
    @FXML Label loadingTxt;

    public void setLoadingTxt(String loadingTxt) {
        this.loadingTxt.setText(loadingTxt);
    }
    
    public void close() {
    	    root.getScene().getWindow().hide();
    }
}
