package presentdataservice;

import java.util.List;

import PO.PresentForMembershipPO;
import PO.PresentForSpecialPackagePO;
import PO.PresentForSumPO;
import PO.PresentPO;
import PO.VIPGrade;

/**     
* @author 李安迪
* @date 2017年11月9日
* @description
*/
public interface PresentDataService extends PresentForMembershipDataService, PresentForSpecialPackageDataService,PresentForSumDataService{
	
	public List<PresentPO> get();
}
