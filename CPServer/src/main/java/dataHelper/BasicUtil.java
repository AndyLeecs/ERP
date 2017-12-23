package dataHelper;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.List;

import org.hibernate.criterion.Criterion;

import util.DataRM;

/**     
* @author 李安迪
* @date 2017年12月15日
* @description 数据库基础功能
*/
public interface BasicUtil<T> extends Remote,Serializable{

	/**
	 * id为自动生成数字时的新增方法
	 * @param po
	 * @return 
	 * 成功-返回自动生成id
	 * 失败-返回-1
	 */
	public int insertForAuto(Object po);
	/**
	 * id为业务id时的新增方法
	 * @param po 
	 * @return
	 * 成功-返回业务id
	 * 失败-返回空串
	 */
	public String insert(Object po);
	/**
	 * 
	 * @param id 自动生成的id
	 * @return 该id的po实体
	 */
	public Object get(int id);
	/**
	 * @param o
	 * @return 
	 * SUCCESS 成功
	 * FAILED 失败
	 * NOT_EXIST 不存在指定id的po，持久化更新失败
	 */
	public DataRM update(Object po);

//	/**
//	 * 模糊查询
//	 * @param field
//	 * @param value
//	 * @return
//	 */ 
//	List<T> fuzzyQuery(String field, String value);
//	/**精确查询
//	 * @param field
//	 * @param value
//	 * @return
//	 */
//	List<T> exactQuery(String field, Object value);
//	/**
//	 * 返回field域大于等于value的po
//	 * @param field
//	 * @param value
//	 * @return
//	 */
//	List<T> geQuery(String field, Object value);
//	/**
//	 * 同一个field，多种value都可以的精确查询
//	 * @param field
//	 * @param values
//	 * @return
//	 */
//	List<T> exactQuery(String field, Object[] values);
//	/*
//	 * @param criterionList
//	 * @return
//	 */
	List<T> Query(List<CriterionClause> criterionList);

	/**
	 * @param criterionParentList 查找端的限制条件
	 * @param criterionChildList 级联端的限制条件
	 * @param string 被级联的属性
	 * @return
	 */
	List<T> CascadeQuery(List<CriterionClause> criterionParentList, List<CriterionClause> criterionChildList,
			String string);
	
	
}
