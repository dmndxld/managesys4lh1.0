package j1;

public class Employee extends Person {
	private int salary;
	private String work;

	public Employee(String ID, String name, int age, int salary, String work) {
		super.setID(ID);
		super.setName(name);
		super.setAge(age);
		this.salary = salary;
		this.work = work;
	}

	public void display() {
		System.out.println("姓名：" + getName() + " 年龄" + getAge() + " 薪水" + salary + " 工作" + work);

	}

	public void setSalary(int salary) {
		// TODO Auto-generated method stub
		this.salary=salary;
	}
	public void setWork(String work) {
		this.work=work;
	}

	public int getSalary() {
		// TODO Auto-generated method stub
		return salary;
	}
	public String getWork() {
		return work;
	}
}
