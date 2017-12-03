package network.presentRemoteHelper;

import java.rmi.Remote;

import dataService.presentDataService.PresentDataService;

public class PresentDataServiceHelper {

	private PresentDataService presentDataService;
	
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
}
