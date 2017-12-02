package bl.accountbl;

import java.util.List;

import VO.accountVO.AccountVO;
import VO.accountVO.CashExpenseListVO;
import VO.accountVO.CollectionListVO;
import VO.accountVO.FinanceListVO;
import VO.accountVO.PaymentListVO;
import blservice.accountblservice.FinanceListService;
import util.CommitListRM;
import util.DeleteListRM;
import util.SaveListRM;

public class FinanceListServiceController implements FinanceListService{

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CollectionListVO> openCollectionDraft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaymentListVO> openPaymentDraft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CashExpenseListVO> openCashExpenseDraft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FinanceListVO> openComitted() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaymentListVO> openPaymentComitted() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CollectionListVO> openCollectionComitted() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CashExpenseListVO> openCashExpenseComitted() {
		// TODO Auto-generated method stub
		return null;
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
