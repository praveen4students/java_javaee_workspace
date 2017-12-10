package com.dyasha.myjavaapp.jaxb.xsd2;

import com.dyasha.myjavaapp.jaxb.xsd2.CollegeInfo.StudentsData.Students;

public class GenerateData {
	
	public static CollegeInfo generate() {
		
		ObjectFactory fac = new ObjectFactory();
		CollegeInfo college = fac.createCollegeInfo();
		college.setCollegeName("DyaSha Teaching Institute ...");
		
		Students stu1 = fac.createCollegeInfoStudentsDataStudents();
		stu1.setRegno(1);
		stu1.setFirstName("AAA");
		stu1.setLastName("BBB");
		
		Students stu2 = fac.createCollegeInfoStudentsDataStudents();
		stu2.setRegno(2);
		stu2.setFirstName("XXX");
		stu2.setLastName("YYY");
		
		CollegeInfo.StudentsData stuData = fac.createCollegeInfoStudentsData();
		stuData.getStudents().add(stu1);
		stuData.getStudents().add(stu2);
		
		college.setStudentsData(stuData);
		
		return college;
	}
	
}
