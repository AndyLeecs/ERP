package saledataservice;

import PO.SalesmanListPO;

public interface saledataservice_stub {
	public String insert (SalesmanListPO po);
    public String delete (SalesmanListPO po);
    public String update (SalesmanListPO po);
    public String find (SalesmanListPO po);
}
