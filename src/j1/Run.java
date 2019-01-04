package j1;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Run {
	private static Scanner sc = new Scanner(System.in);
	private static List stuinformationList = Info.getList();
	private static List eminformationList = Info.getList();
	private static InfoService stuis = new InfoService();
	private static InfoService emis = new InfoService();

	public static void caozuo() {
		Menu.showMenu(Menu.MENU);
		System.out.println("请输入你要选择的操作");
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		switch (s) {
		case "1":
			caozuo2();
			break;
		case "2":
			caozuo3();
			break;
		case "3":
			System.out.println("谢谢使用");
			break;
		default:
			System.out.println("指令错误请重新输入");
			caozuo();
			break;
		}
	}

	public static void caozuo2() {
		Menu.showOPREATION_Menu(Menu.STU_OPREATION_MENU);
		System.out.println("请输入你要选择的操作");
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		switch (s) {
		case "1":
			addStudent();
			break;
		case "2":
			listStudent();
			break;
		case "3":
			queryStudent();
			break;
		case "4":
			delStudent();
			break;
		case "5":
			updateStudent();
			break;
		case "6":
			caozuo();
			break;
		default:
			System.out.println("指令错误请重新输入");
			caozuo2();
			break;
		}
	}

	public static void queryStudent() {
		System.out.println("------查询学生信息------");
		System.out.println("请输入你要查询的学生ID");
		Student s;
		boolean isok = false;
		do {
			String str = getValidString();
			boolean strisok = stuis.CheckExitByID(str);
			if (strisok == true) {
				s = stuis.getStudentByID(str);
				s.display();
				isok = true;

			} else {
				System.out.println("查无此人请重新输入");
			}
		} while (!isok);
		caozuo2();
	}

	public static void updateStudent() {
		System.out.println("------修改学生------");
		System.out.println("请输入你要修改的学生ID");
		boolean isok = false;
		Student s;
		do {
			String str = getValidString();
			isok = stuis.CheckExitByID(str);
			if (isok == true) {
				isok = true;
				s = stuis.getStudentByID(str);
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
		caozuo2();

	}

	public static void delStudent() {
		System.out.println("------删除学生------");

		String ID;
		boolean isok = false;
		System.out.println("请输入你要删除的学生ID");
		do {
			ID = getValidString();
			isok = stuis.CheckExitByID(ID);
			if (isok == true) {
				System.out.println("ID查找成功");
				stuinformationList.remove(stuis.getPersonByID(ID));

			} else {
				System.out.println("输入信息有误，请重新输入");
			}
		} while (!isok);
		System.out.println("删除成功");
		caozuo2();

	}

	private static String getValidString() {
		String ID = "0";
		boolean isok = false;
		do {
			try {
				ID = sc.next();
				isok = true;
			} catch (InputMismatchException e) {
				System.out.println("输入错误，重新输入");
				sc.hasNext();
			}

		} while (!isok);
		return ID;

	}

	public static void listStudent() {
		System.out.println("------所有学生信息------");
		for (int i = 0; i < stuinformationList.size(); i++) {
			Student s = (Student) stuinformationList.get(i);
			System.out.println("ID" + "\t" + s.getID() + "\t" + "Name" + "\t" + s.getName() + "\t" + "age" + "\t"
					+ s.getAge() + "\t" + "Grade" + "\t" + s.getGrade());
		}
		caozuo2();

	}

	public static void addStudent() {
		System.out.println("------增加学生------");

		boolean isok = false;
		String ID = null;
		do {
			System.out.println("请输入ID（且不能出现重复)");
			ID = sc.next();
			if (stuis.getStudentByID(ID) == null) {
				isok = true;
			} else {
				System.out.println("该人信息已存在，请重新输入");
				addStudent();
			}
		} while (!isok);
		System.out.println("请输入其他信息。。。");
		System.out.println("姓名：");
		String name = getValidString();
		System.out.println("年龄：");
		int age = getValidAge();
		System.out.println("成绩：");
		double grade = sc.nextDouble();
		stuis.saveStudent(new Student(ID, name, age, grade));
		caozuo2();

	}

	private static int getValidAge() {
		int num = 0;
		boolean isok = false;
		do {
			num = sc.nextInt();
			if (num <= 0 || num >= 130) {
				System.out.println("输入有误请重新输入");
			} else {
				isok = true;
			}

		} while (!isok);
		return num;
	}

	public static void caozuo3() {
		Menu.showOPREATION_Menu(Menu.EMP_OPREATION_MENU);
		System.out.println("请输入你要选择的操作");
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		switch (s) {
		case "1":
			addEmployee();
			break;
		case "2":
			listEmployee();
			break;
		case "3":
			queryEmployee();
			break;
		case "4":
			delEmployee();
			break;
		case "5":
			updateEmployee();
			break;
		case "6":
			caozuo();
			break;
		default:
			System.out.println("指令错误请重新输入");
			caozuo3();
			break;
		}
	}

	public static void updateEmployee() {
		System.out.println("------修改员工------");
		System.out.println("请输入你要修改的员工ID");
		boolean isok = false;
		Employee e;
		do {
			String str = getValidString();
			isok = emis.CheckExitByID(str);
			if (isok == true) {
				isok = true;
				e = emis.getEmployeeByID(str);
				e.display();
				System.out.println("请输入名字：");
				String name = sc.next();
				System.out.println("请输入年龄：");
				int age = sc.nextInt();
				System.out.println("请输入薪水：");
				int salary = sc.nextInt();
				System.out.println("请输入薪水：");
				String work=sc.next();
				e.setName(name);
				e.setAge(age);
				e.setSalary(salary);
				e.setWork(work);
				e.display();
			} else {
				System.out.println("查无此人请重新输入");
			}
		} while (!isok);
		caozuo3();

	}

	public static void delEmployee() {
		System.out.println("------删除员工------");
		
		String ID;
		boolean isok = false;
		System.out.println("请输入你要删除的员工ID");
		do {
			ID = getValidString();
			isok = emis.CheckExitByID(ID);
			if (isok == true) {
				System.out.println("ID查找成功");
				eminformationList.remove(emis.getPersonByID(ID));

			} else {
				System.out.println("输入信息有误，请重新输入");
			}
		} while (!isok);
		System.out.println("删除成功");
		caozuo3();


	}

	public static void queryEmployee() {
		System.out.println("------查询员工信息------");
		System.out.println("请输入你要查询的员工ID");
		
		Student e;
		boolean isok = false;
		do {
			String str = getValidString();
			boolean strisok = emis.CheckExitByID(str);
			if (strisok == true) {
				e = emis.getStudentByID(str);
				e.display();
				isok = true;

			} else {
				System.out.println("查无此人请重新输入");
			}
		} while (!isok);
		caozuo3();

	}

	public static void addEmployee() {
		System.out.println("------增加员工------");
		boolean isok = false;
		String ID = null;
		do {
			System.out.println("请输入ID（且不能出现重复)");
			ID = sc.next();
			if (emis.getEmployeeByID(ID) == null) {
				isok = true;
			} else {
				System.out.println("该人信息已存在，请重新输入");
				addEmployee();
			}
		} while (!isok);
		System.out.println("请输入其他信息。。。");
		System.out.println("姓名：");
		String name = getValidString();
		System.out.println("年龄：");
		int age = getValidAge();
		System.out.println("薪水：");
		int salary = sc.nextInt();
		System.out.println("工作");
		String work=getValidString();
		emis.saveEmployee(new Employee(ID, name, age, salary,work));
		caozuo3();

	}

	public static void listEmployee() {
		System.out.println("------所有员工信息------");
		for (int i = 0; i < eminformationList.size(); i++) {
			Employee e = (Employee) eminformationList.get(i);
			System.out.println("ID" + "\t" + e.getID() + "\t" + "Name" + "\t" + e.getName() + "\t" + "age" + "\t"
					+ e.getAge() + "\t" + "salary" + "\t" + e.getSalary()+"\t"+"work"+"\t"+e.getWork());
		}
		caozuo3();


	}

	public static void main(String[] args) {
		Run.caozuo();
	}

}
