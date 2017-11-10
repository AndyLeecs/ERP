package saledataservice;

import java.util.List;

import PO.State;
import PO.StockListPO;

/**     
* @author 李安迪
* @date 2017年11月10日
* @description
*/
public interface StockListDataService {
	public String insert(StockListPO po);
	public boolean deleteStockList(String id);
	public boolean update(StockListPO po);
	public List<StockListPO> getStockList(State state);
}
