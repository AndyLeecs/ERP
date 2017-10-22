package accountbl;

import java.util.ArrayList;
import java.util.Map;

import VO.*;

public interface AccountBL {
	/**
	 * 后置条件   返回上一财政年该商品信息
	 * @param id
	 * @return
	 */
	public GoodsVO getGoodsInfo(String id);
	
	/**
	 * 后置条件   返回上一财政年该客户信息
	 * @param id
	 * @return
	 */
	public MemberVO getMemberInfo(String id);
	
	/**
	 * 前置条件   已填写好期初建账的必要信息
	 * 后置条件   持久化保存期初建账信息，更新客户，账户，商品数据
	 * @param vo
	 * @return 
	 */
	public boolean saveInitAccountInfo(InitAccountVO vo);
	
	/**
	 * 前置条件   财务人员增加账户
	 * 后置条件   持久化保存新账户信息
	 * @param vo
	 * @return
	 */
	public boolean addAccount(AccountVO vo);
	
    /**
     * 前置条件   财务人员删除账户
     * 后置条件	持久化删除帐户信息
     * @param name
     * @return
     */
	public boolean deleteAccount(String name);
	
	/**
	 * 前置条件	财务人员修改账户信息后保存
	 * 后置条件	持久化保存账户信息
	 * @param name
	 * @return 
	 */
	public boolean saveAccount(String name,AccountVO vo);
	
	/**
	 * 前置条件	财务人员输入关键字进行模糊查找账户
	 * 后置条件	返回符合条件的账户列表
	 * @param keyword
	 * @return
	 */
	public ArrayList<String> searchAccount(String keyword);
	
	/**
	 * 后置条件	返回单据编号和操作员
	 * @param type
	 * @return
	 */
	public ListInitVO createList(ListType type);
	
	/**
	 * 后置条件	打开草稿单列表
	 * @return
	 */
	public Map openDraftList();
	
	/**
	 * 后置条件	打开一张草稿单
	 * @param type
	 * @param id
	 * @return
	 */
	public Map openList(ListType type, String id);
	
	/**
	 * 前置条件	启动一个收款／付款／现金费用回合
	 * 后置条件	持久化保存单据数据
	 * @param type
	 * @return 
	 */
	public boolean saveList(ListType type, PaymentListVO vo);
	
	/**
	 * 前置条件	输入会员id和姓名进行模糊查找
	 * 后置条件	返回所有符合条件的会员列表
	 * @param id
	 * @param name
	 * @return
	 */
	public Map searchMember(String id, String name);
	
	/**
	 * 后置条件	返回要查询的会员信息
	 * @param id
	 * @return
	 */
	public MemberVO getMember(String id);
	
	/**
	 * 前置条件	启动一个收款／付款／现金费用回合
	 * 后置条件	返回银行账户信息
	 * @param AccountName
	 * @return
	 */
	public AccountVO getAccount(String AccountName);
	
	/**
	 * 前置条件	已填写好收款／付款／现金费用单信息
	 * 后置条件	提交单据并持久化保存单据数据
	 * @param type
	 * @return 
	 */
	public boolean commitList(ListType type, PaymentListVO vo);
	
	
	
	
}
