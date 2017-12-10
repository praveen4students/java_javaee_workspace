package com.dyasha.myjavaapp.jaxb;

import java.util.ArrayList;
import java.util.List;

public class GenerateData {
	
	public static College generate() {
		
		StudentInfo stu1 = new StudentInfo();
		stu1.setRegno(1);
		stu1.setFirstName("AAA");
		stu1.setLastName("BBB");
		
		StudentInfo stu2 = new StudentInfo();
		stu2.setRegno(2);
		stu2.setFirstName("XXX");
		stu2.setLastName("YYY");

		List<StudentInfo> stuList = new ArrayList<StudentInfo>();
		stuList.add(stu1);
		stuList.add(stu2);
		
		College col = new College();
		col.setCollegeName("Jspiders");
		col.setStudents(stuList);	
		
		return col;
	}
}
