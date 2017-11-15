package blservice.saleblservice;

import java.util.List;

import VO.storeVO.*;
import bl.utilitybl.ResultMessage;

/**     
* @author 李安迪
* @date 2017年11月9日
* @description
*/
public interface StockReturnBLService {
	public String createStockReturnList();
	public List<StockReturnListVO> openStockReturnDraftList();
	
	

	public ResultMessage saveStockReturnDraftList(StockReturnListVO vo);
	
	
	
	public ResultMessage commitStockReturnList(StockReturnListVO vo);
}
