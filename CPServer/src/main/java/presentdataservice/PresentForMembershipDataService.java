package presentdataservice;

import java.util.List;

import PO.PresentForMembershipPO;
import PO.PresentForSpecialPackagePO;
import PO.PresentForSumPO;
import PO.VIPGrade;

/**     
* @author 李安迪
* @date 2017年11月9日
* @description
*/
public interface PresentForMembershipDataService {
	public String insert(PresentForMembershipPO po);
	public boolean deletePresentForMembership(String id);
	public boolean update(PresentForMembershipPO po);
	public List<PresentForMembershipPO> getPresentForMembership();
	public List<PresentForMembershipPO> getPresentForMembership(VIPGrade grade);
	
	
	

}
