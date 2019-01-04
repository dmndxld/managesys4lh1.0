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
		System.out.println("��������Ҫѡ��Ĳ���");
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
			System.out.println("ллʹ��");
			break;
		default:
			System.out.println("ָ���������������");
			caozuo();
			break;
		}
	}

	public static void caozuo2() {
		Menu.showOPREATION_Menu(Menu.STU_OPREATION_MENU);
		System.out.println("��������Ҫѡ��Ĳ���");
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
			System.out.println("ָ���������������");
			caozuo2();
			break;
		}
	}

	public static void queryStudent() {
		System.out.println("------��ѯѧ����Ϣ------");
		System.out.println("��������Ҫ��ѯ��ѧ��ID");
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
				System.out.println("���޴�������������");
			}
		} while (!isok);
		caozuo2();
	}

	public static void updateStudent() {
		System.out.println("------�޸�ѧ��------");
		System.out.println("��������Ҫ�޸ĵ�ѧ��ID");
		boolean isok = false;
		Student s;
		do {
			String str = getValidString();
			isok = stuis.CheckExitByID(str);
			if (isok == true) {
				isok = true;
				s = stuis.getStudentByID(str);
				s.display();
				System.out.println("���������֣�");
				String name = sc.next();
				System.out.println("���������䣺");
				int age = sc.nextInt();
				System.out.println("������ɼ���");
				double grade = sc.nextDouble();
				s.setName(name);
				s.setAge(age);
				s.setGrade(grade);
				s.display();
			} else {
				System.out.println("���޴�������������");
			}
		} while (!isok);
		caozuo2();

	}

	public static void delStudent() {
		System.out.println("------ɾ��ѧ��------");

		String ID;
		boolean isok = false;
		System.out.println("��������Ҫɾ����ѧ��ID");
		do {
			ID = getValidString();
			isok = stuis.CheckExitByID(ID);
			if (isok == true) {
				System.out.println("ID���ҳɹ�");
				stuinformationList.remove(stuis.getPersonByID(ID));

			} else {
				System.out.println("������Ϣ��������������");
			}
		} while (!isok);
		System.out.println("ɾ���ɹ�");
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
				System.out.println("���������������");
				sc.hasNext();
			}

		} while (!isok);
		return ID;

	}

	public static void listStudent() {
		System.out.println("------����ѧ����Ϣ------");
		for (int i = 0; i < stuinformationList.size(); i++) {
			Student s = (Student) stuinformationList.get(i);
			System.out.println("ID" + "\t" + s.getID() + "\t" + "Name" + "\t" + s.getName() + "\t" + "age" + "\t"
					+ s.getAge() + "\t" + "Grade" + "\t" + s.getGrade());
		}
		caozuo2();

	}

	public static void addStudent() {
		System.out.println("------����ѧ��------");

		boolean isok = false;
		String ID = null;
		do {
			System.out.println("������ID���Ҳ��ܳ����ظ�)");
			ID = sc.next();
			if (stuis.getStudentByID(ID) == null) {
				isok = true;
			} else {
				System.out.println("������Ϣ�Ѵ��ڣ�����������");
				addStudent();
			}
		} while (!isok);
		System.out.println("������������Ϣ������");
		System.out.println("������");
		String name = getValidString();
		System.out.println("���䣺");
		int age = getValidAge();
		System.out.println("�ɼ���");
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
				System.out.println("������������������");
			} else {
				isok = true;
			}

		} while (!isok);
		return num;
	}

	public static void caozuo3() {
		Menu.showOPREATION_Menu(Menu.EMP_OPREATION_MENU);
		System.out.println("��������Ҫѡ��Ĳ���");
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
			System.out.println("ָ���������������");
			caozuo3();
			break;
		}
	}

	public static void updateEmployee() {
		System.out.println("------�޸�Ա��------");
		System.out.println("��������Ҫ�޸ĵ�Ա��ID");
		boolean isok = false;
		Employee e;
		do {
			String str = getValidString();
			isok = emis.CheckExitByID(str);
			if (isok == true) {
				isok = true;
				e = emis.getEmployeeByID(str);
				e.display();
				System.out.println("���������֣�");
				String name = sc.next();
				System.out.println("���������䣺");
				int age = sc.nextInt();
				System.out.println("������нˮ��");
				int salary = sc.nextInt();
				System.out.println("������нˮ��");
				String work=sc.next();
				e.setName(name);
				e.setAge(age);
				e.setSalary(salary);
				e.setWork(work);
				e.display();
			} else {
				System.out.println("���޴�������������");
			}
		} while (!isok);
		caozuo3();

	}

	public static void delEmployee() {
		System.out.println("------ɾ��Ա��------");
		
		String ID;
		boolean isok = false;
		System.out.println("��������Ҫɾ����Ա��ID");
		do {
			ID = getValidString();
			isok = emis.CheckExitByID(ID);
			if (isok == true) {
				System.out.println("ID���ҳɹ�");
				eminformationList.remove(emis.getPersonByID(ID));

			} else {
				System.out.println("������Ϣ��������������");
			}
		} while (!isok);
		System.out.println("ɾ���ɹ�");
		caozuo3();


	}

	public static void queryEmployee() {
		System.out.println("------��ѯԱ����Ϣ------");
		System.out.println("��������Ҫ��ѯ��Ա��ID");
		
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
				System.out.println("���޴�������������");
			}
		} while (!isok);
		caozuo3();

	}

	public static void addEmployee() {
		System.out.println("------����Ա��------");
		boolean isok = false;
		String ID = null;
		do {
			System.out.println("������ID���Ҳ��ܳ����ظ�)");
			ID = sc.next();
			if (emis.getEmployeeByID(ID) == null) {
				isok = true;
			} else {
				System.out.println("������Ϣ�Ѵ��ڣ�����������");
				addEmployee();
			}
		} while (!isok);
		System.out.println("������������Ϣ������");
		System.out.println("������");
		String name = getValidString();
		System.out.println("���䣺");
		int age = getValidAge();
		System.out.println("нˮ��");
		int salary = sc.nextInt();
		System.out.println("����");
		String work=getValidString();
		emis.saveEmployee(new Employee(ID, name, age, salary,work));
		caozuo3();

	}

	public static void listEmployee() {
		System.out.println("------����Ա����Ϣ------");
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
