package listbl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import VO.BusinessCircumVO;
import VO.BusinessProcessConditionVO;
import VO.ListType;
import VO.ListVO;
import VO.SaleDetailConditionVO;

public class ListBL_Stub implements ListBL{
	ListVO listVO = new ListVO();

	public ArrayList<String> checkList() {
		// TODO Auto-generated method stub
		return listVO.checkList();
	}

	public ArrayList checkSaleDetailForm(SaleDetailConditionVO vo) {
		// TODO Auto-generated method stub
		return vo.checkSaleDetailForm();
	}


	public ListVO getSpecificList(ListType type, String id) {
		// TODO Auto-generated method stub
		return listVO.getSpecificList(type, id);
	}

	public void hongchong(ListType type, String id) {
		// TODO Auto-generated method stub
		listVO.hongchong(type, id);	
	}

	public String hongchongAndCopy(ListType type, String id) {
		// TODO Auto-generated method stub
		return listVO.hongchongAndCopy(type, id);
	}

	public BusinessCircumVO checkBusinessCircumForm(Date begainTime, Date EndTime) {
		// TODO Auto-generated method stub
		BusinessCircumVO businessCircumVO = new BusinessCircumVO();
		return businessCircumVO.checkBusinessCircumForm();
	}

	public void approvalList(ListType type, String ID, ListVO vo) {
		// TODO Auto-generated method stub
		listVO.approvalList(type, ID, vo);
	}

	public ArrayList checkBusinessProcessForm(BusinessProcessConditionVO vo) {
		// TODO Auto-generated method stub
		return vo.checkBusinessProcessForm();
	}

}
