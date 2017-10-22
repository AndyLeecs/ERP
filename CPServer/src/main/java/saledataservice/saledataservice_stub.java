package saledataservice;

import PO.SaleListPO;

public interface saledataservice_stub {
	public String insert (SaleListPO po);
    public String delete (SaleListPO po);
    public String update (SaleListPO po);
    public String find (SaleListPO po);
}
