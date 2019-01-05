package j1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class StuFileOperate {
	public static void Writer(ArrayList<Student> students,String filename) throws IOException{
		BufferedWriter bw=new BufferedWriter(new FileWriter(filename));
		for(int i=0;i<students.size();i++) {
			Student s1=students.get(i);
			StringBuilder sb=new StringBuilder();
			sb.append(s1.getID()).append(",").append(s1.getAge()).append(",").append(s1.getName()).append(",").append(s1.getGrade());
			bw.write(sb.toString());
			bw.newLine();
			bw.flush();
		}
		bw.close();	
		
	}
	
	
	public static void Reader(ArrayList<Student> students,String filename) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader(filename));
		String ch;
		while((ch=br.readLine())!=null){
			String[] studentData=ch.split(",");
			Student s=new Student();
				s.setID(studentData[0]);
				s.setAge(Integer.parseInt(studentData[1]));
				s.setName(studentData[2]);
				s.setGrade(Double.parseDouble(studentData[3]));
				students.add(s);			
			}
		br.close();	
	}

}
