package dataServiceImpl.presentImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import PO.PresentForMembershipPO;
import PO.PresentForSumPO;
import dataHelper.BasicUtil;
import dataHelper.CriterionClause;
import dataHelper.CriterionClauseGenerator;
import dataHelper.HibernateCriterionClauseGenerator;
import dataHelper.HibernateUtil;
import dataService.presentDataService.PresentForMembershipDataService;
import util.DataRM;
import util.PresentState;
import util.VIPGrade;

/**     
* @author 李安迪
* @date 2017年12月20日
* @description
*/
public class PresentForMembershipDataServiceImpl extends UnicastRemoteObject implements PresentForMembershipDataService{

	/* (non-Javadoc)
	 * @see dataService.presentDataService.PresentForMembershipDataService#insert()
	 */
	BasicUtil<PresentForMembershipPO> util;
	CriterionClauseGenerator criterionClauseGenerator;
	
	public PresentForMembershipDataServiceImpl() throws RemoteException{

		util = new HibernateUtil<PresentForMembershipPO>(PresentForMembershipPO.class);
		criterionClauseGenerator = new HibernateCriterionClauseGenerator();
	}
	/* (non-Javadoc)
	 * @see dataService.presentDataService.PresentForSumDataService#insert()
	 */
	@Override
	public int insert() throws RemoteException{
		// TODO Auto-generated method stub
		return util.insertForAuto(new PresentForMembershipPO());
	}

	/* (non-Javadoc)
	 * @see dataService.presentDataService.PresentForSumDataService#deletePresentForSum(int)
	 */
	@Override
	public DataRM deletePresentForMembership(int id) throws RemoteException {
		// TODO Auto-generated method stub
		PresentForMembershipPO po = (PresentForMembershipPO)(util.get(id));
		//惰性删除
		po.setState(PresentState.DELETE);
		return util.update(po);
	}

	/* (non-Javadoc)
	 * @see dataService.presentDataService.PresentForSumDataService#update(PO.PresentForSumPO)
	 */
	@Override
	public DataRM update(PresentForMembershipPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return util.update(po);
	}

	/* (non-Javadoc)
	 * @see dataService.presentDataService.PresentForSumDataService#getPresentForSum()
	 */
	@Override
	public List<PresentForMembershipPO> getPresentForMembership() throws RemoteException {
		// TODO Auto-generated method stub		
		List<CriterionClause> l = new ArrayList<CriterionClause>();
		l = criterionClauseGenerator.generateExactCriterion(l,"state", PresentState.SAVE);
		return util.Query(l);
	}

	/* (non-Javadoc)
	 * @see dataService.presentDataService.PresentForSumDataService#getPresentForSum(int)
	 * 注意获取的是某一特定等级的促销策略，而不是这个等级及以上的
	 */
	@Override
	public List<PresentForMembershipPO> getPresentForMembership(VIPGrade grade) throws RemoteException {
		// TODO Auto-generated method stub
		List<CriterionClause> l = new ArrayList<CriterionClause>();
		l = criterionClauseGenerator.generateExactCriterion(l,"grade", grade);
		l = criterionClauseGenerator.generateExactCriterion(l,"state", PresentState.SAVE);
		l = criterionClauseGenerator.generateCurrentTimeInRangeCriterion(l);
		return util.Query(l);
	}


}
