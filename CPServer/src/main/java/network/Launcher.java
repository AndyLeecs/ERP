package network;

/**
 * 类名为什么叫launcher？我改成Serverhelper了	zxy
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import dataService.VIPDataService.VIPDataService;
import dataService.goodsDataService.GoodsDataService;
import dataService.presentDataService.PresentDataService;
import dataService.saleDataService.SaleDataService;
import dataService.storeDataService.StoreDataService;
import dataServiceImpl.VIPImpl.VIPDataServiceImpl;
import dataServiceImpl.goodsImpl.GoodsDataServiceImpl;
import dataServiceImpl.presentImpl.PresentDataServiceImpl;
import dataServiceImpl.saleImpl.SaleDataServiceImpl;
import dataServiceImpl.stroreImpl.StoreDataServiceImpl;

import javax.print.attribute.standard.MediaSize;

public class Launcher {
//RMI启动 
//	 private static Registry registry; //不知道为什么在这儿会有warning	//因为你没有使用这个变量。。这个不需要
	 private static Launcher launcher;
	 private Launcher(int port){
		 start(port); //port 是端口号
	 }
	 public Launcher getLauncher(){
		 if(launcher!=null){
			 return launcher;
		 }else{
			 return null;
		 }
	 } 
	public static Launcher start(int port){
		try {
			LocateRegistry.createRegistry(port);
			System.out.println("successful connection");
			StoreDataService storeDataService=new StoreDataServiceImpl();
			Naming.rebind("StoreDataService", storeDataService);
			PresentDataService presentDataService=new PresentDataServiceImpl();
			Naming.rebind("PresentDataService", presentDataService);			
			SaleDataService saleDataService=new SaleDataServiceImpl();
			Naming.rebind("SaleDataService", saleDataService);
			GoodsDataService goodsDataService=new GoodsDataServiceImpl();
			Naming.rebind("GoodsDataService",goodsDataService);
			VIPDataService vipDataService=new VIPDataServiceImpl();
			Naming.rebind("VIPDataService",vipDataService);
			return launcher;
		} catch (RemoteException e) {
			return null;
		} catch (MalformedURLException e) {
			return null;
		}
		
		
	}
}
