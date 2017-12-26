package bl.salebl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import VO.listVO.SalesDetailListVO;
import bl.listbl.GetSalesDetails;

public class GetSalesDetailsImpl implements GetSalesDetails{

	@Override
	public ArrayList<SalesDetailListVO> getSalesDetail() {
	     
		return null;
	}
//表单查看中得到销售明细表需要的操作
	
	/*
	 * 实现起来很简单，首先从数据库里把每一张销售单PO都拿出来
	 * 以单据中被卖掉的商品为单位构建上述PO
	 */
	
	/*
	 * 对于时间这个问题，我还是建议使用2017-12-26这种形式，大作业里要的是日期
	 *你觉得返回String不好就把VO里的时间这一项换成Data类吧
	 * 
		
	 */
	
}
