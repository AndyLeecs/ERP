package blservice.presentblservice;

import VO.presentVO.PresentForSpecialPackageVO;
import util.ResultMessage;

/**     
* @author 李安迪
* @date 2017年12月12日
* @description
*/
public interface PresentForSpecialPackageBLService {
	public ResultMessage addPresentForSpecialPackage(PresentForSpecialPackageVO vo);
	public ResultMessage deletePresentForSpecialPackage(String id);
	public ResultMessage savePresentForSpecialPackage(PresentForSpecialPackageVO vo);
}
