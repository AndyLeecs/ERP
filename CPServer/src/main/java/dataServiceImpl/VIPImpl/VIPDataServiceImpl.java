package dataServiceImpl.VIPImpl;

import PO.GoodsPO;
import PO.VIPPO;
import dataHelper.*;
import dataService.VIPDataService.VIPDataService;
import util.ResultMessage;
import util.VIPUtil;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by julia98 on 2017/12/14.
 */
public class VIPDataServiceImpl extends UnicastRemoteObject implements VIPDataService {
    BasicUtil<VIPPO> util;
    CriterionClauseGenerator criterionClauseGenerator;

    public VIPDataServiceImpl() throws RemoteException{
        util = new HibernateUtil<VIPPO>(VIPPO.class);
        criterionClauseGenerator = new HibernateCriterionClauseGenerator();
    }

    /**
     * 前置条件	用户选择新建客户
     * 后置条件	系统显示客户电话和编号
     *
     * @return VIPB ID
     */
    @Override
    public String newVIPID() throws RemoteException{
        return ""+util.insertForAuto(new GoodsPO());
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
    public List findVIP(String info, String type) throws RemoteException {
        List<CriterionClause> l = new ArrayList<CriterionClause>();
        switch (type){
            case "name":
                criterionClauseGenerator.generateFuzzyCriterion(l,"name",type);
                criterionClauseGenerator.generateFuzzyCriterion(l,"state",VIPUtil.EXIST);
                break;
            case "phoneNumber":
                criterionClauseGenerator.generateFuzzyCriterion(l,"phoneNumber",type);
                criterionClauseGenerator.generateFuzzyCriterion(l,"state",VIPUtil.EXIST);
                break;
            case "id":
                criterionClauseGenerator.generateFuzzyCriterion(l,"id",type);
                criterionClauseGenerator.generateFuzzyCriterion(l,"state",VIPUtil.EXIST);
                break;
        }
        return util.Query(l);
    }

    /**
     * 前置条件	用户选择获取客户信息
     * 后置条件	系统显示客户信息
     *
     * @param name
     * @return
     */
    @Override
    public VIPPO getVIP(String name) throws RemoteException {
        List<CriterionClause> l = new ArrayList<CriterionClause>();
        criterionClauseGenerator.generateFuzzyCriterion(l,"name",name);
        criterionClauseGenerator.generateFuzzyCriterion(l,"state",VIPUtil.EXIST);
        return util.Query(l).get(0);
    }

    /**
     * 前置条件	用户选择删除客户
     * 后置条件	系统更新客户列表
     *
     * @param id
     * @return
     */
    @Override
    public ResultMessage deleteVIP(String id) throws RemoteException {
        List<CriterionClause> l = new ArrayList<CriterionClause>();
        criterionClauseGenerator.generateFuzzyCriterion(l,"id",id);
        util.Query(l).get(0).setState(VIPUtil.DELETE);
        return ResultMessage.SUCCESS;
    }

    /**
     * 前置条件	用户选择修改客户信息
     * 后置条件	系统更新客户信息
     *
     * @param po
     * @return
     */
    @Override
    public ResultMessage modifyVIP(VIPPO po) throws RemoteException{
        po.setState(VIPUtil.EXIST);
        util.update(po);
        return ResultMessage.SUCCESS;
    }

    /**
     * 前置条件	用户保存已初始化的客户信息
     * 后置条件	系统更新客户信息
     *
     * @param po
     * @return
     */
    @Override
    public ResultMessage initAndSaveVIP(VIPPO po) throws RemoteException{
        po.setState(VIPUtil.EXIST);
        util.insert(po);
        return ResultMessage.SUCCESS;
    }
}
