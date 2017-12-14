package dataService.presentDataService;

import java.util.List;

import PO.PresentForMembershipPO;
import util.DataRM;
import util.VIPGrade;

/**     
* @author 李安迪
* @date 2017年12月13日
* @description
*/
public interface PresentForMembershipDataService {
	public String insert();
	public DataRM deletePresentForMembership(String id);
	public DataRM update(PresentForMembershipPO po);
	public List<PresentForMembershipPO> getPresentForMembership();
	public List<PresentForMembershipPO> getPresentForMembership(VIPGrade grade);
}
