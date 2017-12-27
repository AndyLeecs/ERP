package dataServiceImpl.accountImpl;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import PO.ListPO;
import PO.account.CollectionListPO;
import dataHelper.BasicUtil;
import dataHelper.CriterionClauseGenerator;
import dataHelper.HibernateCriterionClauseGenerator;
import dataHelper.HibernateUtil;
import dataService.accountDataService.CollectionListDataService;
import util.DataRM;
import util.DateUtil;
import util.State;

public class CollectionListDataServiceImpl implements CollectionListDataService {

	
	BasicUtil<CollectionListPO> basicUtil;
	CriterionClauseGenerator criterionClauseGenerator;
	
	public CollectionListDataServiceImpl() throws RemoteException{

		basicUtil = new HibernateUtil<CollectionListPO>(CollectionListPO.class);
		criterionClauseGenerator = new HibernateCriterionClauseGenerator();
	}
	
	public static final int LIST_MAX_NUM = 99999;
	@Override
	public String getNewListId() {
		
		String lastId = null;//getLastID();
		if(lastId == null){
			//TODO 
		}
		String date = DateUtil.getDateFromListIDAsString(lastId);
		String currentDate = DateUtil.getCurrentDate();
		String newId = "SDK"+"-"+currentDate + "-";
		if(!currentDate.equals(date)){
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
//		int num = basicUtil.insertForAuto(new CollectionListPO());
//		if(num == -1)
//			return null;
//		String date = util.DateUtil.getCurrentDate();
//		return "SKD" + "-" + date+"-"+String.valueOf(num);
		
	}
	
	public static void main(String [] args){
		CollectionListDataServiceImpl impl;
		try {
			impl = new CollectionListDataServiceImpl();
			System.out.println((impl.getNewListId()));
//			System.out.println((impl.getNewListId()));
//			System.out.println((impl.getNewListId()));

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public DataRM insert(ListPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataRM delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataRM update(ListPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ListPO> getList(State state) {
		// TODO Auto-generated method stub
		return null;
	}

}
