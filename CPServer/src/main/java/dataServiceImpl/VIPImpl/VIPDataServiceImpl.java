package dataServiceImpl.VIPImpl;

import PO.VIPPO;
import dataService.VIPDataService.VIPDataService;
import util.ResultMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by julia98 on 2017/12/14.
 */
public class VIPDataServiceImpl implements VIPDataService {
    /**
     * 前置条件	用户选择新建客户
     * 后置条件	系统显示客户电话和编号
     *
     * @return VIPB ID
     */
    @Override
    public String newVIPID() {
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
    public ArrayList<VIPPO> findVIP(String info, String type) {
        return null;
    }

    /**
     * 前置条件	用户选择获取客户信息
     * 后置条件	系统显示客户信息
     *
     * @param id
     * @return
     */
    @Override
    public VIPPO getVIP(String id) {
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
    public ResultMessage modifyVIP(VIPPO vo) {
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
    public ResultMessage initAndSaveVIP(VIPPO vo) {
        return null;
    }

    /**
     * 前置条件	用户选择查看所有客户信息
     * 后置条件	系统显示所有客户信息
     *
     * @return
     */
    @Override
    public List<VIPPO> getVIPInfo() {
        return null;
    }
}
