package saledataservice;

import java.util.List;

import PO.ListPO;
import PO.SaleListPO;
import PO.SaleReturnListPO;
import PO.SalesmanListPO;
import PO.State;
import PO.StockListPO;
import PO.StockReturnListPO;

public interface SaleDataService {
	public List<SalesmanListPO> get(State state);
	
	public String insert(SaleListPO po);
	public boolean deleteSaleList(String id);
	public boolean update(SaleListPO po);
	public List<SaleListPO> getSaleList(State state);
	
	public String insert(SaleReturnListPO po);
	public boolean deleteSaleReturnList(String id);
	public boolean update(SaleReturnListPO po);
	public List<SaleReturnListPO> getSaleReturnList(State state);
	
	public String insert(StockListPO po);
	public boolean deleteStockList(String id);
	public boolean update(StockListPO po);
	public List<StockListPO> getStockList(State state);
	
	
	public String insert(StockReturnListPO po);



	public boolean deleteStockReturnList(String id);



	public boolean update(StockReturnListPO po);



	public List<StockReturnListPO> getStockReturnList(State state);


}
