package bl.presentbl;

import blservice.presentblservice.PresentForMembershipBLService;
import blservice.presentblservice.PresentForSpecialPackageBLService;
import blservice.presentblservice.PresentForSumBLService;

/**     
* @author 李安迪
* @date 2017年12月13日
* @description
*/
public class PresentBLFactory {
	public synchronized static PresentForSumBLService getPresentForSumBLService(){
		return new PresentForSumBLServiceImpl();
	}
	public synchronized static PresentForSpecialPackageBLService getPresentForSpecialPackageBLService(){
		return new PresentForSpecialPackageBLServiceImpl();
	}
	
	public synchronized static PresentForMembershipBLService getPresentForMembershipBLService(){
		return new PresentForMembershipBLServiceImpl();
	}
}
