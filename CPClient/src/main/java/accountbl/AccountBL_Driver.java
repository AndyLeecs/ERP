package accountbl;

import java.util.*;
import VO.*;

public class AccountBL_Driver {
	private static final GoodsVO testGoodsVO = new GoodsVO("台灯","一型","护眼灯","0","000001",250.0,500.0,250.0,500.0);
	private static final MemberVO testMemberVO = new MemberVO("000001","张三","00000","客户");
	private static final InitAccountVO initAccountVO =  new InitAccountVO("张三","客户");
	private static AccountVO accountVO = new AccountVO();
	private static final PaymentListVO paymentListVO = new PaymentListVO();
	
	String id = "000001";
	String tmp = "";
	String name = "张三";
	String keyword = "灯";
	boolean a = false;
	 ListType type = new ListType();
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
	    
	    //3
	    a = accountBL_Stub.saveInitAccountInfo(initAccountVO);
	    if(a){
	    	System.out.println("Success!");
	    }else {
	    	System.out.println("Fail!");
	    }
	    
	    //4
	    a = accountBL_Stub.addAccount(accountVO);
	    if(a){
	    	System.out.println("Success!");
	    }else {
	    	System.out.println("Fail!");
	    }
	    
	    //5
	    a = accountBL_Stub.deleteAccount(name);
	    if(a){
	    	System.out.println("Success!");
	    }else {
	    	System.out.println("Fail!");
	    }
	    
	    //6
	    a = accountBL_Stub.saveAccount(name, accountVO);
	    if(a){
	    	System.out.println("Success!");
	    }else {
	    	System.out.println("Fail!");
	    }
	    
	    //7
	    ArrayList<String> list = accountBL_Stub.searchAccount(keyword);
	    if(list != null){
	    	System.out.println("Success!");
	    }else {
	    	System.out.println("Fail!");
	    }
	    
	    //8
	    ListInitVO listInitVO = accountBL_Stub.createList(type);
	    if(listInitVO != null){
	    	System.out.println("Success!");
	    }else {
	    	System.out.println("Fail!");
	    }
	    
	    //9
	    Map map = new HashMap();
	    map = accountBL_Stub.openDraftList();
	    if(map != null){
	    	System.out.println("Success!");
	    }else {
	    	System.out.println("Fail!");
	    }
	    
	    //10
	    Map map2 = new HashMap();
	    map = accountBL_Stub.openList(type, id);
	    if(map2 != null){
	    	System.out.println("Success!");
	    }else {
	    	System.out.println("Fail!");
	    }
	    
	    //11
	    a = accountBL_Stub.saveList(type, paymentListVO);
	    if(a){
	    	System.out.println("Success!");
	    }else {
	    	System.out.println("Fail!");
	    }
	    
	    //12
	    Map map3 = new HashMap();
	    map3 = accountBL_Stub.searchMember(id, name);
	    if(map3 != null){
	    	System.out.println("Success!");
	    }else {
	    	System.out.println("Fail!");
	    }
	    
	    //13
	    memberVO = accountBL_Stub.getMember(id);
	    if(memberVO != null){
	    	System.out.println("Success!");
	    }else {
	    	System.out.println("Fail!");
	    }
	    
	    //14
	    accountVO = accountBL_Stub.getAccount(name);
	    if(accountVO != null){
	    	System.out.println("Success!");
	    }else {
	    	System.out.println("Fail!");
	    }
	    
	    //15
	    a = accountBL_Stub.commitList(this.type, paymentListVO);
	    if(a){
	    	System.out.println("Success!");
	    }else {
	    	System.out.println("Fail!");
	    }
	    
	}

}
