package bl.salebl;

import PO.SaleListPO;
import dataservice.saledataservice.*;
public class salebl_driver {
	SaleListVO po=new SaleListVO();
	saledataservice_stub sd;
     public void datadriver(){
    	 sd.insert(po);
    	 sd.update(po);
    	 sd.find(po);
    	 sd.delete(po);
    	 
     }
}
