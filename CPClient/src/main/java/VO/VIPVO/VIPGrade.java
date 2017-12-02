package VO.VIPVO;


/**     
* @author 李安迪
* @date 2017年10月26日
* @description 用户等级，分为5个等级
*/
public enum VIPGrade {

	GradeOne(1),
	GradeTwo(2),
	GradeThree(3),
	GradeFour(4),
	GradeFive(5);
	
	private final int grade;
	
	VIPGrade(int grade){
		this.grade = grade;
	}
	
	public int getGrade(){
		return this.grade;
	}
}
