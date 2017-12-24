package blservice.accountblservice;

import java.util.List;

import VO.accountVO.AccountVO;
import VO.accountVO.CashExpenseListVO;
import VO.accountVO.CollectionListVO;
import VO.accountVO.FinanceListVO;
import VO.accountVO.PaymentListVO;
import util.CommitListRM;
import util.DeleteListRM;
import util.SaveListRM;

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
		public SaveListRM savePaymentList(PaymentListVO vo);
		public SaveListRM saveCollectionList(CollectionListVO vo);
		public SaveListRM saveCashExpenseList(CashExpenseListVO vo);
		
		
		//删除单据
		public DeleteListRM deletePaymentList(String id);
		public DeleteListRM deleteCollectionList(String id);
		public DeleteListRM deleteCashExpenseList(String id);
		
//		//查找会员
//		public List<VIPVO> findVIP(String info);
//		public List<VIPVO> findVIPByID(String ID);
//		public List<VIPVO> findVIPByCategory(VIPCategory Category);
//		public List<VIPVO> findVIPByName(String name);
		
		//得到所有账户信息
		public List<AccountVO> findAccount();
		
		//提交单据
		public CommitListRM commitPaymentList(PaymentListVO vo);
		public CommitListRM commitCollectionList(CollectionListVO vo);
		public CommitListRM commitCashExpenseList(CashExpenseListVO vo);
}
