package blservice.accountblservice;

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
/**
 * 这个接口应该是没用了
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