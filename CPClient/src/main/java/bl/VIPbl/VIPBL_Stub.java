package bl.VIPbl;

import java.util.ArrayList;
import VO.VIPVO;
import bl.utilitybl.ResultMessage;
import blservice.VIPblservice.VIPBLImpl;
/**
 * 
 * @author julia98
 *
 */
public class VIPBL_Stub implements blservice.VIPblservice.VIPBLImpl {
	String id = "00000001";
	
	private static final VIPVO testVIPVO = new VIPVO("Julia","18812345678","123456789@qq.com","南大仙林校区","210023");

	@Override
	public String newVIP(String phoneNumber) {
		// TODO Auto-generated method stub
		System.out.println("New VIP Success!");
		return id;
	}

	@Override
	public ArrayList<VIPVO> findVIP(String info, String type) {
		// TODO Auto-generated method stub
		System.out.println("Find Success!");
		return new ArrayList<VIPVO>();
	}

	@Override
	public ResultMessage deleteVIP(String id) {
		// TODO Auto-generated method stub
		System.out.println("Delete Success!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modifyVIP(VIPVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Modify Success!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage initAndSaveVIP(VIPVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Init And Save Success!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<VIPVO> getVIPInfo() {
		// TODO Auto-generated method stub
		System.out.println("Get VIP Info Success!");
		ArrayList<VIPVO> test = new ArrayList<VIPVO>();
		test.add(testVIPVO);
		return test;
	}

}
