package network;

/**
 * 类名为什么叫launcher？我改成Serverhelper了	zxy
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import dataService.storeDataService.StoreDataService;
import dataServiceImpl.stroreImpl.*;
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
			
			return launcher;
		} catch (RemoteException e) {
			return null;
		} catch (MalformedURLException e) {
			return null;
		}
		
		
	}
}
