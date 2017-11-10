package presentdataservice;

import java.util.List;

import PO.PresentForMembershipPO;
import PO.PresentForSpecialPackagePO;
import PO.PresentForSumPO;

/**     
* @author 李安迪
* @date 2017年11月9日
* @description
*/
public interface PresentForSpecialPackageDataService {
	public String insert(PresentForSpecialPackagePO po);
	public boolean deletePresentForSpecialPackage(String id);
	public boolean update(PresentForSpecialPackagePO po);
	public List<PresentForSpecialPackagePO> getPresentForSpecialPackage();
	public List<PresentForSpecialPackagePO> getPresentForSpecialPackage(List<String> GoodsID);
}
