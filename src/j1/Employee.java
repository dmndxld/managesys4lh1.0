package j1;

public class Employee extends Person{
	private int salary;
	private String work;
	public Employee(String ID,String name,int age,int salary,String work){
		super.ID=ID;
		super.name=name;
		super.age=age;
		this.salary=salary;
		this.work=work;
	}
	public void display() {
		System.out.println("������"+name+" ����"+age+" нˮ"+salary+" ����"+work);
		
	}
}
