package dataServiceImpl.saleImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import PO.SalesmanListPO;
import PO.StockListPO;
import dataHelper.BasicUtil;
import dataHelper.CriterionClause;
import dataHelper.CriterionClauseGenerator;
import dataHelper.HibernateCriterionClauseGenerator;
import dataHelper.HibernateUtil;
import dataService.saleDataService.StockListDataService;
import dataService.saleDataService.SaleUniDataService;
import resultmessage.DataRM;
import util.State;

/**     
* @author 李安迪
* @date 2017年12月25日
* @description
*/
public class StockListDataServiceImpl extends UnicastRemoteObject implements StockListDataService {

	BasicUtil<StockListPO> util;
	//	BasicUtil<StockListPO> util;
	CriterionClauseGenerator criterionClauseGenerator;
	/**
	 * @throws RemoteException
	 */
	public StockListDataServiceImpl() throws RemoteException {
		super();
		util = new HibernateUtil<StockListPO>(StockListPO.class);
		criterionClauseGenerator = new HibernateCriterionClauseGenerator();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleUniDataService#insert()
	 */
	@Override
	public String insert() throws RemoteException {
		// TODO Auto-generated method stub
		return util.getNewListId("JHD", new StockListPO());	}

	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleUniDataService#delete(java.lang.String)
	 */
	@Override
	public DataRM delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		StockListPO po = (StockListPO)(util.get(id));
		po.setState(State.IsDeleted);
		return util.update(po);
	}

	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleUniDataService#save(PO.SalesmanListPO)
	 */
	@Override
	public DataRM save(SalesmanListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return util.update(po);
	}


	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleUniDataService#commit(PO.SalesmanListPO)
	 */
	@Override
	public DataRM commit(SalesmanListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return util.update(po);
	}

	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleUniDataService#approve(PO.SalesmanListPO)
	 */
	@Override
	public DataRM approve(SalesmanListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return util.update(po);
	}

	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleUniDataService#refuse(PO.SalesmanListPO)
	 */
	@Override
	public DataRM refuse(SalesmanListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return util.update(po);
	}
	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleUniDataService#openAllDraft()
	 */
	@Override
	public List<SalesmanListPO> openAllDraft() throws RemoteException {
		// TODO Auto-generated method stub
		
		List<CriterionClause> l = new ArrayList<CriterionClause>();
		l = criterionClauseGenerator.generateExactCriterion(l,"state",State.IsDraft);
		System.out.println(l);
		System.out.println("before query");
		List<SalesmanListPO> list = (List)util.Query(l);
		System.out.println("before return");
		System.out.println(list);
		return list;
	}

	
	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleUniDataService#get(java.lang.String)
	 */
	@Override
	public SalesmanListPO get(String id) throws RemoteException {
		// TODO Auto-generated method stub
		List<CriterionClause> l = new ArrayList<CriterionClause>();
		l = criterionClauseGenerator.generateExactCriterion(l,"id",id);
		List<SalesmanListPO> list = (List)util.Query(l);
		if(list.size() == 1){
			return list.get(0);
		}else
			
		return null;
	}
}
