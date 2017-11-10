package saledataservice;

import java.util.List;

import PO.State;
import PO.StockReturnListPO;

/**     
* @author 李安迪
* @date 2017年11月10日
* @description
*/
public interface StockReturnListDataService {
	public String insert(StockReturnListPO po);



	public boolean deleteStockReturnList(String id);



	public boolean update(StockReturnListPO po);



	public List<StockReturnListPO> getStockReturnList(State state);
}
