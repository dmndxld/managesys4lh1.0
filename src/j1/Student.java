package j1;

public class Student extends Person {
	private double grade;
	
    public Student() {}
	//学生构造方法
	public Student(String ID, String name, int age, double grade) {
		super.setID(ID);
		super.setName(name);
		super.setAge(age);
		this.grade = grade;
	}
    //学生信息展示
	public void display() {
		System.out.println("姓名：" + getName() + " 年龄" + getAge() + " 成绩" + grade);

	}
	public void setGrade(double grade2) {
		// TODO Auto-generated method stub
		this.grade=grade2;
	}
	public double  getGrade() {
		// TODO Auto-generated method stub
		return grade;
	}

	

}
