package dataservice.userdataservice;

import PO.UserPO;

public interface Userdataservice_stub {
      public String insert (UserPO po);
      public String delete (UserPO po);
      public String update (UserPO po);
      public String find (UserPO po);
}
