package j1;

public class Menu {
	public static final String[] MENU = { "1.ѧ����Ϣ����", "2.Ա����Ϣ����", "3.�˳�ϵͳ" };
	public static final String[] STU_OPREATION_MENU = { "1.����ѧ����Ϣ", "2.�г�ȫ��ѧ����Ϣ", "3.��ѯѧ����Ϣ", "4.ɾ��ѧ����Ϣ", "5.�޸�ѧ����Ϣ",
			"6.������һ�˵�" };
	public static final String[] EMP_OPREATION_MENU = { "1.����Ա����Ϣ", "2.�г�ȫ��Ա����Ϣ", "3.��ѯԱ����Ϣ", "4.ɾ��Ա����Ϣ", "5.�޸�Ա����Ϣ",
			"6.������һ�˵�" };

	public static void showMenu(String[] Menu) {
		System.out.println("ѧУ��Ϣ�������");
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
