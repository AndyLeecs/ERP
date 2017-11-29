package mainUI;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Main extends Application
{

	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception
	{

		Platform.runLater(new Runnable()
		{
			public void run()
			{
				try
				{
					new LoginWin();
					new ui.saleUI.SaleWin();

				} catch (Exception e)
				{
					e.printStackTrace();
				}

			}
		});

	}

}
