package saledataservice;

import java.util.List;

import PO.SalesmanListPO;
import PO.State;

/**     
* @author 李安迪
* @date 2017年11月11日
* @description
*/
public interface SaleForAllDataService {
	public List<SalesmanListPO> get(State state);
}
