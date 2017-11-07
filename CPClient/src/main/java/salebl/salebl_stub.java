package salebl;

import java.util.Map;

import VO.GoodsVO;
import VO.ListInitVO;
import VO.ListType;
import VO.VIPVO;
import VO.SaleListVO;
import VO.SalePresentVO;
import saleblservice.saleblservice_stub;

public class salebl_stub implements saleblservice_stub{

	public ListInitVO createList(ListType type) {
		// TODO Auto-generated method stub
		ListInitVO vo = null;
		return vo;
	}

	public Map<ListType, String> openDraftList() {
		// TODO Auto-generated method stub
		return null;
	}

	public SaleListVO openList(ListType t, String id) {
		// TODO Auto-generated method stub
		SaleListVO vo = null;
	
		return vo;
	}

	public void saveList(ListType type, SaleListVO vo) {
		// TODO Auto-generated method stub
		System.out.println("invoking succeed"+"- saveList");
		
	}

	public void commitList(ListType type, SaleListVO vo) {
		// TODO Auto-generated method stub
		System.out.println("invoking succeed"+"- commitList");
	}

	public Map<String, String> searchMember(int id, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public VIPVO getMember(int id) {
		// TODO Auto-generated method stub
		VIPVO mv=new VIPVO("161250143", "wangruihua", "123456", "chairman");
		return mv;
	}

	public Map<String, String> findGoods(String id, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public GoodsVO getGoods(String id) {
		// TODO Auto-generated method stub
		GoodsVO gv=new GoodsVO("小灯","X系列灯具","1","1","1",20,50,100,80);
		return gv;
	}

	public SalePresentVO getPresent(SaleListVO vo) {
		// TODO Auto-generated method stub
		SalePresentVO sv=null;
		return sv;
	}

	public double getTotal(ListType type, SaleListVO vo) {
		// TODO Auto-generated method stub
		return -1;
	}

	
}
