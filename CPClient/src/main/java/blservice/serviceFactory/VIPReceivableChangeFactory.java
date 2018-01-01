package blservice.serviceFactory;
 
 import bl.VIPbl.VIPReceivableChangeService_Stub;
 import blservice.VIPblservice.VIPReceivableChangeService;
 
 public class VIPReceivableChangeFactory {
 	public static VIPReceivableChangeService getVIPReceivableChangeService(){
 		//TODO change it when finish
 		return new VIPReceivableChangeService_Stub();
 	}
 }