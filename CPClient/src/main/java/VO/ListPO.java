package VO;


/**     
* @author 李安迪
* @date 2017年10月27日
* @description 单据类继承的抽象类
*/
public abstract class ListPO {
	/**
	 * 单据编号
	 */
	String id;
	/**
	 * 操作员名称
	 */
	String operator;
	/**
	 * 操作员编号
	 */
	String operatorId;
	/**
	 * 审批状态
	 */
	boolean isApproved;
	/**
	 * 通过状态
	 */
	boolean isRefused;	
	
}
