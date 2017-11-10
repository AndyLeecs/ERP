package blservice.presentblservice;

import java.util.List;

import VO.PresentForMembershipVO;
import bl.utilitybl.ResultMessage;

/**     
* @author 李安迪
* @date 2017年11月9日
* @description
*/
public interface PresentForMembershipBLService {
	public List<PresentForMembershipVO> allPresentForMembership();
	public ResultMessage addPresentForMembership(PresentForMembershipVO vo);
	public ResultMessage deletePresentForMembership(String id);
	public ResultMessage savePresentForMembership(PresentForMembershipVO vo);
}
