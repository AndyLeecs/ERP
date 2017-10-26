package VO;


/**     
* @author 李安迪
* @date 2017年10月26日
* @description 用户等级，分为5个等级
*/
public enum Grade {

	GradeOne("普通用户"),
	GradeTwo("二级用户"),
	GradeThree("三级用户"),
	GradeFour("四级用户"),
	GradeFive("VIP用户");
	
	private final String name;
	
	private Grade(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
}
