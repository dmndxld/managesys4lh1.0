package j1;

public class Student extends Person {
	private double grade;
	
    public Student() {}
	//ѧ�����췽��
	public Student(String ID, String name, int age, double grade) {
		super.setID(ID);
		super.setName(name);
		super.setAge(age);
		this.grade = grade;
	}
    //ѧ����Ϣչʾ
	public void display() {
		System.out.println("������" + getName() + " ����" + getAge() + " �ɼ�" + grade);

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
