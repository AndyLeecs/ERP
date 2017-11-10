package blservice.saleblservice;

import java.util.List;

import VO.SaleReturnListVO;
import bl.utilitybl.ResultMessage;

/**     
* @author 李安迪
* @date 2017年11月9日
* @description
*/
public interface SaleReturnListBLService {
	public String createSaleReturnList();
	public List<SaleReturnListVO> openSaleReturnDraftList();
	public ResultMessage saveSaleReturnDraftList(SaleReturnListVO vo);
	public ResultMessage commitSaleReturnList(SaleReturnListVO vo);
	
}
