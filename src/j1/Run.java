package j1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Run {
	private Scanner sc = new Scanner(System.in);
	ArrayList<Student> students = new ArrayList<Student>();
	ArrayList<Employee> employees = new ArrayList<Employee>();


	public void caozuo() throws IOException {
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
			sc.close();
			break;
		default:
			System.out.println("ָ���������������");
			caozuo();
			break;
		}
	}

	public void caozuo2() throws IOException {
		Menu.showOPREATION_Menu(Menu.STU_OPREATION_MENU);
		System.out.println("��������Ҫѡ��Ĳ���");
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		StudentOperate so = new StudentOperate();
		switch (s) {
		case "1":
			so.add(students, "students.txt");
			students.clear();
			break;
		case "2":
			so.list(students, "students.txt");
			students.clear();
			break;
		case "3":
			so.query(students, "students.txt");
			students.clear();
			break;
		case "4":
			so.delete(students, "students.txt");
			students.clear();
			break;
		case "5":
			so.update(students, "students.txt");
			students.clear();
			break;
		case "6":
			caozuo();
			students.clear();
			sc.close();
			break;
		case "7":
			so.findByLike(students, "students.txt");
			students.clear();
			break;
		default:
			System.out.println("ָ���������������");
			caozuo2();
			students.clear();
			break;
		}
	}

	public String getValidString() {
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

	public int getValidAge() {
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

	public void caozuo3() throws IOException {
		Menu.showOPREATION_Menu(Menu.EMP_OPREATION_MENU);
		System.out.println("��������Ҫѡ��Ĳ���");
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		EmployeeOperate emo = new EmployeeOperate();
		switch (s) {
		case "1":
			emo.add(employees,"employees.txt");
	
			employees.clear();
			break;
		case "2":
			emo.list(employees,"employees.txt");
			employees.clear();
			break;
		case "3":
			emo.query(employees,"employees.txt");
			employees.clear();
			break;
		case "4":
			emo.delete(employees,"employees.txt");
			employees.clear();
			break;
		case "5":
			emo.update(employees,"employees.txt");
			employees.clear();
			break;
		case "6":
			caozuo();
			employees.clear();
			sc.close();
			break;
		case "7":
			emo.findByLike(employees,"employees.txt");
			employees.clear();
			break;
		default:
			System.out.println("ָ���������������");
			employees.clear();
			caozuo3();
			break;
		}
	}

	public static void main(String[] args) throws IOException {
		Run r = new Run();
		r.caozuo();
	}

}
