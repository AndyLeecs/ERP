package bl.userbl.mock;

import java.util.ArrayList;

import VO.accountVO.AccountVO;
import VO.userVO.UserType;
import VO.userVO.UserVO;
import bl.utilitybl.ResultMessage;
/**
 * 
 * @author julia98
 *
 */
public class MockAccountant {
	private UserVO userVO;
	private AccountVO accountVO = new AccountVO();
	
	public MockAccountant() {
		this.userVO = new UserVO("00000001", "Julia", "123456", 5,UserType.Accountant);
	}
	/**
	 * 用户登录
	 * @return
	 */
	public ResultMessage login(String name,String password) {
		if(name.equals("Julia") && password.equals("123456"))
		    return ResultMessage.SUCCESS;
		else
			return ResultMessage.FAILED;
	}
	
	/**
	 * 期初建账
	 */
	public ResultMessage saveInitAccountInfo(AccountVO vo) {
		return ResultMessage.SUCCESS;		
	}
	
	/**
	 * 查看日志
	 */
	public ResultMessage viewLog() {
		return ResultMessage.SUCCESS;		
	}
	
	/**
	 * 新建收款单
	 */
	public String newCollectMoneyList() {
		return null;	
	}
	
	/**
	 * 新建付款单
	 */
	public String newPaymentList() {
		return null;
	}
	
	/**
	 * 新建现金费用单
	 */
	public String newCashExpenseList() {
		return null;
	}
	
	/**
	 * 查看销售明细表
	 */
	public ResultMessage checkSaleDetailList() {
		return ResultMessage.SUCCESS;
	}
	
	/**
	 * 查看经营历程表
	 */
	public ResultMessage checkBussinessProcessList() {
		return ResultMessage.SUCCESS;
	}
	
	/**
	 * 查看经营情况表
	 */
	public ResultMessage checkBussinessCircumList() {
		return ResultMessage.SUCCESS;
	}
	
	/**
	 * 银行账户增
	 */
	public ResultMessage addAccount(AccountVO vo) {
		return ResultMessage.SUCCESS;
	}
	
	/**
	 * 银行账户删
	 */
	public ResultMessage deleteAccount(String name) {
		return ResultMessage.SUCCESS;
	}
	
	/**
	 * 银行账户改
	 */
	public ResultMessage modifyAccount(String name,AccountVO vo) {
		return ResultMessage.SUCCESS;
	}
	
	/**
	 * 银行账户查
	 */
	public ArrayList<AccountVO> searchAccount(String keyword){
		return new ArrayList<AccountVO>();
	}
}
