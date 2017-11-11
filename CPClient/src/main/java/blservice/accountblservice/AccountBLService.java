package blservice.accountblservice;

import java.util.List;

import VO.AccountVO;
import VO.CashExpenseListVO;
import VO.CollectionListVO;
import VO.FinanceListVO;
import VO.GoodsVO;
import VO.InitAccountVO;
import VO.PaymentListVO;
import VO.VIPVO;
import bl.utilitybl.ResultMessage;
/**
 * 
 * @author  julia98
 * @author  zxy			
 */
public interface AccountBLService {
	
	/*
	 * 期初建账相关
	 */
	
	//得到所有商品
	public List<GoodsVO> getGoodsInfo();
	
	//得到所有会员信息
	 public List<VIPVO> getVIPInfo();
	
	//保存期初建账信息
	 public ResultMessage saveInitAccountInfo(InitAccountVO vo);
	
	 /*
	  * 账户管理相关
	  */
	 
	//添加账户
	 public ResultMessage initAndSaveAccount(AccountVO vo);
	 
	//删除账户
	public ResultMessage deleteAccount(String name);
	
	//修改账户
	public ResultMessage modifyAccount(AccountVO vo);
	
	//得到所有账户信息
	public List<AccountVO> findAccount();
	
	/*
	 * 单据相关
	 */
	
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
	
	//查找账户的方法上面已声明过
	
	//提交单据
	public ResultMessage commitPaymentList(PaymentListVO vo);
	public ResultMessage commitCollectionList(CollectionListVO vo);
	public ResultMessage commitCashExpenseList(CashExpenseListVO vo);
	
	
}