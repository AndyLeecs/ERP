package ui.accountUI;

public class PaymentListBriefController extends CollectionAndPaymentListBriefController{


	@Override
	public void init(){
		cpLookController = new PaymentListWinLookController();
		super.init();
	}
	
	

}
