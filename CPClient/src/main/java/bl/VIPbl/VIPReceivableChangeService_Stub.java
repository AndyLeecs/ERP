package bl.VIPbl;

import blservice.VIPblservice.VIPReceivableChangeService;

public class VIPReceivableChangeService_Stub implements VIPReceivableChangeService{

	@Override
	public boolean collect(String VIPID, double amount) {
		
		return true;
	}

	@Override
	public boolean pay(String VIPID, double amount) {
		
		return true;
	}

}
