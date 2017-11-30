package presentdataservice;

import java.util.List;

import PO.PresentForMembershipPO;
import PO.PresentForSpecialPackagePO;
import PO.PresentForSumPO;
import PO.PresentPO;
//import PO.VIPGrade;

/**     
* @author 李安迪
* @date 2017年11月9日
* @description
*/
public interface PresentDataService {
	public List<PresentPO> get();
	
	public String insert(PresentForMembershipPO po);
	public boolean deletePresentForMembership(String id);
	public boolean update(PresentForMembershipPO po);
	public List<PresentForMembershipPO> getPresentForMembership();
	//public List<PresentForMembershipPO> getPresentForMembership(VIPGrade grade);
	
	public String insert(PresentForSpecialPackagePO po);
	public boolean deletePresentForSpecialPackage(String id);
	public boolean update(PresentForSpecialPackagePO po);
	public List<PresentForSpecialPackagePO> getPresentForSpecialPackage();
	public List<PresentForSpecialPackagePO> getPresentForSpecialPackage(List<String> GoodsID);
	
	public String insert(PresentForSumPO po);
	public boolean deletePresentForSum(String id);
	public boolean update(PresentForSumPO po);
	public List<PresentForSumPO> getPresentForSum();
	public List<PresentForSumPO> getPresentForSum(int sum);
	
}
