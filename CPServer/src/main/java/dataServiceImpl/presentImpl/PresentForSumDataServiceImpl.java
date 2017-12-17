package dataServiceImpl.presentImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import PO.PresentForSumPO;
import dataHelper.BasicUtil;
import dataHelper.HibernateUtil;
import dataService.presentDataService.PresentForSumDataService;
import util.DataRM;
import util.PresentState;

/**     
* @author 李安迪
* @date 2017年12月15日
* @description
*/
public class PresentForSumDataServiceImpl extends UnicastRemoteObject implements PresentForSumDataService{

	
	BasicUtil<PresentForSumPO> util;
	
	public PresentForSumDataServiceImpl() throws RemoteException{

		util = new HibernateUtil<PresentForSumPO>(PresentForSumPO.class);
	}
	/* (non-Javadoc)
	 * @see dataService.presentDataService.PresentForSumDataService#insert()
	 */
	@Override
	public int insert() throws RemoteException{
		// TODO Auto-generated method stub
		return util.insertForAuto(new PresentForSumPO());
	}

	/* (non-Javadoc)
	 * @see dataService.presentDataService.PresentForSumDataService#deletePresentForSum(int)
	 */
	@Override
	public DataRM deletePresentForSum(int id) throws RemoteException {
		// TODO Auto-generated method stub
		PresentForSumPO po = (PresentForSumPO)(util.get(id));
		//惰性删除
		po.setState(PresentState.DELETE);
		return util.update(po);
	}

	/* (non-Javadoc)
	 * @see dataService.presentDataService.PresentForSumDataService#update(PO.PresentForSumPO)
	 */
	@Override
	public DataRM update(PresentForSumPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return util.update(po);
	}

	/* (non-Javadoc)
	 * @see dataService.presentDataService.PresentForSumDataService#getPresentForSum()
	 */
	@Override
	public List<PresentForSumPO> getPresentForSum() throws RemoteException {
		// TODO Auto-generated method stub
		return util.exactQuery("", "");
	}

	/* (non-Javadoc)
	 * @see dataService.presentDataService.PresentForSumDataService#getPresentForSum(int)
	 */
	@Override
	public List<PresentForSumPO> getPresentForSum(double sum) throws RemoteException {
		// TODO Auto-generated method stub
		return util.geQuery("sum", sum);
	}

}
