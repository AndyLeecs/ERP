package network.saleRemoteHelper;

import java.rmi.Remote;

import dataService.saleDataService.SaleUniDataService;
import network.DataServiceHelper;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description
*/
public class SaleReturnListDataServiceHelper implements DataServiceHelper{
	private SaleUniDataService SaleReturnListDataService;
	private static final String serviceName = "SaleReturnListDataService";
	private static SaleReturnListDataServiceHelper SaleReturnListRemoteHelper = new SaleReturnListDataServiceHelper();
	public static SaleReturnListDataServiceHelper getInstance(){
		return SaleReturnListRemoteHelper;
	}
    private SaleReturnListDataServiceHelper(){
    }
    
    public void setRemote(Remote remote){
    	SaleReturnListDataService = (SaleUniDataService)remote;
    }
    
    public SaleUniDataService getSaleReturnListDataService(){
    	return SaleReturnListDataService;
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
