package bl.accountbl;

import PO.account.FinanceListPO;
import VO.accountVO.FinanceListVO;
import dataService.accountDataService.FinanceListDataService;
import resultmessage.ApproveRM;
import util.GreatListType;

public class PaymentListImpl extends FinanceListImpl{

	public PaymentListImpl(FinanceListDataService dataService) {
		super(dataService);
	}

	@Override
	protected FinanceListPO voTopo(FinanceListVO vo) {
		
		return null;
	}

	@Override
	protected FinanceListVO poTovo(FinanceListPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApproveRM approve(FinanceListVO vo) {
		// TODO Auto-generated method stub
//		PaymentListVO pvo = (PaymentListVO)vo;
//		for(TransferItemVO item : cvo.getTransferItem()){
//			//TODO 检查账户余额是否够
//		}
		return null;
	}

	@Override
	protected GreatListType getGreatListType() {
		return GreatListType.PAYMENT;
	}

	@Override
	protected String getKeyInfo(FinanceListVO vo) {
		//TODO change it
//		PaymentListVO cvo = (PaymentListVO)vo;
//		return "向 "+cvo.getVIPName() + " 付款 " + cvo.getTotalAmount() + " 元";
		return "付款了";
	}

}
