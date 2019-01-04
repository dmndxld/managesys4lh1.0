package j1;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Run {
	private Scanner sc = new Scanner(System.in);
	public List stuinformationList = Info.getList();
	public  List eminformationList = Info.getList();
	public  InfoService stuis = new InfoService();
	public  InfoService emis = new InfoService();

	public  void caozuo() {
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

	public  void caozuo2() {
		Menu.showOPREATION_Menu(Menu.STU_OPREATION_MENU);
		System.out.println("��������Ҫѡ��Ĳ���");
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		StudentOperate so=new StudentOperate();
		switch (s) {
		case "1":
			
			so.add();
			break;
		case "2":
			so.list();
			break;
		case "3":
			so.query();
			break;
		case "4":
			so.delete();
			break;
		case "5":
			so.delete();
			break;
		case "6":
			caozuo();
			break;
		case "7":
			so.findByLike();
			break;
		default:
			System.out.println("ָ���������������");
			caozuo2();
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

	public  void caozuo3() {
		Menu.showOPREATION_Menu(Menu.EMP_OPREATION_MENU);
		System.out.println("��������Ҫѡ��Ĳ���");
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		EmployeeOperate emo=new EmployeeOperate();
		switch (s) {
		case "1":
			emo.add();
			break;
		case "2":
			emo.list();
			break;
		case "3":
			emo.query();
			break;
		case "4":
			emo.delete();
			break;
		case "5":
			emo.update();
			break;
		case "6":
			caozuo();
			break;
		case "7":
			emo.findByLike();
			break;
		default:
			System.out.println("ָ���������������");
			caozuo3();
			break;
		}
	}


	public static void main(String[] args) {
		Run r=new Run();
		r.caozuo();
	}

}
