package blservice.listblservice;

import VO.listVO.BussinessSituationListVO;
import VO.listVO.InfoListVO;
import VO.listVO.SalesDetailListVO;
import VO.listVO.ListRM;
import util.GreatListType;
import util.ListType;

import java.util.List;

public interface Listblservice {
    /*
    *表单这个类大部分的职责都委托出去了,比如审批的实现，导出的实现。
    * 在计算的时候也需要使用销售、商品的方法。所以表单自己的层间API降低了很多
    * 王瑞华 161250143 2017年12月1日
     */
    public List<InfoListVO> openInfoList(ListType type);//经营历程表查看
    public SalesDetailListVO openSaleDetailList(); //销售明细表查看
    public BussinessSituationListVO openBussinessSituationList(); //经营情况表查看
    public ListRM toExcle (GreatListType type ,String id); // 表单导出
}
