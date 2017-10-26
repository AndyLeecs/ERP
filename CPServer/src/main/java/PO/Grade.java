package PO;


/**     
* @author 李安迪
* @date 2017年10月26日
* @description 用户等级，分为5个等级
*/
public enum Grade {

	GradeOne(1),
	GradeTwo(2),
	GradeThree(3),
	GradeFour(4),
	GradeFive(5);
	
	private final int grade;
	
	private Grade(int grade){
		this.grade = grade;
	}
	
	public int getName(){
		return this.grade;
	}
}
