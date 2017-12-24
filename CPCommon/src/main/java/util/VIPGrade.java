package util;

import java.io.Serializable;

/**     
* @author 李安迪
* @date 2017年10月26日
* @description 用户等级，分为5个等级
*/
/*<<<<<<< HEAD
public enum VIPGrade {
	ONE,TWO,THREE,FOUR,FIVE;
//=======*/
public enum VIPGrade implements Serializable{

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
//>>>>>>> 5cbce2e1e7b8c65f6d45b0d9724961e850fccd5a
}
