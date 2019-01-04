package j1;

public class Menu {
	public static final String[] MENU = { "1.学生信息管理", "2.员工信息管理", "3.退出系统" };
	public static final String[] STU_OPREATION_MENU = { "1.增加学生信息", "2.列出全部学生信息", "3.查询学生信息", "4.删除学生信息", "5.修改学生信息",
			"6.返回上一菜单" };
	public static final String[] EMP_OPREATION_MENU = { "1.增加员工信息", "2.列出全部员工信息", "3.查询员工信息", "4.删除员工信息", "5.修改员工信息",
			"6.返回上一菜单" };

	public static void showMenu(String[] Menu) {
		System.out.println("学校信息管理程序");
		for (int i = 0; i < Menu.length; i++) {

			System.out.println(Menu[i] + "\n");
		}
	}

	public static void showOPREATION_Menu(String[] Menu) {
		for (int i = 0; i < Menu.length; i++) {
			System.out.println(Menu[i] + "\n");
		}

	}

}
