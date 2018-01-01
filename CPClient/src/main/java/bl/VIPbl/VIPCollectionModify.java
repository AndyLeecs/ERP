package bl.VIPbl;

import resultmessage.ResultMessage;

import java.rmi.RemoteException;

/**
 * Created by julia98 on 2018/1/1.
 * 给其他包使用的 修改会员应收应付的接口
 */
public interface VIPCollectionModify {
    public ResultMessage setVIPCollection(String vipName,double collection) throws RemoteException;
    public ResultMessage setVIPPayment(String vipName,double payment) throws RemoteException;
}
