package network;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import dataService.presentDataService.PresentDataService;
import dataService.saleDataService.SaleDataService;
import dataService.storeDataService.StoreDataService;
import dataServiceImpl.presentImpl.PresentDataServiceImpl;
import dataServiceImpl.saleImpl.SaleDataServiceImpl;
import dataServiceImpl.stroreImpl.StoreDataServiceImpl;

public class ServerHelper {
	public int port = 1099;
	
	public ServerHelper(){
		initServer();
	}
	
	private void initServer(){
		try {
			LocateRegistry.createRegistry(port);
			System.out.println("successful connection");
			
			StoreDataService storeDataService=new StoreDataServiceImpl();
			Naming.bind("StoreDataService", storeDataService);
			System.out.println("bind successed!");

			PresentDataService presentDataService=new PresentDataServiceImpl();
			Naming.bind("PresentDataService", presentDataService);
			System.out.println("bind successed!");
			
			SaleDataService saleDataService=new SaleDataServiceImpl();
			Naming.bind("SaleDataService", saleDataService);
			System.out.println("bind successed!");
			//所有的service都要在这里绑定一下
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		} 
	}
	
	//现在pom报错，无法测试
	public static void main(String []args){
		new ServerHelper();
	}
	
}