package blservice.accountblservice;

import java.util.List;

import VO.VIPVO.VIPVO;
import VO.accountVO.AccountVO;
import VO.accountVO.CashExpenseListVO;
import VO.accountVO.CollectionListVO;
import VO.accountVO.FinanceListVO;
import VO.accountVO.PaymentListVO;
import bl.utilitybl.ResultMessage;

public interface FinanceListService {

	
	//新建单据
		public String newPaymentList();
		public String newCollectionList();
		public String newCashExpenseList();
		
		//打开草稿单
		public List<FinanceListVO> openDraft();
		public List<CollectionListVO> openCollectionDraft();
		public List<PaymentListVO> openPaymentDraft();
		public List<CashExpenseListVO> openCashExpenseDraft();
		
		//打开已提交单
		public List<FinanceListVO> openComitted();
		public List<PaymentListVO> openPaymentComitted();
		public List<CollectionListVO> openCollectionComitted();
		public List<CashExpenseListVO> openCashExpenseComitted();
		
		
		//保存单据
		public ResultMessage savePaymentList(PaymentListVO vo);
		public ResultMessage saveCollectionList(CollectionListVO vo);
		public ResultMessage saveCashExpenseList(CashExpenseListVO vo);
		
		
		//删除单据
		public ResultMessage deletePaymentList(String id);
		public ResultMessage deleteCollectionList(String id);
		public ResultMessage deleteCashExpenseList(String id);
		
		//查找会员
		public List<VIPVO> findVIP(String info);
		
		//得到所有账户信息
		public List<AccountVO> findAccount();
		
		//提交单据
		public ResultMessage commitPaymentList(PaymentListVO vo);
		public ResultMessage commitCollectionList(CollectionListVO vo);
		public ResultMessage commitCashExpenseList(CashExpenseListVO vo);
}
