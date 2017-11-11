package userdataservice;
import PO.*;
import userdata.*;
public class userdata_driver {
       public void userdatadriver(){
    	   UserPO p=new UserPO();
    	   userdata_stub us = new userdata_stub ();
    	   us.insert(p);
    	   us.find(p);
    	   us.update(p);
    	   us.delete(p);
       }
}
