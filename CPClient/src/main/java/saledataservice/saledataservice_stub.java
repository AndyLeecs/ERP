package saledataservice;

import PO.SaleListPO;

public interface saledataservice_stub {
	public String insert (SaleListVO po);
    public String delete (SaleListVO po);
    public String update (SaleListVO po);
    public String find (SaleListVO po);
}
