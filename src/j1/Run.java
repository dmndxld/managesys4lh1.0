package j1;

import java.util.Scanner;

public class Run {
	static Scanner sc = new Scanner(System.in);
	static Employee[] em = new Employee[10];
	static Student[] stu = new Student[10];

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
		String s = sc.next();
		for (int i = 0; i < 10; i++) {
			if (stu[i] != null) {
				if (stu[i].ID.equals(s)) {
					System.out.println("��Ҫ��ѯ��ѧ���ǣ�");
					stu[i].display();
				} else {
					if (i != 9) {
						continue;
					} else {
						System.out.println("�������ѧ������������������");
						caozuo2();
					}
				}
			}
		}
	}

	public static void updateStudent() {
		System.out.println("------�޸�ѧ��------");
		System.out.println("��������Ҫ�޸ĵ�ѧ��ID");
		String s = sc.next();
		for (int i = 0; i < 10; i++) {
			if (stu[i] != null) {
				if (stu[i].ID.equals(s)) {
					System.out.println("��Ҫ�޸ĵ��ǣ�");
					stu[i].display();
					System.out.println("���������������Ϣ��");
					System.out.println("ID:");
					String ID = sc.next();
					System.out.println("������");
					String name = sc.next();
					System.out.println("���䣺");
					int age = sc.nextInt();
					System.out.println("�ɼ���");
					double grade = sc.nextDouble();
					Student st = new Student(ID, name, age, grade);
					stu[i] = st;
					System.out.println("�޸ĳɹ���");
				} else {
					if (i != 9) {
						continue;
					} else {
						System.out.println("�������ѧ������������������");
						caozuo2();
					}
				}
			}
		}

	}

	public static void delStudent() {
		System.out.println("------ɾ��ѧ��------");
		System.out.println("��������Ҫɾ����ѧ��ID");
		String n = sc.next();
		for (int i = 0; i < 10; i++) {
			if (stu[i] != null) {
				if (stu[i].ID.equals(n)) {
					stu[i] = null;
					System.out.println("ɾ���ɹ���");

				} else {
					System.out.println("ָ���������������");
					delStudent();
				}
			} else {
				if (i != 9) {
					continue;
				} else {
					System.out.println("����ѧ������������������");
					delStudent();
				}
			}
		}

	}

	public static void listStudent() {
		System.out.println("------����ѧ����Ϣ------");
		for (int i = 0; i < 10; i++) {
			if (stu[i] != null) {
				stu[i].display();
			}
		}

	}

	public static void addStudent() {
		System.out.println("------����ѧ��------");
		int i=0;
		while(true) {
		System.out.println("���������������ѧ����Ϣ��ֹͣ�������0");
			  if(sc.nextInt()==0)break;
		System.out.println("ID:");
		String ID = sc.next();
		for(int a=0;a<i;a++) {
			if(stu[i-1].ID.equals(ID)) {
				System.out.println("����ID�ظ�����������");
				addStudent();
			}else {
				break;
			}
		}
		System.out.println("������");
		String name = sc.next();
		System.out.println("���䣺");
		int age = sc.nextInt();
		System.out.println("�ɼ���");
		double grade = sc.nextDouble();
		Student s = new Student(ID, name, age, grade);
		stu[i]=s;
		i++;
		System.out.println("��ӳɹ�");
		}
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
		String s = sc.next();
		for (int i = 0; i < 10; i++) {
			if (em[i] != null) {
				if (em[i].ID.equals(s)) {
					System.out.println("��Ҫ�޸ĵ��ǣ�");
					em[i].display();
					System.out.println("���������������Ϣ��");
					System.out.println("ID:");
					String ID = sc.next();
					System.out.println("������");
					String name = sc.next();
					System.out.println("���䣺");
					int age = sc.nextInt();
					System.out.println("нˮ��");
					int salary = sc.nextInt();
					System.out.println("������");
					String work = sc.next();
					Employee e = new Employee(ID, name, age,salary,work);
					em[i] = e;
					System.out.println("�޸ĳɹ���");
				} else {
					if (i != 9) {
						continue;
					} else {
						System.out.println("�������Ա������������������");
						caozuo3();
					}
				}
			}
		}
	}

	public static void delEmployee() {
		System.out.println("------ɾ��Ա��------");
		System.out.println("��������Ҫɾ����Ա��ID");
		String n = sc.next();
		for (int i = 0; i < 10; i++) {
			if (em[i] != null) {
				if (em[i].ID.equals(n)) {
					em[i] = null;
					System.out.println("ɾ���ɹ���");

				} else {
					System.out.println("ָ���������������");
					delEmployee();
				}
			} else {
				if (i != 9) {
					continue;
				} else {
					System.out.println("����Ա������������������");
					delEmployee();
				}
			}
		}
	}

	public static void queryEmployee() {
		System.out.println("------��ѯԱ����Ϣ------");
		System.out.println("��������Ҫ��ѯ��Ա��ID");
		String s = sc.next();
		for (int i = 0; i < 10; i++) {
			if (em[i] != null) {
				if (em[i].ID.equals(s)) {
					System.out.println("��Ҫ��ѯ��Ա���ǣ�");
					em[i].display();
				} else {
					if (i != 9) {
						continue;
					} else {
						System.out.println("�������Ա������������������");
						caozuo3();
					}
				}
			}
		}
	}

	public static void addEmployee() {
		System.out.println("------����Ա��------");
		int i=0;
		while(true) {
		System.out.println("���������������Ա����Ϣ��ֹͣ�������0");
			  if(sc.nextInt()==0)break;
		System.out.println("ID:");
		String ID = sc.next();
		for(int a=0;a<i;a++) {
			if(em[i-1].ID.equals(ID)) {
				System.out.println("����ID�ظ�����������");
				addEmployee();
			}else {
				break;
			}
		}
		System.out.println("������");
		String name = sc.next();
		System.out.println("���䣺");
		int age = sc.nextInt();
		System.out.println("нˮ��");
		int salary = sc.nextInt();
		System.out.println("������");
		String work = sc.next();
		Employee e = new Employee(ID, name, age, salary,work);
		em[i]=e;
		i++;
		System.out.println("��ӳɹ�");
		}
	}
	public static void listEmployee() {
		System.out.println("------����Ա����Ϣ------");
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
