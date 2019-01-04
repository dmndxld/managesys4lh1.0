package j1;

import java.util.Scanner;

public class StudentOperate implements PersonOperate {
	static Scanner sc = new Scanner(System.in);
	Run r=new Run();
	public void query() {
		System.out.println("------查询学生信息------");
		System.out.println("请输入你要查询的学生ID");
		Student s;
		boolean isok = false;
		do {
			String str = r.getValidString();
			boolean strisok = r.stuis.CheckExitByID(str);
			if (strisok == true) {
				s = r.stuis.getStudentByID(str);
				s.display();
				isok = true;

			} else {
				System.out.println("查无此人请重新输入");
			}
		} while (!isok);
		r.caozuo2();
	}

	public void update() {
		System.out.println("------修改学生------");
		System.out.println("请输入你要修改的学生ID");
		boolean isok = false;
		Student s;
		
		do {
			String str = r.getValidString();
			isok = r.stuis.CheckExitByID(str);
			if (isok == true) {
				isok = true;
				s = r.stuis.getStudentByID(str);
				s.display();
				System.out.println("请输入名字：");
				String name = sc.next();
				System.out.println("请输入年龄：");
				int age = sc.nextInt();
				System.out.println("请输入成绩：");
				double grade = sc.nextDouble();
				s.setName(name);
				s.setAge(age);
				s.setGrade(grade);
				s.display();
			} else {
				System.out.println("查无此人请重新输入");
			}
		} while (!isok);
		r.caozuo2();

	}
	public  void delete() {
		System.out.println("------删除学生------");

		String ID;
		boolean isok = false;
		System.out.println("请输入你要删除的学生ID");
		do {
			ID = r.getValidString();
			isok = r.stuis.CheckExitByID(ID);
			if (isok == true) {
				System.out.println("ID查找成功");
				r.stuinformationList.remove(r.stuis.getPersonByID(ID));

			} else {
				System.out.println("输入信息有误，请重新输入");
			}
		} while (!isok);
		System.out.println("删除成功");
		r.caozuo2();

	}
	public void list() {
		System.out.println("------所有学生信息------");
		for (int i = 0; i < r.stuinformationList.size(); i++) {
			Student s = (Student) r.stuinformationList.get(i);
			System.out.println("ID" + "\t" + s.getID() + "\t" + "Name" + "\t" + s.getName() + "\t" + "age" + "\t"
					+ s.getAge() + "\t" + "Grade" + "\t" + s.getGrade());
		}
		r.caozuo2();

	}

	public  void add() {
		System.out.println("------增加学生------");

		boolean isok = false;
		String ID = null;
		do {
			System.out.println("请输入ID（且不能出现重复)");
			ID = sc.next();
			if (r.stuis.getStudentByID(ID) == null) {
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
		System.out.println("成绩：");
		double grade = sc.nextDouble();
		r.stuis.saveStudent(new Student(ID, name, age, grade));
		r.caozuo2();

	}
	public void findByLike() {
		System.out.println("你所要查询的名字：");
		String name=sc.next();
		boolean a=false;
		for (int i = 0; i < r.stuinformationList.size(); i++) {
			Student s = (Student) r.stuinformationList.get(i);
			if(s.getName().contains(name)) {
				System.out.println("名字为："+s.getName());
				a=true;
			}
		}
		if(!a) {
			System.out.println("查无此人");
		}
		r.caozuo2();
	}

}
