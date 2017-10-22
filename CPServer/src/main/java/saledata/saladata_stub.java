package saledata;

import PO.SaleListPO;
import saledataservice.saledataservice_stub;

public class saladata_stub implements saledataservice_stub{

	public String insert(SaleListPO po) {
		// TODO Auto-generated method stub
		System.out.println("inserting succeed");
		return "success";
	}

	public String delete(SaleListPO po) {
		// TODO Auto-generated method stub
		System.out.println("deleting succeed");
		return "success";
	}

	public String update(SaleListPO po) {
		// TODO Auto-generated method stub
		System.out.println("updating succeed");
		return "success";
	}

	public String find(SaleListPO po) {
		// TODO Auto-generated method stub
		System.out.println("finding succeed");
		return "success";
	}

}
