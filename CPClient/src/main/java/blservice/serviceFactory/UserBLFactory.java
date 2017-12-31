package blservice.serviceFactory;

import bl.userbl.UserBLService_Stub;
import blservice.userblservice.AdministratorService;

public class UserBLFactory {
	public static AdministratorService getAdministratorService(){
		//TODO change return value when bl finishes
		return new UserBLService_Stub();
	}
}
