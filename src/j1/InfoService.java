package j1;
import java.util.List;
public class InfoService {
	private List informationList=Info.getList();
	//获取列表信息
	public List getList() {
		return informationList;
	}
	//按ID查找信息
	public 	Person getPersonByID(final String ID) {
		for(int i=0;i<informationList.size();i++) {
			Person p=(Person)informationList.get(i);
			if(p.getID().equals(ID)) {
				
				return p;
			}
		}
		
		return null;
	}
	public 	Student getStudentByID(final String ID) {
		for(int i=0;i<informationList.size();i++) {
			Student s=(Student)informationList.get(i);
			if(s.getID().equals(ID)) {
				
				return s;
			}
		}
		
		return null;
	}
	public 	Employee getEmployeeByID(final String ID) {
		for(int i=0;i<informationList.size();i++) {
			Employee e=(Employee)informationList.get(i);
			if(e.getID().equals(ID)) {
				
				return e;
			}
		}
		
		return null;
	}
	//检查对象是否存在
	public boolean CheckExitByID(String ID) {
		for(int i=0;i<informationList.size();i++) {
			Person p=(Person)informationList.get(i);
			if(p.getID().equals(ID)) {
				return true;
			}
			
		}return false;
	}
	//保存学生
	public void saveStudent(Student s) {
		informationList.add(s);
	}
	//保存员工
	public void saveEmployee(Employee e) {
		informationList.add(e);
	}

}
