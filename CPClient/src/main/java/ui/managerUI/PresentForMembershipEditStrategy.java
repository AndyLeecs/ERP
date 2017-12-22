package ui.managerUI;

import VO.presentVO.PresentVO;
import util.DataRM;

/**     
* @author 李安迪
* @date 2017年12月15日
* @description
*/
public class PresentForMembershipEditStrategy implements Strategy{

	/* (non-Javadoc)
	 * @see ui.managerUI.Strategy#initData(ui.managerUI.SinglePresentController, VO.presentVO.PresentVO)
	 */
	@Override
	public void initData(SinglePresentController controller, PresentVO vo) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see ui.managerUI.Strategy#cancel(ui.managerUI.SinglePresentController)
	 */
	@Override
	public DataRM cancel(SinglePresentEditableController controller) {
		// TODO Auto-generated method stub
		return null;
	}

}
