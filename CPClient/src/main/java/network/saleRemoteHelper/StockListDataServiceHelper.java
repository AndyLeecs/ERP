package network.saleRemoteHelper;

import java.rmi.Remote;

import dataService.saleDataService.SaleUniDataService;
import network.DataServiceHelper;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description
*/
public class StockListDataServiceHelper implements DataServiceHelper{
	private SaleUniDataService StockListDataService;
	private static final String serviceName = "StockListDataService";
	private static StockListDataServiceHelper StockListRemoteHelper = new StockListDataServiceHelper();
	public static StockListDataServiceHelper getInstance(){
		return StockListRemoteHelper;
	}
    private StockListDataServiceHelper(){
    }
    
    public void setRemote(Remote remote){
    	StockListDataService = (SaleUniDataService)remote;
    }
    
    public SaleUniDataService getStockListDataService(){
    	return StockListDataService;
    }
	/* (non-Javadoc)
	 * @see network.DataServiceHelper#getServiceName()
	 */
	@Override
	public String getServiceName() {
		// TODO Auto-generated method stub
		return serviceName;
	}
}
