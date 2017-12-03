package bl.listbl;

import VO.listVO.BussinessSituationListVO;
import VO.listVO.InfoListVO;
import VO.listVO.SalesDetailListVO;
import VO.listVO.ListRM;
import blservice.listblservice.Listblservice;
import util.GreatListType;
import util.ListType;

import java.util.List;

public class ListblController implements Listblservice {
    /*
    * 表单类对上层的控制器，负责实现表单查看和导出功能
    * 表单类的部分逻辑是为其他包提供的，控制器不需要知道和调用这些逻辑。典型代表是过审批逻辑。
    * 表单审批和表单导出被委托出去了，所以其实现由其他包完成。这种做法是符合信息隐藏原则和职责分配原则的
    * 两张大的报表需要向其他包索要数据，建议其他包（销售、商品）写一个对应接口，直接把VO传输过来
    * 王瑞华 161250143  2017年12月1日
     */

    //单据红冲的接口还没加，但理论上应该是我来写

    @Override
    public List<InfoListVO> openInfoList(ListType type) {
        return null;
    }

    @Override
    public SalesDetailListVO openSaleDetailList() {
        return null;
    }

    @Override
    public BussinessSituationListVO openBussinessSituationList() {
        return null;
    }

    @Override
    public ListRM toExcle(GreatListType type, String id) {

        return ListRM.WRONG_LISTTYPE;
    }
}
