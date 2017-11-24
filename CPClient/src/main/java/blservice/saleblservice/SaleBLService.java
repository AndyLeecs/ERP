package blservice.saleblservice;

import java.util.List;

import VO.VIPVO.VIPVO;
import VO.goodsVO.GoodsVO;
import VO.presentVO.PresentResultVO;
import VO.saleVO.SaleListVO;
import VO.saleVO.SaleReturnListVO;
import VO.saleVO.SaleVO;
import VO.saleVO.SalesmanListType;
import VO.saleVO.SalesmanListVO;
import VO.storeVO.StockListVO;
import VO.storeVO.StockReturnListVO;
import bl.utilitybl.ResultMessage;

public interface SaleBLService{
	public List<GoodsVO> findGoods(String info);
	
	public List<VIPVO> findVIP(String info,SalesmanListType type);
	
	public List<SalesmanListVO> openDraftList();
	public List<SalesmanListVO> openCommitted();
	
	public String createSaleList();
	public List<SaleListVO> openSaleDraftList();
	public ResultMessage saveSaleDraftList(SaleListVO vo);
	public ResultMessage commitSaleList(SaleListVO vo);
	public PresentResultVO findPresent(SaleVO vo);
	
	public String createSaleReturnList();
	public List<SaleReturnListVO> openSaleReturnDraftList();
	public ResultMessage saveSaleReturnDraftList(SaleReturnListVO vo);
	public ResultMessage commitSaleReturnList(SaleReturnListVO vo);
	
	public String createStockList();
	public List<StockListVO> openStockDraftList();
	public ResultMessage commitStockList(StockListVO vo);
	public ResultMessage saveStockDraftList(StockListVO vo);
	
	public String createStockReturnList();
	public List<StockReturnListVO> openStockReturnDraftList();
	public ResultMessage saveStockReturnDraftList(StockReturnListVO vo);
	public ResultMessage commitStockReturnList(StockReturnListVO vo);

	
	
	
}
