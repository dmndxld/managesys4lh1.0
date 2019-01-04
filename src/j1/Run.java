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
			sc.close();
			break;
		default:
			System.out.println("指令错误请重新输入");
			caozuo();
			break;
		}
	}

	public  void caozuo2() {
		Menu.showOPREATION_Menu(Menu.STU_OPREATION_MENU);
		System.out.println("请输入你要选择的操作");
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
			System.out.println("指令错误请重新输入");
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
				System.out.println("输入错误，重新输入");
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
				System.out.println("输入有误请重新输入");
			} else {
				isok = true;
			}

		} while (!isok);
		return num;
	}

	public  void caozuo3() {
		Menu.showOPREATION_Menu(Menu.EMP_OPREATION_MENU);
		System.out.println("请输入你要选择的操作");
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
			System.out.println("指令错误请重新输入");
			caozuo3();
			break;
		}
	}


	public static void main(String[] args) {
		Run r=new Run();
		r.caozuo();
	}

}
