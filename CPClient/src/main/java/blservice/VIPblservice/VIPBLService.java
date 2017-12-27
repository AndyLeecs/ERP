package blservice.VIPblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import VO.VIPVO.VIPVO;
import util.ResultMessage;

/**
 * 
 * @author julia98
 * 
 */
public interface VIPBLService {
	/**
	 * 前置条件	用户选择新建客户
     * 后置条件	系统显示客户编号
	 * @return VIP ID
	 */
	public String newVIPID() throws RemoteException;

    /**
     * 前置条件	用户选择获取客户信息
     * 后置条件	系统显示客户信息
     * @param name
     * @return
     */
	public VIPVO getVIP(String name) throws RemoteException;

	/**
	 * 前置条件	用户输入信息模糊查找客户
	 * 后置条件	系统显示模糊查找后符合要求的客户列表
	 * @param info
	 * @param type
	 * @return
	 */
	public List findVIP(String info,String type) throws RemoteException;

	/**
	 * 前置条件	用户选择删除客户
	 * 后置条件	系统更新客户列表
	 * @param name
	 * @return
	 */
	public ResultMessage deleteVIP(String name) throws RemoteException;
	
	/**
	 * 前置条件	用户选择修改客户信息
	 * 后置条件	系统更新客户信息
	 * @param vo
	 * @return
	 */
	public ResultMessage modifyVIP(VIPVO vo) throws RemoteException;
	
	/**
	 * 前置条件	用户保存已初始化的客户信息
	 * 后置条件	系统更新客户信息
	 * @param vo
	 * @return
	 */
	public ResultMessage initAndSaveVIP(VIPVO vo) throws RemoteException;
	
}
