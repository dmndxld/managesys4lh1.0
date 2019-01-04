package j1;

import java.util.Scanner;

public class EmployeeOperate implements PersonOperate {
	static Scanner sc = new Scanner(System.in);
	Run r=new Run();
	public void update() {
		System.out.println("------�޸�Ա��------");
		System.out.println("��������Ҫ�޸ĵ�Ա��ID");
		boolean isok = false;
		Employee e;
		do {
			String str = r.getValidString();
			isok = r.emis.CheckExitByID(str);
			if (isok == true) {
				isok = true;
				e = r.emis.getEmployeeByID(str);
				e.display();
				System.out.println("���������֣�");
				String name = sc.next();
				System.out.println("���������䣺");
				int age = sc.nextInt();
				System.out.println("������нˮ��");
				int salary = sc.nextInt();
				System.out.println("������нˮ��");
				String work = sc.next();
				e.setName(name);
				e.setAge(age);
				e.setSalary(salary);
				e.setWork(work);
				e.display();
			} else {
				System.out.println("���޴�������������");
			}
		} while (!isok);
		r.caozuo3();

	}

	public  void delete() {
		System.out.println("------ɾ��Ա��------");

		String ID;
		boolean isok = false;
		System.out.println("��������Ҫɾ����Ա��ID");
		do {
			ID = r.getValidString();
			isok = r.emis.CheckExitByID(ID);
			if (isok == true) {
				System.out.println("ID���ҳɹ�");
				r.eminformationList.remove(r.emis.getPersonByID(ID));

			} else {
				System.out.println("������Ϣ��������������");
			}
		} while (!isok);
		System.out.println("ɾ���ɹ�");
		r.caozuo3();

	}

	public  void query() {
		System.out.println("------��ѯԱ����Ϣ------");
		System.out.println("��������Ҫ��ѯ��Ա��ID");

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
				System.out.println("���޴�������������");
			}
		} while (!isok);
		r.caozuo3();

	}



	public void add() {
		System.out.println("------����Ա��------");
		boolean isok = false;
		String ID = null;
		do {
			System.out.println("������ID���Ҳ��ܳ����ظ�)");
			ID = sc.next();
			if (r.emis.getEmployeeByID(ID) == null) {
				isok = true;
			} else {
				System.out.println("������Ϣ�Ѵ��ڣ�����������");
				add();
			}
		} while (!isok);
		System.out.println("������������Ϣ������");
		System.out.println("������");
		String name = r.getValidString();
		System.out.println("���䣺");
		int age = r.getValidAge();
		System.out.println("нˮ��");
		int salary = sc.nextInt();
		System.out.println("����");
		String work = r.getValidString();
		r.emis.saveEmployee(new Employee(ID, name, age, salary, work));
		r.caozuo3();

	}

	public void list() {
		System.out.println("------����Ա����Ϣ------");
		for (int i = 0; i < r.eminformationList.size(); i++) {
			Employee e = (Employee) r.eminformationList.get(i);
			System.out.println("ID" + "\t" + e.getID() + "\t" + "Name" + "\t" + e.getName() + "\t" + "age" + "\t"
					+ e.getAge() + "\t" + "salary" + "\t" + e.getSalary() + "\t" + "work" + "\t" + e.getWork());
		}
		r.caozuo3();

	}
	public void findByLike() {
		System.out.println("����Ҫ��ѯ�����֣�");
		String name=sc.next();
		boolean a=false;
		for (int i = 0; i < r.eminformationList.size(); i++) {
			Employee e =  (Employee) r.eminformationList.get(i);
			if(e.getName().contains(name)) {
				System.out.println("����Ϊ��"+e.getName());
				a=true;
			}
		}
		if(!a) {
			System.out.println("���޴���");
		}
		r.caozuo3();
	}

}
