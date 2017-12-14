package bl.VIPbl;

import PO.VIPPO;
import VO.VIPVO.VIPVO;

/**
 * Created by julia98 on 2017/12/14.
 * 处理VIP的增删改查
 */
public class VIP {

    private VIPVO poToVO(VIPPO vipPO){
        return vipPO == null ? null : new VIPVO(vipPO.getName()
                ,vipPO.getPhoneNumber()
                ,vipPO.getEmail()
                ,vipPO.getAddress()
                ,vipPO.getLocationID());
    }

    private VIPPO voToPO(VIPVO vipVO){
        return vipVO == null ? null : new VIPPO(vipVO.getName()
                ,vipVO.getPhoneNumber()
                ,vipVO.getEmail()
                ,vipVO.getAddress()
                ,vipVO.getLocationID());
    }
}
