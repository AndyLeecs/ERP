package dataServiceImpl.accountImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import PO.ListPO;
import PO.account.CollectionListPO;
import dataHelper.BasicUtil;
import dataHelper.CriterionClause;
import dataHelper.CriterionClauseGenerator;
import dataHelper.HibernateCriterionClauseGenerator;
import dataHelper.HibernateOrderClauseGenerator;
import dataHelper.HibernateUtil;
import dataHelper.OrderClause;
import dataHelper.OrderClauseGenerator;
import dataService.accountDataService.CollectionListDataService;
import util.DataRM;
import util.DateUtil;
import util.State;

public class CollectionListDataServiceImpl extends UnicastRemoteObject implements CollectionListDataService {

	
	BasicUtil<CollectionListPO> basicUtil;
	CriterionClauseGenerator criterionClauseGenerator;
	OrderClauseGenerator orderClauseGenerator;
	
	public CollectionListDataServiceImpl() throws RemoteException{

		basicUtil = new HibernateUtil<CollectionListPO>(CollectionListPO.class);
		criterionClauseGenerator = new HibernateCriterionClauseGenerator();
		orderClauseGenerator = new HibernateOrderClauseGenerator();
	}
	
	public static final int LIST_MAX_NUM = 99999;
	@Override
	public String getNewListId()  throws RemoteException{
		CollectionListPO lastpo = basicUtil.getLastRow();
		String currentDate = DateUtil.getCurrentDate();
		String newId = "SDK"+"-"+currentDate + "-";
		if(lastpo == null){		//表空
			newId +="00001";
		}
		String lastId = lastpo.getId();
		String date = DateUtil.getDateFromListIDAsString(lastId);
		if(!currentDate.equals(date)){		//今天的第一张单子
			newId += "00001";
		}
		else{
			int num = Integer.parseInt(lastId.substring(lastId.lastIndexOf('-')+1));
			if(num == LIST_MAX_NUM)
				return null;
			newId += String.valueOf(++num);
		}
		CollectionListPO po = new CollectionListPO();
		po.setId(newId);
		po.setState(State.IsEditting);
		basicUtil.insert(po);
		return newId;
		
	}
	
	public static void main(String [] args){
		CollectionListPO po = new CollectionListPO();
		po.setId("SKD-20171227-00001");
		po.setVIPID("monk");
		CollectionListDataServiceImpl impl;
		try {
			impl = new CollectionListDataServiceImpl();
			System.out.println(impl.delete("SKD-20171227-00001"));
			System.out.println(impl.insert(po));
			
//			System.out.println((impl.getNewListId()));
//			System.out.println((impl.getNewListId()));
//			System.out.println((impl.getNewListId()));

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public DataRM insert(ListPO po) throws RemoteException{
		String id = basicUtil.insert((CollectionListPO)po);
		if(id == null || id.equals(""))
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
	public List<ListPO> getList(State state) throws RemoteException {
		List<CriterionClause> l = new ArrayList<CriterionClause>();
		l = criterionClauseGenerator.generateExactCriterion(l,"state", state);
		OrderClause o = orderClauseGenerator.generateDescOrder("day");
//		return basicUtil.Query(l, o);	//返回值不兼容。。太尴尬了
		return null;
		
	}

}
