package ui.managerUI;


/**     
* @author 李安迪
* @date 2017年12月14日
* @description 单个赠送策略需要实现的接口
*/
public interface SinglePresentController {
	void initialize();
	void save();
	boolean showConfirmDialog();
	void back();
//	void cancel();
	void search();
}
