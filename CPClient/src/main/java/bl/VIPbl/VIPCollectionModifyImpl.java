package bl.VIPbl;

import VO.VIPVO.VIPVO;
import blservice.VIPblservice.VIPBLService;
import blservice.VIPblservice.VIPCollectionModify;
import resultmessage.ResultMessage;

import java.rmi.RemoteException;

/**
 * Created by julia98 on 2018/1/1.
 */
public class VIPCollectionModifyImpl implements VIPCollectionModify {
    VIPBLService vipblService = new VIPBLServiceImpl();

    @Override
    public ResultMessage setVIPCollection(String vipName, double collection) throws RemoteException {
        VIPVO vipvo = vipblService.getVIP(vipName);
        vipvo.setCollection(collection);
        vipblService.modifyVIP(vipvo);
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage setVIPPayment(String vipName, double payment) throws RemoteException {
        VIPVO vipvo = vipblService.getVIP(vipName);
        vipvo.setPayment(payment);
        vipblService.modifyVIP(vipvo);
        return ResultMessage.SUCCESS;
    }
}
