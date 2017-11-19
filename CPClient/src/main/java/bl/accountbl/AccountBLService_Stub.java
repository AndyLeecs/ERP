package bl.accountbl;

import java.util.ArrayList;
import java.util.List;

import VO.VIPVO.VIPVO;
import VO.accountVO.AccountVO;
import VO.accountVO.CashExpenseListVO;
import VO.accountVO.CollectionListVO;
import VO.accountVO.FinanceListVO;
import VO.accountVO.InitAccountVO;
import VO.accountVO.PaymentListVO;
import VO.goodsVO.GoodsVO;
import bl.utilitybl.ResultMessage;
import blservice.accountblservice.AccountBLService;

public class AccountBLService_Stub implements AccountBLService{
	
	protected static final GoodsVO goodsvo = null;
	protected static final VIPVO vipvo = null;
	protected static final AccountVO accountvo = null;
	protected static final CollectionListVO collectionListvo = null;
	protected static final PaymentListVO paymentListvo = null;
	protected static final CashExpenseListVO cashExpenseListvo = null;
	protected static final String collectionListID = "FKD-20171111-00011";
	protected static final String paymentListID = "FKD-20171111-00011";
	protected static final String cashExpenseListID = "FKD-20171111-00011";
	
	@Override
	public List<GoodsVO> getGoodsInfo() {
		List<GoodsVO> list = new ArrayList<GoodsVO>();
		list.add(goodsvo);
		return list;
	}

	@Override
	public List<VIPVO> getVIPInfo() {
		List<VIPVO> list = new ArrayList<VIPVO>();
		list.add(vipvo);
		return list;
	}

	@Override
	public ResultMessage saveInitAccountInfo(InitAccountVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage initAndSaveAccount(AccountVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deleteAccount(String name) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modifyAccount(AccountVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public List<AccountVO> findAccount() {
		List<AccountVO> list = new ArrayList<AccountVO>();
		list.add(accountvo);
		return list;
	}

	@Override
	public String newPaymentList() {
		return paymentListID;
	}

	@Override
	public String newCollectionList() {
		return collectionListID;
	}

	@Override
	public String newCashExpenseList() {
		return cashExpenseListID;
	}

	@Override
	public List<FinanceListVO> openDraft() {
		List<FinanceListVO> list = new ArrayList<FinanceListVO>();
		list.add(paymentListvo);
		list.add(collectionListvo);
		list.add(cashExpenseListvo);
		return list;
	}

	@Override
	public List<CollectionListVO> openCollectionDraft() {
		List<CollectionListVO> list = new ArrayList<CollectionListVO>();
		list.add(collectionListvo);
		return list;
	}

	@Override
	public List<PaymentListVO> openPaymentDraft() {
		List<PaymentListVO> list = new ArrayList<PaymentListVO>();
		list.add(paymentListvo);
		return list;
	}

	@Override
	public List<CashExpenseListVO> openCashExpenseDraft() {
		List<CashExpenseListVO> list = new ArrayList<CashExpenseListVO>();
		list.add(cashExpenseListvo);
		return list;
	}

	@Override
	public List<FinanceListVO> openComitted() {
		return null;
	}

	@Override
	public List<PaymentListVO> openPaymentComitted() {
		return null;
	}

	@Override
	public List<CollectionListVO> openCollectionComitted() {
		return null;
	}

	@Override
	public List<CashExpenseListVO> openCashExpenseComitted() {
		return null;
	}

	@Override
	public ResultMessage savePaymentList(PaymentListVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage saveCollectionList(CollectionListVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage saveCashExpenseList(CashExpenseListVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deletePaymentList(String id) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deleteCollectionList(String id) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deleteCashExpenseList(String id) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public List<VIPVO> findVIP(String info) {
		List<VIPVO> list = new ArrayList<VIPVO>();
		list.add(vipvo);
		return list;
	}

	@Override
	public ResultMessage commitPaymentList(PaymentListVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage commitCollectionList(CollectionListVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage commitCashExpenseList(CashExpenseListVO vo) {
		return ResultMessage.SUCCESS;
	}
	
	
	
}