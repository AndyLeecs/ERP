package blservice.presentblservice;

import VO.PresentResultVO;
import VO.SaleVO;

/**     
* @author 李安迪
* @date 2017年11月9日
* @description present提供给sales的接口
*/
public interface PresentBLInfo {
	public PresentResultVO findPresent(SaleVO vo);
}
