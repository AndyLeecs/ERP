package dataServiceImpl.accountImpl;

import java.rmi.RemoteException;
import java.util.List;

import PO.ListPO;
import PO.PresentForSumPO;
import PO.account.CollectionListPO;
import dataHelper.BasicUtil;
import dataHelper.CriterionClauseGenerator;
import dataHelper.HibernateCriterionClauseGenerator;
import dataHelper.HibernateUtil;
import dataService.accountDataService.CollectionListDataService;
import util.DataRM;
import util.State;

public class CollectionListDataServiceImpl implements CollectionListDataService {

	
	BasicUtil<CollectionListPO> basicUtil;
	CriterionClauseGenerator criterionClauseGenerator;
	
	public CollectionListDataServiceImpl() throws RemoteException{

		basicUtil = new HibernateUtil<CollectionListPO>(CollectionListPO.class);
		criterionClauseGenerator = new HibernateCriterionClauseGenerator();
	}
	
	@Override
	public String getNewListId() {
		int num = basicUtil.insertForAuto(new PresentForSumPO());
		if(num == -1)
			return null;
		String date = util.DateUtil.getCurrentDate();
		return "SKD" + "-" + date+"-"+String.valueOf(num);
		
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
