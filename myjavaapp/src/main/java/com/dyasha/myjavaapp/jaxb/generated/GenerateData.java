package com.dyasha.myjavaapp.jaxb.generated;

import java.util.ArrayList;
import java.util.List;

import com.dyasha.myjavaapp.jaxb.generated.College.StudentsData;

public class GenerateData {
	
	public static College generate() {
		
		StudentInfo stu1 = new StudentInfo();
		stu1.setRegno(1);
		//stu1.setFirstName("AAA");
		stu1.setLastName("BBB");
		
		StudentInfo stu2 = new StudentInfo();
		stu2.setRegno(2);
		stu2.setFirstName("XXX");
		stu2.setLastName("YYY");

		StudentsData stuData = new StudentsData();
		stuData.getStudents().add(stu1);
		stuData.getStudents().add(stu2);
		
		College col = new College();
		col.setCollegeName("Jspiders");
		col.setStudentsData(stuData);	
		
		return col;
	}
}
