package dataService.VIPDataService;
import PO.VIPPO;
import util.ResultMessage;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface VIPDataService extends Remote,Serializable{
    /**
     * 前置条件	用户选择新建客户
     * 后置条件	系统显示客户电话和编号
     * @return VIPBLServiceImpl ID
     */
    public String newVIPID();

    /**
     * 前置条件	用户输入信息模糊查找客户
     * 后置条件	系统显示模糊查找后符合要求的客户列表
     * @param info
     * @param type
     * @return
     */
    public ArrayList<VIPPO> findVIP(String info, String type);

    /**
     * 前置条件	用户选择获取客户信息
     * 后置条件	系统显示客户信息
     * @param id
     * @return
     */
    public VIPPO getVIP(String id);

    /**
     * 前置条件	用户选择删除客户
     * 后置条件	系统更新客户列表
     * @param id
     * @return
     */
    public ResultMessage deleteVIP(String id);

    /**
     * 前置条件	用户选择修改客户信息
     * 后置条件	系统更新客户信息
     * @param vo
     * @return
     */
    public ResultMessage modifyVIP(VIPPO vo);

    /**
     * 前置条件	用户保存已初始化的客户信息
     * 后置条件	系统更新客户信息
     * @param vo
     * @return
     */
    public ResultMessage initAndSaveVIP(VIPPO vo);

    /**
     * 前置条件	用户选择查看所有客户信息
     * 后置条件	系统显示所有客户信息
     * @return
     */
    public List<VIPPO> getVIPInfo();

}
