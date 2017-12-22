package main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import ui.mainUI.loginUI.LoginWin;

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
//					new Welcome();
//					new LoginWin();

//					new ui.salesmanUI.SaleWin();
//					new ui.stockmanUI.StockmanWin();
					new ui.mainUI.accountantUI.AccountantWin();
//					new ui.managerUI.ManagerWin();
//					new ui.stockmanUI.GoodsWin();

				} catch (Exception e) {
					e.printStackTrace();
				}
		});
	}
}
