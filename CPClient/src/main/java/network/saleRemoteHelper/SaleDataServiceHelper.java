package network.saleRemoteHelper;

import java.rmi.Remote;

import dataService.saleDataService.SaleDataService;
import network.DataServiceHelper;

public class SaleDataServiceHelper implements DataServiceHelper{

	private SaleDataService saleDataService;
	private static final String serviceName = "SaleDataService";
	
	private static SaleDataServiceHelper saleRemoteHelper = new SaleDataServiceHelper();
	public static SaleDataServiceHelper getInstance(){
		return saleRemoteHelper;
	}
    private SaleDataServiceHelper(){
    }
    
    public void setRemote(Remote remote){
    	saleDataService = (SaleDataService)remote;
    }
    
    public SaleDataService getSaleDataService(){
    	return saleDataService;
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
