package main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import network.ServerConnector;


public class Main extends Application {

	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception
	{

		Platform.runLater(()-> {
				try {
					new ui.stockmanUI.StockmanWin();



				} catch (Exception e) {
					e.printStackTrace();
				}
		});
	}
}
