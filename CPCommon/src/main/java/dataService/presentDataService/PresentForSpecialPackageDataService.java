package dataService.presentDataService;

import java.util.List;

import PO.PresentForSpecialPackagePO;
import util.DataRM;

/**     
* @author 李安迪
* @date 2017年12月13日
* @description
*/
public interface PresentForSpecialPackageDataService {
	public DataRM insert(PresentForSpecialPackagePO po);
	public DataRM deletePresentForSpecialPackage(String id);
	public DataRM update(PresentForSpecialPackagePO po);
	public List<PresentForSpecialPackagePO> getPresentForSpecialPackage();
	public List<PresentForSpecialPackagePO> getPresentForSpecialPackage(List<String> GoodsID);
}
