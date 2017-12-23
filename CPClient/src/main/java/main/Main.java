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
<<<<<<< HEAD:CPClient/src/main/java/mainUI/Main.java
					//new LoginWin();
					//new ui.saleUI.SaleWin();
					//new ui.stockmanUI.StockmanWin();
					//new ui.managerUI.ManagerWin();
					//new ui.stockmanUI.GoodsWin();
					new ui.salesmanUI.VIPWin();
=======
//					new LoginWin();

//					new ui.salesmanUI.SaleWin();
//					new ui.stockmanUI.StockmanWin();
					new ui.mainUI.accountantUI.AccountantWin();
//					new ui.managerUI.ManagerWin();
//					new ui.stockmanUI.GoodsWin();
>>>>>>> 5cbce2e1e7b8c65f6d45b0d9724961e850fccd5a:CPClient/src/main/java/main/Main.java

				} catch (Exception e) {
					e.printStackTrace();
				}
		});
	}
}
