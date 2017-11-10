package saledataservice;

import java.util.List;

import PO.ListPO;
import PO.SaleListPO;
import PO.SaleReturnListPO;
import PO.State;
import PO.StockListPO;
import PO.StockReturnListPO;

public interface SaleDataService extends SaleListDataService, SaleReturnListDataService, StockListDataService,StockReturnListDataService{
	public List<ListPO> get(State state);



}
