package network.storeRemoteHelper;

import java.rmi.Remote;

import dataService.storeDataService.StoreDataService;

public class StoreDataServiceHelper {

	private StoreDataService storeDataService;
	
	private static StoreDataServiceHelper storeRemoteHelper = new StoreDataServiceHelper();
	public static StoreDataServiceHelper getInstance(){
		return storeRemoteHelper;
	}
    private StoreDataServiceHelper(){
    }
    
    public void setRemote(Remote remote){
    	storeDataService = (StoreDataService)remote;
    }
    
    public StoreDataService getStoreDataService(){
    	return storeDataService;
    }
}
