package bl.accountbl;

import java.util.List;

import VO.accountVO.AccountVO;
import VO.accountVO.CashExpenseListVO;
import VO.accountVO.CollectionListVO;
import VO.accountVO.FinanceListVO;
import VO.accountVO.PaymentListVO;
import bl.utility.DomainList;
import blservice.accountblservice.FinanceListService;
import util.CommitListRM;
import util.DeleteListRM;
import util.SaveListRM;

public class FinanceListServiceController implements FinanceListService{

	FinanceList financeList = new FinanceList();
	PaymentList paymentList = new PaymentList();
	
	DomainList domainList = new PaymentList();
	
	@Override
	public String newPaymentList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String newCollectionList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String newCashExpenseList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FinanceListVO> openDraft() {
		return financeList.openDraft();
	}

	@Override
	public List<CollectionListVO> openCollectionDraft() {
		return financeList.openCollectionDraft();
	}

	@Override
	public List<PaymentListVO> openPaymentDraft() {
		return financeList.openPaymentDraft();
	}

	@Override
	public List<CashExpenseListVO> openCashExpenseDraft() {
		return financeList.openCashExpenseDraft();
	}

	@Override
	public List<FinanceListVO> openComitted() {
		return financeList.openComitted();
	}

	@Override
	public List<PaymentListVO> openPaymentComitted() {
		return financeList.openPaymentComitted();
	}

	@Override
	public List<CollectionListVO> openCollectionComitted() {
		return financeList.openCollectionComitted();
	}

	@Override
	public List<CashExpenseListVO> openCashExpenseComitted() {
		return financeList.openCashExpenseComitted();
	}

	@Override
	public SaveListRM savePaymentList(PaymentListVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SaveListRM saveCollectionList(CollectionListVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SaveListRM saveCashExpenseList(CashExpenseListVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteListRM deletePaymentList(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteListRM deleteCollectionList(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteListRM deleteCashExpenseList(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountVO> findAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommitListRM commitPaymentList(PaymentListVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommitListRM commitCollectionList(CollectionListVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommitListRM commitCashExpenseList(CashExpenseListVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
