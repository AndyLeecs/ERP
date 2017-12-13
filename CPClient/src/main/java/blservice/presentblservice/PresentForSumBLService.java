package blservice.presentblservice;

import VO.presentVO.PresentForSumVO;
import util.ResultMessage;

/**     
* @author 李安迪
* @date 2017年12月12日
* @description
*/
public interface PresentForSumBLService {
	public ResultMessage addPresentForSum(PresentForSumVO vo);
	public ResultMessage deletePresentForSum(String id);
	public ResultMessage savePresentForSum(PresentForSumVO vo);
}
