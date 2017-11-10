package blservice.saleblservice;

import java.util.List;

import VO.GoodsVO;
import VO.ListVO;
import VO.PresentResultVO;
import VO.SaleListVO;
import VO.SaleReturnListVO;
import VO.SaleVO;
import VO.StockListVO;
import VO.StockReturnListVO;
import VO.VIPVO;
import bl.utilitybl.ResultMessage;

public interface SaleBLService extends SaleListBLService, SaleReturnListBLService, StockBLService, StockReturnBLService{

	
	

	public List<ListVO> openDraftList();
	
	


	public List<VIPVO> findVIP(String info, String type);
	public List<GoodsVO> findGoods(String info, String type);
	
}
