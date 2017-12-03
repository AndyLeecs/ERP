package dataService.saleDataService;

import java.rmi.Remote;
import java.util.List;

import PO.SaleListPO;
import PO.SaleReturnListPO;
import PO.SalesmanListPO;
import PO.State;
import PO.StockListPO;
import PO.StockReturnListPO;
import util.DataRM;

public interface SaleDataService extends Remote{
	public List<SalesmanListPO> get(State state);
	
	public String getNewSaleListId();
	public DataRM insert(SaleListPO po);
	public DataRM deleteSaleList(String id);
	public DataRM update(SaleListPO po);
	public List<SaleListPO> getSaleList(State state);
	
	public String getNewSaleReturnListId();
	public DataRM insert(SaleReturnListPO po);
	public DataRM deleteSaleReturnList(String id);
	public DataRM update(SaleReturnListPO po);
	public List<SaleReturnListPO> getSaleReturnList(State state);
	
	public String getNewStockListId();
	public DataRM insert(StockListPO po);
	public DataRM deleteStockList(String id);
	public DataRM update(StockListPO po);
	public List<StockListPO> getStockList(State state);
	
	public String getNewStockReturnListId();
	public DataRM insert(StockReturnListPO po);
	public DataRM deleteStockReturnList(String id);
	public DataRM update(StockReturnListPO po);
	public List<StockReturnListPO> getStockReturnList(State state);


}
