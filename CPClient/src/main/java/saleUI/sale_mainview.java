package saleUI;
import VO.*;
import saleblservice.saleblservice_stub;
public class sale_mainview {
	saleblservice_stub sb;
   public void sale_driver(){
	   ListType lt=null;
	   sb.commitList(null, null);
	   sb.createList( lt);
	   
   }
}
