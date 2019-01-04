package j1;

import java.util.Scanner;

public class EmployeeOperate implements PersonOperate {
	static Scanner sc = new Scanner(System.in);
	Run r=new Run();
	public void update() {
		System.out.println("------修改员工------");
		System.out.println("请输入你要修改的员工ID");
		boolean isok = false;
		Employee e;
		do {
			String str = r.getValidString();
			isok = r.emis.CheckExitByID(str);
			if (isok == true) {
				isok = true;
				e = r.emis.getEmployeeByID(str);
				e.display();
				System.out.println("请输入名字：");
				String name = sc.next();
				System.out.println("请输入年龄：");
				int age = sc.nextInt();
				System.out.println("请输入薪水：");
				int salary = sc.nextInt();
				System.out.println("请输入薪水：");
				String work = sc.next();
				e.setName(name);
				e.setAge(age);
				e.setSalary(salary);
				e.setWork(work);
				e.display();
			} else {
				System.out.println("查无此人请重新输入");
			}
		} while (!isok);
		r.caozuo3();

	}

	public  void delete() {
		System.out.println("------删除员工------");

		String ID;
		boolean isok = false;
		System.out.println("请输入你要删除的员工ID");
		do {
			ID = r.getValidString();
			isok = r.emis.CheckExitByID(ID);
			if (isok == true) {
				System.out.println("ID查找成功");
				r.eminformationList.remove(r.emis.getPersonByID(ID));

			} else {
				System.out.println("输入信息有误，请重新输入");
			}
		} while (!isok);
		System.out.println("删除成功");
		r.caozuo3();

	}

	public  void query() {
		System.out.println("------查询员工信息------");
		System.out.println("请输入你要查询的员工ID");

		Student e;
		boolean isok = false;
		do {
			String str = r.getValidString();
			boolean strisok = r.emis.CheckExitByID(str);
			if (strisok == true) {
				e = r.emis.getStudentByID(str);
				e.display();
				isok = true;

			} else {
				System.out.println("查无此人请重新输入");
			}
		} while (!isok);
		r.caozuo3();

	}



	public void add() {
		System.out.println("------增加员工------");
		boolean isok = false;
		String ID = null;
		do {
			System.out.println("请输入ID（且不能出现重复)");
			ID = sc.next();
			if (r.emis.getEmployeeByID(ID) == null) {
				isok = true;
			} else {
				System.out.println("该人信息已存在，请重新输入");
				add();
			}
		} while (!isok);
		System.out.println("请输入其他信息。。。");
		System.out.println("姓名：");
		String name = r.getValidString();
		System.out.println("年龄：");
		int age = r.getValidAge();
		System.out.println("薪水：");
		int salary = sc.nextInt();
		System.out.println("工作");
		String work = r.getValidString();
		r.emis.saveEmployee(new Employee(ID, name, age, salary, work));
		r.caozuo3();

	}

	public void list() {
		System.out.println("------所有员工信息------");
		for (int i = 0; i < r.eminformationList.size(); i++) {
			Employee e = (Employee) r.eminformationList.get(i);
			System.out.println("ID" + "\t" + e.getID() + "\t" + "Name" + "\t" + e.getName() + "\t" + "age" + "\t"
					+ e.getAge() + "\t" + "salary" + "\t" + e.getSalary() + "\t" + "work" + "\t" + e.getWork());
		}
		r.caozuo3();

	}
	public void findByLike() {
		System.out.println("你所要查询的名字：");
		String name=sc.next();
		boolean a=false;
		for (int i = 0; i < r.eminformationList.size(); i++) {
			Employee e =  (Employee) r.eminformationList.get(i);
			if(e.getName().contains(name)) {
				System.out.println("名字为："+e.getName());
				a=true;
			}
		}
		if(!a) {
			System.out.println("查无此人");
		}
		r.caozuo3();
	}

}
