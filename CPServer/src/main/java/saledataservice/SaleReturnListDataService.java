package saledataservice;

import java.util.List;

import PO.SaleReturnListPO;
import PO.State;

/**     
* @author 李安迪
* @date 2017年11月10日
* @description
*/
public interface SaleReturnListDataService {
	public String insert(SaleReturnListPO po);
	public boolean deleteSaleReturnList(String id);
	public boolean update(SaleReturnListPO po);
	public List<SaleReturnListPO> getSaleReturnList(State state);
}
