package presentdataservice;

import java.util.List;

import PO.PresentForSumPO;

/**     
* @author 李安迪
* @date 2017年11月9日
* @description
*/
public interface PresentForSumDataService {
	public String insert(PresentForSumPO po);
	public boolean deletePresentForSum(String id);
	public boolean update(PresentForSumPO po);
	public List<PresentForSumPO> getPresentForSum();
	public List<PresentForSumPO> getPresentForSum(int sum);
	
	
}
