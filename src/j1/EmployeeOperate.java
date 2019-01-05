package j1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeOperate {
	static Scanner sc = new Scanner(System.in);
	Run r = new Run();

	public void query(ArrayList<Employee> employees, String filename) throws IOException {
		System.out.println("------查询员工信息------");
		EmFileOperate.Reader(employees, "employees.txt");
		System.out.println("请输入你要查询的员工ID");
		String ID = sc.next();
		boolean a = false;
		for (int i = 0; i < employees.size(); i++) {
			Employee e = (Employee) employees.get(i);
			if (e.getID().equals(ID)) {
				System.out.println("员工号：" + e.getID() + "  年龄：" + e.getAge() + "  姓名：" + e.getName() + "  工作：" + e.getWork()+"   薪水："+e.getSalary());
				a = true;
			}
		}
		if (!a) {
			System.out.println("查无此人");
		}
		r.caozuo3();
	}

	public void update(ArrayList<Employee> employees, String filename) throws IOException {
		String newName, newID, newWork;
		int newAge,newSalary;
		
		EmFileOperate.Reader(employees, "employees.txt");
		System.out.println("输入你要修改的员工号：");
		Scanner sc = new Scanner(System.in);
		int index = -1;
		String upId = sc.nextLine();
		for (int i = 0; i < employees.size(); i++) {
			Employee e = employees.get(i);
			if (upId.equals(e.getID())) {
				index = i;
				break;
			}
		}
		if (index == -1)
			System.out.println("对不起，你所修改的员工信息不存在");
		else {
			System.out.println("请输入新的员工名字：");
			newName = sc.nextLine();
			System.out.println("请输入新的员工年龄：");
			newAge = sc.nextInt();
			System.out.println("请输入新的员工号：");
			newID = sc.nextLine();
			System.out.println("请输入新的员工工作：");
			newWork = sc.next();
			System.out.println("请输入新的员工薪水：");
			newSalary=sc.nextInt();

			Employee e = new Employee();
			e.setName(newName);
			e.setAge(newAge);
			e.setID(newID);
			e.setWork(newWork);
			e.setSalary(newSalary);
			employees.set(index, e);
			System.out.println("恭喜你，修改成功");
			EmFileOperate.Writer(employees, "employees.txt");
		}
		r.caozuo3();

	}

	public void delete(ArrayList<Employee> employees, String filename) throws IOException {
		EmFileOperate.Reader(employees, "employees.txt");
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入你要删除的员工的ID：");
		String deleteId = sc.nextLine();
		// boolean flag=false;
		int index = -1;
		for (int i = 0; i < employees.size(); i++) {
			Employee e= employees.get(i);
			if (e.getID().equals(deleteId)) {
				index = i;
				// flag=true;
				break;
			}
		}

		if (index != -1) {
			employees.remove(index);
			EmFileOperate.Writer(employees, "employees.txt");
			System.out.println("删除成功");
		} else
			System.out.println("没有你想要删除的员工，请重新输入：");

		r.caozuo3();

	}

	public void list(ArrayList<Employee> employees, String filename) throws IOException {
		EmFileOperate.Reader(employees, "employees.txt");
		if (employees.size() == 0)
			System.out.println("对不起，没有员工信息");
		else {
			for (int i = 0; i < employees.size(); i++) {

				Employee e = employees.get(i);
				System.out.println(
						"ID：" + e.getID() + "  年龄：" + e.getAge() + "  姓名：" + e.getName() + "  工作：" + e.getWork()+"   薪水："+e.getSalary());
			}
		}
		r.caozuo3();

	}

	public void add(ArrayList<Employee> employees, String filename) throws IOException {
		EmFileOperate.Reader(employees, "employees.txt");
		Scanner sc = new Scanner(System.in);
		String id;
		while (true) {
			System.out.println("请输入员工的ID：");
			id = sc.nextLine();
			boolean flag = true;
			for (int i = 0; i < employees.size(); i++) {
				Employee e = employees.get(i);
				if (id.equals(e.getID())) {
					flag = false;
					break;
				}
			}
			if (flag)
				break;
			else
				System.out.println("对不起，你输入的ID有误，请重新输入");
		}
		System.out.println("请输入员工的姓名：");
		String name = sc.nextLine();
		System.out.println("请输入员工的年龄：");
		int age = sc.nextInt();
		System.out.println("请输入员工的工作：");
		String work=sc.next();
		System.out.println("请输入员工的薪水：");
		int Salary=sc.nextInt();
		Employee e=new Employee();
		e.setName(name);
		e.setAge(age);
		e.setID(id);
		e.setWork(work);
		e.setSalary(Salary);
		employees.add(e);
		EmFileOperate.Writer(employees, "employees.txt");

		System.out.println("添加员工成功");

		r.caozuo3();

	}

	public void findByLike(ArrayList<Employee> employees, String filename) throws IOException {
		EmFileOperate.Reader(employees, "employees.txt");
		System.out.println("你所要查询的名字：");
		String name = sc.next();
		boolean a = false;
		for (int i = 0; i < employees.size(); i++) {
			Employee e = (Employee) employees.get(i);
			if (e.getName().contains(name)) {
				System.out.println("名字为：" + e.getName());
				a = true;
			}
		}
		if (!a) {
			System.out.println("查无此人");
		}
		r.caozuo3();
	}

}
