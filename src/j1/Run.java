package j1;

import java.util.Scanner;

public class Run {
	static Scanner sc = new Scanner(System.in);
	static Employee[] em = new Employee[10];
	static Student[] stu = new Student[10];

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
		String s = sc.next();
		for (int i = 0; i < 10; i++) {
			if (stu[i] != null) {
				if (stu[i].ID.equals(s)) {
					System.out.println("你要查询的学生是：");
					stu[i].display();
				} else {
					if (i != 9) {
						continue;
					} else {
						System.out.println("你输入的学生不存在请重新输入");
						caozuo2();
					}
				}
			}
		}
	}

	public static void updateStudent() {
		System.out.println("------修改学生------");
		System.out.println("请输入你要修改的学生ID");
		String s = sc.next();
		for (int i = 0; i < 10; i++) {
			if (stu[i] != null) {
				if (stu[i].ID.equals(s)) {
					System.out.println("你要修改的是：");
					stu[i].display();
					System.out.println("请重新输入相关信息：");
					System.out.println("ID:");
					String ID = sc.next();
					System.out.println("姓名：");
					String name = sc.next();
					System.out.println("年龄：");
					int age = sc.nextInt();
					System.out.println("成绩：");
					double grade = sc.nextDouble();
					Student st = new Student(ID, name, age, grade);
					stu[i] = st;
					System.out.println("修改成功！");
				} else {
					if (i != 9) {
						continue;
					} else {
						System.out.println("你输入的学生不存在请重新输入");
						caozuo2();
					}
				}
			}
		}

	}

	public static void delStudent() {
		System.out.println("------删除学生------");
		System.out.println("请输入你要删除的学生ID");
		String n = sc.next();
		for (int i = 0; i < 10; i++) {
			if (stu[i] != null) {
				if (stu[i].ID.equals(n)) {
					stu[i] = null;
					System.out.println("删除成功！");

				} else {
					System.out.println("指令错误请重新输入");
					delStudent();
				}
			} else {
				if (i != 9) {
					continue;
				} else {
					System.out.println("输入学生不存在请重新输入");
					delStudent();
				}
			}
		}

	}

	public static void listStudent() {
		System.out.println("------所有学生信息------");
		for (int i = 0; i < 10; i++) {
			if (stu[i] != null) {
				stu[i].display();
			}
		}

	}

	public static void addStudent() {
		System.out.println("------增加学生------");
		int i=0;
		while(true) {
		System.out.println("点击任意键继续添加学生信息，停止添加输入0");
			  if(sc.nextInt()==0)break;
		System.out.println("ID:");
		String ID = sc.next();
		for(int a=0;a<i;a++) {
			if(stu[i-1].ID.equals(ID)) {
				System.out.println("输入ID重复请重新输入");
				addStudent();
			}else {
				break;
			}
		}
		System.out.println("姓名：");
		String name = sc.next();
		System.out.println("年龄：");
		int age = sc.nextInt();
		System.out.println("成绩：");
		double grade = sc.nextDouble();
		Student s = new Student(ID, name, age, grade);
		stu[i]=s;
		i++;
		System.out.println("添加成功");
		}
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
		String s = sc.next();
		for (int i = 0; i < 10; i++) {
			if (em[i] != null) {
				if (em[i].ID.equals(s)) {
					System.out.println("你要修改的是：");
					em[i].display();
					System.out.println("请重新输入相关信息：");
					System.out.println("ID:");
					String ID = sc.next();
					System.out.println("姓名：");
					String name = sc.next();
					System.out.println("年龄：");
					int age = sc.nextInt();
					System.out.println("薪水：");
					int salary = sc.nextInt();
					System.out.println("工作：");
					String work = sc.next();
					Employee e = new Employee(ID, name, age,salary,work);
					em[i] = e;
					System.out.println("修改成功！");
				} else {
					if (i != 9) {
						continue;
					} else {
						System.out.println("你输入的员工不存在请重新输入");
						caozuo3();
					}
				}
			}
		}
	}

	public static void delEmployee() {
		System.out.println("------删除员工------");
		System.out.println("请输入你要删除的员工ID");
		String n = sc.next();
		for (int i = 0; i < 10; i++) {
			if (em[i] != null) {
				if (em[i].ID.equals(n)) {
					em[i] = null;
					System.out.println("删除成功！");

				} else {
					System.out.println("指令错误请重新输入");
					delEmployee();
				}
			} else {
				if (i != 9) {
					continue;
				} else {
					System.out.println("输入员工不存在请重新输入");
					delEmployee();
				}
			}
		}
	}

	public static void queryEmployee() {
		System.out.println("------查询员工信息------");
		System.out.println("请输入你要查询的员工ID");
		String s = sc.next();
		for (int i = 0; i < 10; i++) {
			if (em[i] != null) {
				if (em[i].ID.equals(s)) {
					System.out.println("你要查询的员工是：");
					em[i].display();
				} else {
					if (i != 9) {
						continue;
					} else {
						System.out.println("你输入的员工不存在请重新输入");
						caozuo3();
					}
				}
			}
		}
	}

	public static void addEmployee() {
		System.out.println("------增加员工------");
		int i=0;
		while(true) {
		System.out.println("点击任意键继续添加员工信息，停止添加输入0");
			  if(sc.nextInt()==0)break;
		System.out.println("ID:");
		String ID = sc.next();
		for(int a=0;a<i;a++) {
			if(em[i-1].ID.equals(ID)) {
				System.out.println("输入ID重复请重新输入");
				addEmployee();
			}else {
				break;
			}
		}
		System.out.println("姓名：");
		String name = sc.next();
		System.out.println("年龄：");
		int age = sc.nextInt();
		System.out.println("薪水：");
		int salary = sc.nextInt();
		System.out.println("工作：");
		String work = sc.next();
		Employee e = new Employee(ID, name, age, salary,work);
		em[i]=e;
		i++;
		System.out.println("添加成功");
		}
	}
	public static void listEmployee() {
		System.out.println("------所有员工信息------");
		for (int i = 0; i < 10; i++) {
			if (em[i] != null) {
				em[i].display();
			}
		}
	}
	public static void main(String[] args) {
		Run.caozuo();
	}

}
