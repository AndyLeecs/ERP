package ui.salesmanUI;

import java.util.List;

import VO.saleVO.SalesmanListVO;
import blservice.saleblservice.SaleUniBLService;
import ui.commonUI.ParentController;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description 销售类单据和库存类单据的草稿单查看界面的父类
*/
public abstract class ListViewController {
	ParentController controller;
	SaleUniBLService service;
	List<SalesmanListVO> list;

	public ListViewController(ParentController controller, SaleUniBLService service, List<SalesmanListVO> list) {
		super();
		this.controller = controller;
		this.service = service;
		this.list = list;
	}
}
