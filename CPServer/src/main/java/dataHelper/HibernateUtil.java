package dataHelper;

import java.util.List;

import javax.persistence.OptimisticLockException;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import util.DataRM;

/**     
* @author 李安迪
* @date 2017年12月1日
* @description 数据库基础功能的hibernate实现
*/

public class HibernateUtil<T> implements BasicUtil<T>{

    private SessionFactory sessionFactory;
    private Session session = null;
    private Transaction transaction = null;

//    public SessionFactory sessionFactory;
//    public Session session;//用public简易测试
    private Class<T> type;
    
    public HibernateUtil(Class<T> type) {
    	this.type = type;
    	sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    
//这段代码没有处理transaction回滚等操作,故删去,session和transaction的基础建立只有固定的两句话，故没有封装成方法
//    /**
//     * 初始化Session
//     */
//    private void setUpSession() {
//        session = sessionFactory.openSession();
//        session.beginTransaction();
//       
//    }
//
//    /**
//     * 提交事务及关闭session
//     */
//    private void commitAndClose() {
//        session.getTransaction().commit();
//        session.close();
//    }


	/* (non-Javadoc)
	 * @see dataHelper.BasicUtil#insertForAuto(java.lang.Object)
	 */
	@Override
	public int insertForAuto(Object po) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		transaction = null;
		int id = -1;
        try {
        	transaction = session.beginTransaction();
            id = (Integer)session.save(type.getName(), po);
            transaction.commit();
        } catch (HibernateException e) {
        	if(transaction!=null){
        		transaction.rollback();
        		e.printStackTrace();
        	}
        }finally{
           		session.close();
        	}
        
        return id;
        }
	
	

	/* (non-Javadoc)
	 * @see dataHelper.BasicUtil#insert(java.lang.Object)
	 * 此方法并不是正确的实现，需要的人自己实现一下吧
	 */
	@Override
	public String insert(Object po) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		transaction = null;
		String id = "";
        try {
        	transaction = session.beginTransaction();
            id = (String)session.save(type.getName(), po);
            transaction.commit();
        } catch (HibernateException e) {
        	if(transaction!=null){
        		transaction.rollback();
        		e.printStackTrace();
        	}
        }finally{
           		session.close();
        	}
        
        return id;
	}

	/* (non-Javadoc)
	 * @see dataHelper.BasicUtil#update(java.lang.Object)
	 */
	@Override
	public DataRM update(Object po) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		transaction = null;
		DataRM rm = DataRM.SUCCESS;
        try {
        	transaction = session.beginTransaction();
            session.update(type.getName(), po);
            transaction.commit();
        } catch (OptimisticLockException e) {
        	if(transaction!=null){
        		transaction.rollback();
        		e.printStackTrace();
        		rm = DataRM.NOT_EXIST;
        	}
        }catch(HibernateException e){
        	if(transaction!=null){
        		transaction.rollback();
        		e.printStackTrace();
        		rm = DataRM.FAILED;
        	}
        
        }finally{
           		session.close();
        	}
        
        return rm;
        }
	@Override
	public List<T> fuzzyQuery(String field, String value){
		Criterion s = null;
		value = "%"+value+"%";
		//如果查询域为空，整表查询
		if(!field.isEmpty())
		s = Restrictions.like(field,value);
		return Query(s);
	}

	@Override
	public List<T> exactQuery(String field, Object value){
		Criterion s = null;
		//如果查询域为空，整表查询
		if(!field.isEmpty())
		s = Restrictions.like(field,value);
		return Query(s);
	}
	
	@Override
	public List<T> geQuery(String field, Object value){
		Criterion s = null;
		if(!field.isEmpty())
		s = Restrictions.ge(field,value);
		return Query(s);
	}
	
	@Override
	public List<T> exactQuery(String field, Object[] values){
		Criterion s = null;
		if(!field.isEmpty())
		s = Restrictions.in(field, values);
		return Query(s);
	}
	/* (non-Javadoc)
	 * @see dataHelper.BasicUtil#likePatternQuery(java.lang.String, java.lang.String)
	 */
	
	private List<T> Query(Criterion s) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		transaction = null;
		List<T> list = null;
	try{
		transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(type.getName());
        if(s!=null)
        criteria.add(s);
        list = criteria.list();
        transaction.commit();
        session.close();
        return list;
    } catch (HibernateException e) {
    	if(transaction != null)
    	{
    		transaction.rollback();
    	}
    	e.printStackTrace();
    	return null;
    }finally{
    	session.close();
    }
		
	}

	/* (non-Javadoc)
	 * @see dataHelper.BasicUtil#get(int)
	 */
	@Override
	public Object get(int id) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		transaction = null;
		Object o = null;
        try {
        	transaction = session.beginTransaction();
            o = session.get(type.getName(), id);
            transaction.commit();
        } catch (HibernateException e) {
        	if(transaction!=null){
        		transaction.rollback();
        		e.printStackTrace();
        	}
        }finally{
           		session.close();
        	}
        
        return o;
	}


}

