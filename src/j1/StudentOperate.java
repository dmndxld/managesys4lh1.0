package j1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentOperate {
	static Scanner sc = new Scanner(System.in);
	Run r = new Run();

	public void query(ArrayList<Student> students, String filename) throws IOException {
		System.out.println("------查询学生信息------");
		StuFileOperate.Reader(students, "students.txt");
		System.out.println("请输入你要查询的学生ID");
		String ID = sc.next();
		boolean a = false;
		for (int i = 0; i < students.size(); i++) {
			Student s = (Student) students.get(i);
			if (s.getID().equals(ID)) {
				System.out.println("学号：" + s.getID() + "  年龄：" + s.getAge() + "  姓名：" + s.getName() + "  成绩：" + s.getGrade());
				a = true;
			}
		}
		if (!a) {
			System.out.println("查无此人");
		}
		r.caozuo2();
	}

	public void update(ArrayList<Student> students, String filename) throws IOException {
		String newName, newID;
		int newAge;
		double newGrade;
		StuFileOperate.Reader(students, "students.txt");
		System.out.println("输入你要修改的学生学号：");
		Scanner sc = new Scanner(System.in);
		int index = -1;
		String upId = sc.nextLine();
		for (int i = 0; i < students.size(); i++) {
			Student s = students.get(i);
			if (upId.equals(s.getID())) {
				index = i;
				break;
			}
		}
		if (index == -1)
			System.out.println("对不起，你所修改的学生信息不存在");
		else {
			System.out.println("请输入新的学生名字：");
			newName = sc.nextLine();
			System.out.println("请输入新的学生年龄：");
			newAge = sc.nextInt();
			System.out.println("请输入新的学生学号：");
			newID = sc.nextLine();
			System.out.println("请输入新的学生成绩：");
			newGrade = sc.nextDouble();

			Student s = new Student();
			s.setName(newName);
			s.setAge(newAge);
			s.setID(newID);
			s.setGrade(newGrade);
			students.set(index, s);
			System.out.println("恭喜你，修改成功");
			StuFileOperate.Writer(students, "students.txt");
		}
		r.caozuo2();

	}

	public void delete(ArrayList<Student> students, String filename) throws IOException {
		StuFileOperate.Reader(students, "students.txt");
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入你要删除的学生的学号：");
		String deleteId = sc.nextLine();
		// boolean flag=false;
		int index = -1;
		for (int i = 0; i < students.size(); i++) {
			Student s = students.get(i);
			if (s.getID().equals(deleteId)) {
				index = i;
				// flag=true;
				break;
			}
		}

		if (index != -1) {
			students.remove(index);
			StuFileOperate.Writer(students, "students.txt");
			System.out.println("删除成功");
		} else
			System.out.println("没有你想要删除的学生，请重新输入：");

		r.caozuo2();

	}

	public void list(ArrayList<Student> students, String filename) throws IOException {
		StuFileOperate.Reader(students, "students.txt");
		if (students.size() == 0)
			System.out.println("对不起，没有学生信息");
		else {
			for (int i = 0; i < students.size(); i++) {

				Student s = students.get(i);
				System.out.println(
						"学号：" + s.getID() + "  年龄：" + s.getAge() + "  姓名：" + s.getName() + "  成绩：" + s.getGrade());
			}
		}
		r.caozuo2();

	}

	public void add(ArrayList<Student> students, String filename) throws IOException {
		StuFileOperate.Reader(students, "students.txt");
		Scanner sc = new Scanner(System.in);
		String id;
		while (true) {
			System.out.println("请输入学生的学号：");
			id = sc.nextLine();
			boolean flag = true;
			for (int i = 0; i < students.size(); i++) {
				Student s = students.get(i);
				if (id.equals(s.getID())) {
					flag = false;
					break;
				}
			}
			if (flag)
				break;
			else
				System.out.println("对不起，你输入的学号有误，请重新输入");
		}
		System.out.println("请输入学生的姓名：");
		String name = sc.nextLine();
		System.out.println("请输入学生的年龄：");
		int age = sc.nextInt();
		System.out.println("请输入学生的成绩：");
		double grade = sc.nextDouble();
		Student s = new Student();
		s.setName(name);
		s.setAge(age);
		s.setID(id);
		s.setGrade(grade);
		students.add(s);
		StuFileOperate.Writer(students, "students.txt");

		System.out.println("添加学生成功");

		r.caozuo2();

	}

	public void findByLike(ArrayList<Student> students, String filename) throws IOException {
		StuFileOperate.Reader(students, "students.txt");
		System.out.println("你所要查询的名字：");
		String name = sc.next();
		boolean a = false;
		for (int i = 0; i < students.size(); i++) {
			Student s = (Student) students.get(i);
			if (s.getName().contains(name)) {
				System.out.println("名字为：" + s.getName());
				a = true;
			}
		}
		if (!a) {
			System.out.println("查无此人");
		}
		r.caozuo2();
	}

}
