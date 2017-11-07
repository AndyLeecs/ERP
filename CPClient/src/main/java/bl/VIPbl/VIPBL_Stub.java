package bl.VIPbl;

import java.util.List;

import bl.utilitybl.*;
import VO.VIPGrade;
import VO.VIPVO;
import bl.utilitybl.ResultMessage;

public class VIPBL_Stub implements VIPBLImpl {
	String id = "00000001";
	private static final VIPVO testVIPVO = new VIPVO("0000001","进货商",VIPGrade(1),"Julia","18812345678","123456789@qq.com","南京大学仙林校区","210023","100","100","200","200");

	@Override
	public String newVIP(String telephone) {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public List<VIPVO> findVIP(String info, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteVIP(String id) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modifyVIP(VIPVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage initAndSaveVIP(VIPVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public List<VIPVO> getVIPInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
