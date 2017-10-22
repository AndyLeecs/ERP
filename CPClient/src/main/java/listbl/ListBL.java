package listbl;

import java.util.*;
import VO.*;

public interface ListBL {
	/**
	 * 后置条件	系统显示所有表单
	 * @return
	 */
	public ArrayList checkList();
	
	/**
	 * 后置条件	返回销售明细记录
	 * @param vo
	 * @return
	 */
	public ArrayList checkSaleDetailForm(SaleDetailConditionVO vo);
	
	/**
	 * 后置条件	返回经营历程列表
	 * @param vo
	 * @return
	 */
	public ArrayList checkBusinessProcessForm(BusinessProcessConditionVO vo);
	
	/**
	 * 后置条件	返回具体的某个单据信息
	 * @param type
	 * @param id
	 * @return
	 */
	public ListVO getSpecificList(ListType type, String id);
	
	/**
	 * 后置条件	持久化保存一个生成一个一模一样但是仅仅把数量取负数的单子并入账
	 * @param type
	 * @param id
	 * @return 
	 */
	public boolean hongchong(ListType type, String id);
	
	/**
	 * 后置条件	持久化保存一个生成一个一模一样但是仅仅把数量取负数的单子并入账,返回一个新的草稿单的单据编号
	 * @param type
	 * @param id
	 * @return
	 */
	public String hongchongAndCopy(ListType type, String id);
	
	/**
	 * 后置条件	返回经营情况表
	 * @param begainTime
	 * @param EndTime
	 * @return
	 */
	public BusinessCircumVO checkBusinessCircumForm(Date begainTime, Date EndTime);
	
	/**
	 * 后置条件	持久化保存单据审批后结果
	 * @param type
	 * @param ID
	 * @param vo
	 * @return 
	 */
	public boolean approvalList(ListType type, String ID, ListVO vo);
	

}
