package blservice.saleblservice;

import java.util.List;

import VO.PresentResultVO;
import VO.SaleListVO;
import VO.SaleVO;
import bl.utilitybl.ResultMessage;

/**     
* @author 李安迪
* @date 2017年11月9日
* @description
*/
public interface SaleListBLService {
	public String createSaleList();
	public List<SaleListVO> openSaleDraftList();
	public ResultMessage saveSaleDraftList(SaleListVO vo);
	public ResultMessage commitSaleList(SaleListVO vo);
	
	public PresentResultVO findPresent(SaleVO vo);
}
