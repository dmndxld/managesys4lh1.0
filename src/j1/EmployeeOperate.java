package j1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeOperate {
	static Scanner sc = new Scanner(System.in);
	Run r = new Run();

	public void query(ArrayList<Employee> employees, String filename) throws IOException {
		System.out.println("------��ѯԱ����Ϣ------");
		EmFileOperate.Reader(employees, "employees.txt");
		System.out.println("��������Ҫ��ѯ��Ա��ID");
		String ID = sc.next();
		boolean a = false;
		for (int i = 0; i < employees.size(); i++) {
			Employee e = (Employee) employees.get(i);
			if (e.getID().equals(ID)) {
				System.out.println("Ա���ţ�" + e.getID() + "  ���䣺" + e.getAge() + "  ������" + e.getName() + "  ������" + e.getWork()+"   нˮ��"+e.getSalary());
				a = true;
			}
		}
		if (!a) {
			System.out.println("���޴���");
		}
		r.caozuo3();
	}

	public void update(ArrayList<Employee> employees, String filename) throws IOException {
		String newName, newID, newWork;
		int newAge,newSalary;
		
		EmFileOperate.Reader(employees, "employees.txt");
		System.out.println("������Ҫ�޸ĵ�Ա���ţ�");
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
			System.out.println("�Բ��������޸ĵ�Ա����Ϣ������");
		else {
			System.out.println("�������µ�Ա�����֣�");
			newName = sc.nextLine();
			System.out.println("�������µ�Ա�����䣺");
			newAge = sc.nextInt();
			System.out.println("�������µ�Ա���ţ�");
			newID = sc.nextLine();
			System.out.println("�������µ�Ա��������");
			newWork = sc.next();
			System.out.println("�������µ�Ա��нˮ��");
			newSalary=sc.nextInt();

			Employee e = new Employee();
			e.setName(newName);
			e.setAge(newAge);
			e.setID(newID);
			e.setWork(newWork);
			e.setSalary(newSalary);
			employees.set(index, e);
			System.out.println("��ϲ�㣬�޸ĳɹ�");
			EmFileOperate.Writer(employees, "employees.txt");
		}
		r.caozuo3();

	}

	public void delete(ArrayList<Employee> employees, String filename) throws IOException {
		EmFileOperate.Reader(employees, "employees.txt");
		Scanner sc = new Scanner(System.in);
		System.out.println("��������Ҫɾ����Ա����ID��");
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
			System.out.println("ɾ���ɹ�");
		} else
			System.out.println("û������Ҫɾ����Ա�������������룺");

		r.caozuo3();

	}

	public void list(ArrayList<Employee> employees, String filename) throws IOException {
		EmFileOperate.Reader(employees, "employees.txt");
		if (employees.size() == 0)
			System.out.println("�Բ���û��Ա����Ϣ");
		else {
			for (int i = 0; i < employees.size(); i++) {

				Employee e = employees.get(i);
				System.out.println(
						"ID��" + e.getID() + "  ���䣺" + e.getAge() + "  ������" + e.getName() + "  ������" + e.getWork()+"   нˮ��"+e.getSalary());
			}
		}
		r.caozuo3();

	}

	public void add(ArrayList<Employee> employees, String filename) throws IOException {
		EmFileOperate.Reader(employees, "employees.txt");
		Scanner sc = new Scanner(System.in);
		String id;
		while (true) {
			System.out.println("������Ա����ID��");
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
				System.out.println("�Բ����������ID��������������");
		}
		System.out.println("������Ա����������");
		String name = sc.nextLine();
		System.out.println("������Ա�������䣺");
		int age = sc.nextInt();
		System.out.println("������Ա���Ĺ�����");
		String work=sc.next();
		System.out.println("������Ա����нˮ��");
		int Salary=sc.nextInt();
		Employee e=new Employee();
		e.setName(name);
		e.setAge(age);
		e.setID(id);
		e.setWork(work);
		e.setSalary(Salary);
		employees.add(e);
		EmFileOperate.Writer(employees, "employees.txt");

		System.out.println("���Ա���ɹ�");

		r.caozuo3();

	}

	public void findByLike(ArrayList<Employee> employees, String filename) throws IOException {
		EmFileOperate.Reader(employees, "employees.txt");
		System.out.println("����Ҫ��ѯ�����֣�");
		String name = sc.next();
		boolean a = false;
		for (int i = 0; i < employees.size(); i++) {
			Employee e = (Employee) employees.get(i);
			if (e.getName().contains(name)) {
				System.out.println("����Ϊ��" + e.getName());
				a = true;
			}
		}
		if (!a) {
			System.out.println("���޴���");
		}
		r.caozuo3();
	}

}
