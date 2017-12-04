package dataHelper;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**     
* @author 李安迪
* @date 2017年12月1日
* @description
*/

public class HibernateUtil {

//    private SessionFactory sessionFactory;
//    private Session session;

    public SessionFactory sessionFactory;
    public Session session;//用public简易测试
    
    public HibernateUtil(){
    	sessionFactory = new Configuration().configure().buildSessionFactory();
    	//下面那行在实际实现中可能需要注释掉，待设计
    	session = sessionFactory.openSession();
    }
    
    /**
     * 初始化Session
     */
    private void setUpSession() {
        session = sessionFactory.openSession();
        session.beginTransaction();
       
    }

    /**
     * 提交事务及关闭session
     */
    private void commitAndClose() {
        session.getTransaction().commit();
        session.close();
    }
}

