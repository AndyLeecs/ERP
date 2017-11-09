package VO;


/**     
* @author 李安迪
* @date 2017年10月27日
* @description 单据类继承的抽象类
*/
public abstract class ListVO {
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
	 * 单据状态
	 */
	
	State state;
}
