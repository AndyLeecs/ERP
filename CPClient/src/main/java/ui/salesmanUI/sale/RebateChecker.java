package ui.salesmanUI.sale;

import util.UserGrade;

/**     
* @author 李安迪
* @date 2018年1月3日
* @description 检查销售单的折让额度
*/
public class RebateChecker {
	public static double getRebateLimit(UserGrade grade){
		switch(grade){
		case General:
			return 1000;
		case Manager:
			return 5000;
		}
		return 0;
	}
}
