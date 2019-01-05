package j1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentOperate {
	static Scanner sc = new Scanner(System.in);
	Run r = new Run();

	public void query(ArrayList<Student> students, String filename) throws IOException {
		System.out.println("------��ѯѧ����Ϣ------");
		StuFileOperate.Reader(students, "students.txt");
		System.out.println("��������Ҫ��ѯ��ѧ��ID");
		String ID = sc.next();
		boolean a = false;
		for (int i = 0; i < students.size(); i++) {
			Student s = (Student) students.get(i);
			if (s.getID().equals(ID)) {
				System.out.println("ѧ�ţ�" + s.getID() + "  ���䣺" + s.getAge() + "  ������" + s.getName() + "  �ɼ���" + s.getGrade());
				a = true;
			}
		}
		if (!a) {
			System.out.println("���޴���");
		}
		r.caozuo2();
	}

	public void update(ArrayList<Student> students, String filename) throws IOException {
		String newName, newID;
		int newAge;
		double newGrade;
		StuFileOperate.Reader(students, "students.txt");
		System.out.println("������Ҫ�޸ĵ�ѧ��ѧ�ţ�");
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
			System.out.println("�Բ��������޸ĵ�ѧ����Ϣ������");
		else {
			System.out.println("�������µ�ѧ�����֣�");
			newName = sc.nextLine();
			System.out.println("�������µ�ѧ�����䣺");
			newAge = sc.nextInt();
			System.out.println("�������µ�ѧ��ѧ�ţ�");
			newID = sc.nextLine();
			System.out.println("�������µ�ѧ���ɼ���");
			newGrade = sc.nextDouble();

			Student s = new Student();
			s.setName(newName);
			s.setAge(newAge);
			s.setID(newID);
			s.setGrade(newGrade);
			students.set(index, s);
			System.out.println("��ϲ�㣬�޸ĳɹ�");
			StuFileOperate.Writer(students, "students.txt");
		}
		r.caozuo2();

	}

	public void delete(ArrayList<Student> students, String filename) throws IOException {
		StuFileOperate.Reader(students, "students.txt");
		Scanner sc = new Scanner(System.in);
		System.out.println("��������Ҫɾ����ѧ����ѧ�ţ�");
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
			System.out.println("ɾ���ɹ�");
		} else
			System.out.println("û������Ҫɾ����ѧ�������������룺");

		r.caozuo2();

	}

	public void list(ArrayList<Student> students, String filename) throws IOException {
		StuFileOperate.Reader(students, "students.txt");
		if (students.size() == 0)
			System.out.println("�Բ���û��ѧ����Ϣ");
		else {
			for (int i = 0; i < students.size(); i++) {

				Student s = students.get(i);
				System.out.println(
						"ѧ�ţ�" + s.getID() + "  ���䣺" + s.getAge() + "  ������" + s.getName() + "  �ɼ���" + s.getGrade());
			}
		}
		r.caozuo2();

	}

	public void add(ArrayList<Student> students, String filename) throws IOException {
		StuFileOperate.Reader(students, "students.txt");
		Scanner sc = new Scanner(System.in);
		String id;
		while (true) {
			System.out.println("������ѧ����ѧ�ţ�");
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
				System.out.println("�Բ����������ѧ����������������");
		}
		System.out.println("������ѧ����������");
		String name = sc.nextLine();
		System.out.println("������ѧ�������䣺");
		int age = sc.nextInt();
		System.out.println("������ѧ���ĳɼ���");
		double grade = sc.nextDouble();
		Student s = new Student();
		s.setName(name);
		s.setAge(age);
		s.setID(id);
		s.setGrade(grade);
		students.add(s);
		StuFileOperate.Writer(students, "students.txt");

		System.out.println("���ѧ���ɹ�");

		r.caozuo2();

	}

	public void findByLike(ArrayList<Student> students, String filename) throws IOException {
		StuFileOperate.Reader(students, "students.txt");
		System.out.println("����Ҫ��ѯ�����֣�");
		String name = sc.next();
		boolean a = false;
		for (int i = 0; i < students.size(); i++) {
			Student s = (Student) students.get(i);
			if (s.getName().contains(name)) {
				System.out.println("����Ϊ��" + s.getName());
				a = true;
			}
		}
		if (!a) {
			System.out.println("���޴���");
		}
		r.caozuo2();
	}

}
