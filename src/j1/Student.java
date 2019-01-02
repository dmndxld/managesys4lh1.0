package j1;

public class Student extends Person {
	private double grade;
	public Student(String ID,String name,int age,double grade){
		super.ID=ID;
		super.name=name;
		super.age=age;
		this.grade=grade;
	}
	
	public void display() {
		System.out.println("ĞÕÃû£º"+name+" ÄêÁä"+age+" ³É¼¨"+grade);
		
	}

}
