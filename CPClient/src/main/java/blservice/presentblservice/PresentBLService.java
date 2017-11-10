package blservice.presentblservice;

import java.util.List;

import VO.PresentForMembershipVO;
import VO.PresentForSpecialPackageVO;
import VO.PresentForSumVO;
import VO.PresentVO;
import VO.SaleVO;
import bl.utilitybl.ResultMessage;

/**     
* @author 李安迪
* @date 2017年11月9日
* @description ui和bl之间的接口
*/
public interface PresentBLService extends PresentForMembershipBLService, PresentForSpecialPackageBLService, PresentForSumBLService{
	public List<PresentVO> allStrategy();



	public List<PresentVO> getStrategy(SaleVO vo);



}
