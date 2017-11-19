package bl.VIPbl;

import java.util.ArrayList;
import java.util.List;

import VO.VIPVO;
import bl.utilitybl.ResultMessage;
import blservice.VIPblservice.VIPBLImpl;
/**
 * 
 * @author julia98
 *
 */
public class VIPBL_Driver {
	String id = "00000001";
	String phoneNumber = "18812345678";
	String info = "Julia";
	String type = "name";
	String testResult;
	VIPBLImpl test;
	private static final VIPVO test_0 = new VIPVO(null, null, null, null, null);
	
	public void drive() {
		ResultMessage resultMessage;
		
		//1
		testResult = test.newVIP(phoneNumber);
		if(testResult != null) 
			System.out.println("Get new VIP succuess!");
		else
			System.out.println("Get new VIP failed!");
		
		//2
		ArrayList<VIPVO> testlist = new ArrayList<VIPVO>();
		testlist = test.findVIP(info, type);
		if(testlist != null)
			System.out.println("Find VIP success!");
		else
			System.out.println("Find VIP failed!");
		
		//3
		resultMessage = test.deleteVIP(id);
		if(resultMessage == ResultMessage.SUCCESS)
			System.out.println("Delete VIP success!");
		else
			System.out.println("Delete VIP failed!");
		
		//4
		resultMessage = test.modifyVIP(test_0);
		if(resultMessage == ResultMessage.SUCCESS)
			System.out.println("Modify VIP success!");
		else
			System.out.println("Modify VIP failed!");
		
		//5
		resultMessage = test.initAndSaveVIP(test_0);
		if(resultMessage == ResultMessage.SUCCESS)
			System.out.println("Init and save VIP success!");
		else
			System.out.println("Init and save VIP failed!");
		
		//6
		List<VIPVO> testlist1 = new ArrayList<VIPVO>();
		testlist1 = test.getVIPInfo();
		if(testlist1 != null)
			System.out.println("Get VIP Info success!");
		else
			System.out.println("Get VIP Info failed!");
	}

}
