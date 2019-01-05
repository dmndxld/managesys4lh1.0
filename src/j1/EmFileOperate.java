package j1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EmFileOperate {
	public static void Writer(ArrayList<Employee> employees,String filename) throws IOException{
		BufferedWriter bw=new BufferedWriter(new FileWriter(filename));
		for(int i=0;i<employees.size();i++) {
			Employee e=employees.get(i);
			StringBuilder sb=new StringBuilder();
			sb.append(e.getID()).append(",").append(e.getAge()).append(",").append(e.getName()).append(",").append(e.getWork()).append(",").append(e.getSalary());
			bw.write(sb.toString());
			bw.newLine();
			bw.flush();
		}
		bw.close();	
		
	}
	
	
	public static void Reader(ArrayList<Employee> employees,String filename) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader(filename));
		String ch;
		while((ch=br.readLine())!=null){
			String[] employeeData=ch.split(",");
			Employee e=new Employee();
				e.setID(employeeData[0]);
				e.setAge(Integer.parseInt(employeeData[1]));
				e.setName(employeeData[2]);
				e.setWork(employeeData[3]);
				e.setSalary(Integer.parseInt(employeeData[4]));
				employees.add(e);			
			}
		br.close();	
	}

}
