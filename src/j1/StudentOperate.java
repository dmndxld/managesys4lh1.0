package j1;

import java.util.Scanner;

public class StudentOperate implements PersonOperate {
	static Scanner sc = new Scanner(System.in);
	Run r=new Run();
	public void query() {
		System.out.println("------��ѯѧ����Ϣ------");
		System.out.println("��������Ҫ��ѯ��ѧ��ID");
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
				System.out.println("���޴�������������");
			}
		} while (!isok);
		r.caozuo2();
	}

	public void update() {
		System.out.println("------�޸�ѧ��------");
		System.out.println("��������Ҫ�޸ĵ�ѧ��ID");
		boolean isok = false;
		Student s;
		
		do {
			String str = r.getValidString();
			isok = r.stuis.CheckExitByID(str);
			if (isok == true) {
				isok = true;
				s = r.stuis.getStudentByID(str);
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
		r.caozuo2();

	}
	public  void delete() {
		System.out.println("------ɾ��ѧ��------");

		String ID;
		boolean isok = false;
		System.out.println("��������Ҫɾ����ѧ��ID");
		do {
			ID = r.getValidString();
			isok = r.stuis.CheckExitByID(ID);
			if (isok == true) {
				System.out.println("ID���ҳɹ�");
				r.stuinformationList.remove(r.stuis.getPersonByID(ID));

			} else {
				System.out.println("������Ϣ��������������");
			}
		} while (!isok);
		System.out.println("ɾ���ɹ�");
		r.caozuo2();

	}
	public void list() {
		System.out.println("------����ѧ����Ϣ------");
		for (int i = 0; i < r.stuinformationList.size(); i++) {
			Student s = (Student) r.stuinformationList.get(i);
			System.out.println("ID" + "\t" + s.getID() + "\t" + "Name" + "\t" + s.getName() + "\t" + "age" + "\t"
					+ s.getAge() + "\t" + "Grade" + "\t" + s.getGrade());
		}
		r.caozuo2();

	}

	public  void add() {
		System.out.println("------����ѧ��------");

		boolean isok = false;
		String ID = null;
		do {
			System.out.println("������ID���Ҳ��ܳ����ظ�)");
			ID = sc.next();
			if (r.stuis.getStudentByID(ID) == null) {
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
		System.out.println("�ɼ���");
		double grade = sc.nextDouble();
		r.stuis.saveStudent(new Student(ID, name, age, grade));
		r.caozuo2();

	}
	public void findByLike() {
		System.out.println("����Ҫ��ѯ�����֣�");
		String name=sc.next();
		boolean a=false;
		for (int i = 0; i < r.stuinformationList.size(); i++) {
			Student s = (Student) r.stuinformationList.get(i);
			if(s.getName().contains(name)) {
				System.out.println("����Ϊ��"+s.getName());
				a=true;
			}
		}
		if(!a) {
			System.out.println("���޴���");
		}
		r.caozuo2();
	}

}
