package dataService.presentDataService;

import java.util.List;

import PO.PresentForSumPO;
import util.DataRM;

/**     
* @author 李安迪
* @date 2017年12月13日
* @description
*/
public interface PresentForSumDataService {
	public DataRM insert(PresentForSumPO po);
	public DataRM deletePresentForSum(String id);
	public DataRM update(PresentForSumPO po);
	public List<PresentForSumPO> getPresentForSum();
	public List<PresentForSumPO> getPresentForSum(int sum);
}
