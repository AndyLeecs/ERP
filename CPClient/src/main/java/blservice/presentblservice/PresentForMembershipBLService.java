package blservice.presentblservice;

import VO.presentVO.PresentForMembershipVO;
import util.ResultMessage;

/**     
* @author 李安迪
* @date 2017年12月12日
* @description
*/
public interface PresentForMembershipBLService {
	public ResultMessage addPresentForMembership(PresentForMembershipVO vo);
	public ResultMessage deletePresentForMembership(String id);
	public ResultMessage savePresentForMembership(PresentForMembershipVO vo);
}
