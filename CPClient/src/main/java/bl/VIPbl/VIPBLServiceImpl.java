package bl.VIPbl;

import VO.VIPVO.VIPVO;
import blservice.VIPblservice.VIPBLService;
import network.VIPRemoteHelper.VIPDataServiceHelper;
import util.ResultMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by julia98 on 2017/12/13.
 */
public class VIPBLServiceImpl implements VIPBLService {
    VIPDataServiceHelper vipDataServiceHelper;

    /**
     * 前置条件	用户选择新建客户
     * 后置条件	系统显示客户电话和编号
     *
     * @param telephone
     * @return VIPBLServiceImpl ID
     */
    @Override
    public String newVIP(String telephone) {
        return null;
    }

    @Override
    public VIPVO getVIP(String id) {
        return null;
    }

    /**
     * 前置条件	用户输入信息模糊查找客户
     * 后置条件	系统显示模糊查找后符合要求的客户列表
     *
     * @param info
     * @param type
     * @return
     */
    @Override
    public ArrayList<VIPVO> findVIP(String info, String type) {
        return null;
    }

    /**
     * 前置条件	用户选择删除客户
     * 后置条件	系统更新客户列表
     *
     * @param id
     * @return
     */
    @Override
    public ResultMessage deleteVIP(String id) {
        return null;
    }

    /**
     * 前置条件	用户选择修改客户信息
     * 后置条件	系统更新客户信息
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage modifyVIP(VIPVO vo) {
        return null;
    }

    /**
     * 前置条件	用户保存已初始化的客户信息
     * 后置条件	系统更新客户信息
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage initAndSaveVIP(VIPVO vo) {
        return null;
    }

    /**
     * 前置条件	用户选择查看所有客户信息
     * 后置条件	系统显示所有客户信息
     *
     * @return
     */
    @Override
    public List<VIPVO> getVIPInfo() {
        return null;
    }
}
