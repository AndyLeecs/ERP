package bl.salebl;

import java.util.List;

import PO.SaleListPO;
import PO.SaleReturnListPO;
import PO.SalesmanItemPO;
import PO.SalesmanListPO;
import PO.StockListPO;
import PO.StockReturnListPO;
import VO.saleVO.SaleListVO;
import VO.saleVO.SaleReturnListVO;
import VO.saleVO.SalesmanItemVO;
import VO.saleVO.SalesmanListVO;
import VO.saleVO.StockListVO;
import VO.saleVO.StockReturnListVO;
import bl.listbl.SalesBussinessSituation;
import blservice.saleblservice.SaleUniBLService;
import dataService.saleDataService.SaleUniDataService;
import network.saleRemoteHelper.SaleReturnListDataServiceHelper;
import network.saleRemoteHelper.StockReturnListDataServiceHelper;
import util.DataRM;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description
*/
public class StockReturnListBLServiceImpl extends SaleUniBLServiceImpl
{
	SaleUniDataService service = StockReturnListDataServiceHelper.getInstance().getStockReturnListDataService();

	@Override
	public SalesmanListPO voToPo(SalesmanListVO vo) {
		// TODO Auto-generated method stub
		StockReturnListVO svo = (StockReturnListVO)vo;
		List<SalesmanItemPO> polist = generatePoList(svo);
		return new StockReturnListPO(svo.getId(),svo.getState(),svo.getDay(),svo.getMemberID(),svo.getMemberName(),svo.getOperator(),svo.getRealOperator(),svo.getWarehouse(),svo.getNotes(),polist,svo.getSum());
	}





	/* (non-Javadoc)
	 * @see bl.salebl.SaleUniBLServiceImpl#poToVo(PO.SalesmanListPO)
	 */
	@Override
	public SalesmanListVO poToVo(SalesmanListPO po) {
		// TODO Auto-generated method stub
		StockReturnListPO spo = (StockReturnListPO)po;
		List<SalesmanItemVO> volist = generateVoList(po);
		//留了一个空项，看以后是存操作员的id还是名称
		return new StockReturnListVO(spo.getId(), spo.getOperator(), null, spo.getState(), spo.getDay(),spo.getMemberID(), spo.getMemberName(),spo.getRealOperator(), spo.getWarehouse(), spo.getNotes(), volist, spo.getSum());
	}


}
