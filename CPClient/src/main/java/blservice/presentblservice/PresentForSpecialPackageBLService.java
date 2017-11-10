package blservice.presentblservice;

import java.util.List;

import VO.PresentForSpecialPackageVO;
import bl.utilitybl.ResultMessage;

/**     
* @author 李安迪
* @date 2017年11月9日
* @description
*/
public interface PresentForSpecialPackageBLService {
	public List<PresentForSpecialPackageVO> allPresentForSpecialPackage();
	public ResultMessage addPresentForSpecialPackage(PresentForSpecialPackageVO vo);


	public ResultMessage deletePresentForSpecialPackage(String id);

	public ResultMessage savePresentForSpecialPackage(PresentForSpecialPackageVO vo);
	
}
