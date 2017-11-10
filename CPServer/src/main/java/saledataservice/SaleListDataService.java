package saledataservice;

import java.util.List;

import PO.SaleListPO;
import PO.State;

/**     
* @author 李安迪
* @date 2017年11月10日
* @description
*/
public interface SaleListDataService {
	public String insert(SaleListPO po);
	public boolean deleteSaleList(String id);
	public boolean update(SaleListPO po);
	public List<SaleListPO> getSaleList(State state);
}
