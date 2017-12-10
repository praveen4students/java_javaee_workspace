package com.dyasha.camel.activemq.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="college-info")
public class College {
	private String collegeName;
	private List<StudentInfo> students;
	
	@XmlElement(name="college-name")
	public String getCollegeName() {
		return collegeName;
	}
	
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	
	@XmlElementWrapper(name="students-data")
	public List<StudentInfo> getStudents() {
		return students;
	}
	public void setStudents(List<StudentInfo> students) {
		this.students = students;
	}
}
