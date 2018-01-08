package ui.accountUI;

public class CollectionListBriefController extends CollectionAndPaymentListBriefController{


	@Override
	public void init(){
		cpLookController = new CollectionListWinLookController();
		super.init();
	}
	
	

}
