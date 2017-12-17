package dataService.presentDataService;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.List;

import PO.PresentForSpecialPackagePO;
import util.DataRM;

/**     
* @author 李安迪
* @date 2017年12月13日
* @description
*/
public interface PresentForSpecialPackageDataService extends Remote,Serializable{
	public int insert();
	public DataRM deletePresentForSpecialPackage(int id);
	public DataRM update(PresentForSpecialPackagePO po);
	public List<PresentForSpecialPackagePO> getPresentForSpecialPackage();
	public List<PresentForSpecialPackagePO> getPresentForSpecialPackage(List<String> GoodsID);
}
