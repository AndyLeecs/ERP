package blservice.presentblservice;

import java.util.List;

import VO.PresentForSumVO;
import bl.utilitybl.ResultMessage;

/**     
* @author 李安迪
* @date 2017年11月9日
* @description
*/
public interface PresentForSumBLService {
	public List<PresentForSumVO> allPresentForSum();
	public ResultMessage addPresentForSum(PresentForSumVO vo);
	public ResultMessage deletePresentForSum(String id);
	public ResultMessage savePresentForSum(PresentForSumVO vo);
}
