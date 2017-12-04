package network.presentRemoteHelper;

import java.rmi.Remote;

import dataService.presentDataService.PresentDataService;
import network.DataServiceHelper;

public class PresentDataServiceHelper implements DataServiceHelper{

	private PresentDataService presentDataService;
	private static final String serviceName = "PresentDataService";
	
	private static PresentDataServiceHelper presentRemoteHelper = new PresentDataServiceHelper();
	public static PresentDataServiceHelper getInstance(){
		return presentRemoteHelper;
	}
    private PresentDataServiceHelper(){
    }
    
    public void setRemote(Remote remote){
    	presentDataService = (PresentDataService)remote;
    }
    
    public PresentDataService getPresentDataService(){
    	return presentDataService;
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
