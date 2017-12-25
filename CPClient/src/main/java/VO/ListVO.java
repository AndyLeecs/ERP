package VO;

import java.util.Date;

import util.State;
//加一个分支推上去
/**     
* @author 李安迪
* @date 2017年10月27日
* @description 单据类继承的抽象类
*/
public class ListVO {
	/**
	 * 单据编号
	 */
	private String id;
	/**
	 * 操作员名称
	 */
	private String operator;
	/**
	 * 操作员编号
	 */
	private String operatorId;

	/**
	 * 单据状态
	 */
	private State state;

	/**
	 * 日期
	 */
	private Date day;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	
	
}
