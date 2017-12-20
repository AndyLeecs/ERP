package bl.VIPbl;

import VO.VIPVO.VIPVO;

import java.util.List;

/**
 * Created by julia98 on 2017/12/14.
 * 模糊查询会员的包间接口 供其他包调用
 */
public interface VIPFuzzySearch {

    /**
     * 以会员ID模糊查找
     * @param idInfo
     * @return 符合条件的会员列表
     */
    public List<VIPVO> getVIPInID(String idInfo);

    /**
     * 以会员姓名模糊查找
     * @param nameInfo
     * @return 符合条件的会员列表
     */
    public List<VIPVO> getVIPInName(String nameInfo);

    /**
     * 以会员电话模糊查找
     * @param phoneNumberInfo
     * @return 符合条件的会员列表
     */
    public List<VIPVO> getVIPInPhoneNumber(String phoneNumberInfo);
}