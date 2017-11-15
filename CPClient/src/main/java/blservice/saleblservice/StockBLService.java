package blservice.saleblservice;
import VO.storeVO.*;
import java.util.List;


import bl.utilitybl.ResultMessage;

/**     
* @author 李安迪
* @date 2017年11月9日
* @description
*/
public interface StockBLService {
	public String createStockList();
	public List<StockListVO> openStockDraftList();
	public ResultMessage commitStockList(StockListVO vo);
	public ResultMessage saveStockDraftList(StockListVO vo);
}
