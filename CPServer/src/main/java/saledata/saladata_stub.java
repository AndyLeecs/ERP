package saledata;

import PO.SalesmanListPO;
import saledataservice.saledataservice_stub;

public class saladata_stub implements saledataservice_stub{

	public String insert(SalesmanListPO po) {
		// TODO Auto-generated method stub
		System.out.println("inserting succeed");
		return "success";
	}

	public String delete(SalesmanListPO po) {
		// TODO Auto-generated method stub
		System.out.println("deleting succeed");
		return "success";
	}

	public String update(SalesmanListPO po) {
		// TODO Auto-generated method stub
		System.out.println("updating succeed");
		return "success";
	}

	public String find(SalesmanListPO po) {
		// TODO Auto-generated method stub
		System.out.println("finding succeed");
		return "success";
	}

}
