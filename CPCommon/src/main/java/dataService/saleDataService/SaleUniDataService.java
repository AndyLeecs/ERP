package dataService.saleDataService;

import java.rmi.RemoteException;
import java.util.List;

import PO.SalesmanListPO;
import util.DataRM;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description
*/
public interface SaleUniDataService {

	/**
	 * @return
	 */
	String insert() throws RemoteException;

	/**
	 * @param id
	 * @return
	 */
	DataRM delete(String id) throws RemoteException;

	/**
	 * @param voToPo
	 * @return
	 */
	DataRM save(SalesmanListPO voToPo) throws RemoteException;

	/**
	 * @param voToPo
	 * @return
	 */
	DataRM commit(SalesmanListPO voToPo) throws RemoteException;

	/**
	 * @return
	 */
	List<SalesmanListPO> openAllDraft() throws RemoteException;

}
