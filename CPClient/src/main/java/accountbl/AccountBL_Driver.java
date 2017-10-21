package accountbl;
import accountbl.*;
import VO.*;

public class AccountBL_Driver {
	private static final GoodsVO testGoodsVO = new GoodsVO("台灯","一型","护眼灯","0","000001",250.0,500.0,250.0,500.0);
	private static final MemberVO testMemberVO = new MemberVO("000001","张三","00000","客户");
	String id = "000001";
	String tmp = "";
	AccountBL_Stub accountBL_Stub = new AccountBL_Stub();
	
	public void drive() {
		//1
		GoodsVO goodsVO = accountBL_Stub.getGoodsInfo(id);
	    if(goodsVO.equals(testGoodsVO))
	    	    System.out.println("Success!");
	    else
	    	System.out.println("Fail!");
	    
	    //2
	    MemberVO memberVO = accountBL_Stub.getMemberInfo(id);
	    if(goodsVO.equals(testMemberVO))
    	    System.out.println("Success!");
    else
    	System.out.println("Fail!");
	}

}
