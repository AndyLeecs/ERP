package dataService.presentDataService;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import PO.PresentForSpecialPackagePO;
import util.DataRM;

/**     
* @author 李安迪
* @date 2017年12月13日
* @description
*/
public interface PresentForSpecialPackageDataService extends Remote,Serializable{
	public int insert() throws RemoteException;
	public DataRM deletePresentForSpecialPackage(int id) throws RemoteException;
	public DataRM update(PresentForSpecialPackagePO po) throws RemoteException;
	public List<PresentForSpecialPackagePO> getPresentForSpecialPackage() throws RemoteException;
	public List<PresentForSpecialPackagePO> getPresentForSpecialPackage(List<String> GoodsID) throws RemoteException;
}
