package bl.presentbl;

import java.util.List;

import VO.presentVO.PresentForMembershipVO;
import VO.presentVO.PresentResultVO;
import VO.saleVO.SaleVO;
import util.VIPGrade;

/**     
* @author 李安迪
* @date 2017年12月25日
* @description
*/
public class PresentForMembershipHandler {

	PresentForMembershipBLServiceImpl impl = new PresentForMembershipBLServiceImpl();
	/**
	 * @param grade
	 * @param result
	 * @return
	 */
	public PresentResultVO handle(VIPGrade grade, PresentResultVO result) {
		// TODO Auto-generated method stub
		List<PresentForMembershipVO> list = impl.getWithMinMembership(grade);
		if(list != null && ! list.isEmpty()){
		PresentForMembershipVO newPresent = list.get(0);
		int id = newPresent.getId();
		result.getPresentId().add(id);
		result.getPresentList().addAll(newPresent.getPresentList());
		double rebate = newPresent.getRebateInPresentForMembership();
		if(result.getSum() - rebate > 0)
		result.setSum(result.getSum() - rebate);
		double voucher = newPresent.getVoucher()+result.getVoucher();
		result.setVoucher(voucher);
		}
		
		return result;
	}


}
