package com.dyasha.myjavaapp.jaxb.xsd;

import java.util.ArrayList;
import java.util.List;

import com.dyasha.myjavaapp.jaxb.xsd.College.StudentsData;

public class GenerateData {
	
	public static College generate() {
		
		ObjectFactory fac = new ObjectFactory();
		College college = fac.createCollege();
		college.setCollegeName("DyaSha Teaching Institute ...");
		
		StudentInfo stu1 = fac.createStudentInfo();
		stu1.setRegno(1);
		stu1.setFirstName("AAA");
		stu1.setLastName("BBB");
		
		StudentInfo stu2 = fac.createStudentInfo();
		stu2.setRegno(2);
		stu2.setFirstName("XXX");
		stu2.setLastName("YYY");
		
		College.StudentsData stuData = fac.createCollegeStudentsData();
		stuData.getStudents().add(stu1);
		stuData.getStudents().add(stu2);
		
		college.setStudentsData(stuData);
		
		return college;
	}
	
	public static College generate2() {
		
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
		
		StudentsData stuData = new ObjectFactory().createCollegeStudentsData();
		stuData.getStudents().addAll(stuList);
		
		College col = new College();
		col.setCollegeName("Jspiders");
		col.setStudentsData(stuData);	
		
		return col;
	}
	
}
