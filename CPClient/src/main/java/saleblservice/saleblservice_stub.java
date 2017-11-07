package saleblservice;

import java.util.Map;

import VO.GoodsVO;
import VO.ListInitVO;
import VO.ListType;
import VO.VIPVO;
import VO.SaleListVO;
import VO.SalePresentVO;

public interface saleblservice_stub {
	public ListInitVO createList(ListType type);
	public Map<ListType, String> openDraftList();
	public SaleListVO openList(ListType t, String id);
	public void saveList(ListType type, SaleListVO vo);
	public void commitList(ListType type, SaleListVO vo);
	public Map<String,String> searchMember(int id, String name);
	public VIPVO getMember(int id);
	public Map<String,String> findGoods(String id, String name)	;
	public GoodsVO getGoods(String id);
	public SalePresentVO getPresent(SaleListVO vo);
	public double getTotal(ListType type, SaleListVO vo);
}
