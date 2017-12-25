package bl.VIPbl;

import VO.VIPVO.VIPVO;
import blservice.VIPblservice.VIPBLService;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by julia98 on 2017/12/26.
 */
public class VIPFuzzySearchImpl implements VIPFuzzySearch{

    VIPBLService vipblService = new VIPBLServiceImpl();
    /**
     * 以会员ID模糊查找
     *
     * @param idInfo
     * @return 符合条件的会员列表
     */
    @Override
    public List<VIPVO> getVIPInID(String idInfo) throws RemoteException {
        return vipblService.findVIP(idInfo,"id");
    }

    /**
     * 以会员姓名模糊查找
     *
     * @param nameInfo
     * @return 符合条件的会员列表
     */
    @Override
    public List<VIPVO> getVIPInName(String nameInfo) throws RemoteException {
        return vipblService.findVIP(nameInfo,"name");
    }

    /**
     * 以会员电话模糊查找
     *
     * @param phoneNumberInfo
     * @return 符合条件的会员列表
     */
    @Override
    public List<VIPVO> getVIPInPhoneNumber(String phoneNumberInfo) throws RemoteException {
        return vipblService.findVIP(phoneNumberInfo,"phoneNumber");
    }
}
