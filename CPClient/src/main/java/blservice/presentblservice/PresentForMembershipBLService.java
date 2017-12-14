package blservice.presentblservice;

import java.util.List;

import VO.presentVO.PresentForMembershipVO;
import VO.presentVO.PresentForSpecialPackageVO;
import util.DataRM;
import util.ResultMessage;

/**     
* @author 李安迪
* @date 2017年12月12日
* @description
*/
public interface PresentForMembershipBLService {
	public List<PresentForMembershipVO> getAll();
	public int getId();
	public DataRM delete(int id);
	public DataRM save(PresentForMembershipVO vo);
}
