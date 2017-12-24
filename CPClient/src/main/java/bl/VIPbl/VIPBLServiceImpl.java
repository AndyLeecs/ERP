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

    VIPVO vipvo1 = new VIPVO("00000001"
            ,"分类1"
            ,"级别1"
            ,"姓名1"
            ,"18800000000"
            ,"123456789@qq.com"
            ,"地址1"
            ,"210046"
            ,100
            ,1000
            ,100
            ,"业务员1");

    VIPVO vipvo2 = new VIPVO("00000002"
            ,"分类2"
            ,"级别2"
            ,"姓名2"
            ,"18800000001"
            ,"223456789@qq.com"
            ,"地址2"
            ,"210046"
            ,200
            ,2000
            ,200
            ,"业务员1");
    /**
     * 前置条件	用户选择新建客户
     * 后置条件	系统显示客户电话和编号
     *
     * @return VIPBLServiceImpl ID
     */
    @Override
    public String newVIPID() {
        return null;
    }

    @Override
    public VIPVO getVIP(String name) {
        return vipvo1;
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
        ArrayList<VIPVO> vipvos = new ArrayList<>();
        vipvos.add(vipvo1);
        vipvos.add(vipvo2);
        return vipvos;
    }

    /**
     * 前置条件	用户选择删除客户
     * 后置条件	系统更新客户列表
     *
     * @param name
     * @return
     */
    @Override
    public ResultMessage deleteVIP(String name) {
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
