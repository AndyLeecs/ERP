package dataServiceImpl.accountImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import PO.ListPO;
import PO.account.FinanceListPO;
import dataHelper.BasicUtil;
import dataHelper.CriterionClause;
import dataHelper.CriterionClauseGenerator;
import dataHelper.HibernateCriterionClauseGenerator;
import dataHelper.HibernateOrderClauseGenerator;
import dataHelper.OrderClause;
import dataHelper.OrderClauseGenerator;
import dataService.accountDataService.FinanceListDataService;
import resultmessage.DataRM;
import util.State;

public abstract class FinanceListDataServiceImpl extends UnicastRemoteObject implements FinanceListDataService{

	
	private static final long serialVersionUID = -318092925874830342L;
	
	BasicUtil<? extends FinanceListPO> basicUtil;
	CriterionClauseGenerator criterionClauseGenerator;
	OrderClauseGenerator orderClauseGenerator;
	
	public FinanceListDataServiceImpl() throws RemoteException{
		criterionClauseGenerator = new HibernateCriterionClauseGenerator();
		orderClauseGenerator = new HibernateOrderClauseGenerator();
	}
	
	
	

	@Override
	public DataRM insert(ListPO po) throws RemoteException{
		String id = basicUtil.insert(po);
		if(id == null)
			return DataRM.EXIST;
		if(id.equals(""))
			return DataRM.FAILED;
		else
			return DataRM.SUCCESS;
	}

	@Override
	public DataRM delete(String id) throws RemoteException {
		return basicUtil.delete(id);
	}

	@Override
	public DataRM update(ListPO po) throws RemoteException {
		return basicUtil.update(po);
	}

	@Override
	public List<? extends FinanceListPO> getList(State state) throws RemoteException {
		List<CriterionClause> l = new ArrayList<CriterionClause>();
		l = criterionClauseGenerator.generateExactCriterion(l,"state", state);
		OrderClause o = orderClauseGenerator.generateDescOrder("day");
		return basicUtil.Query(l, o);	
	}
}
