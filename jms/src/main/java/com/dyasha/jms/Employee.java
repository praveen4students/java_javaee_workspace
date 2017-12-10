package com.dyasha.jms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="student-info")
@XmlType(propOrder={"regno","firstname","lastname"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
	public Employee() {
		super();
	}
	public Employee(int regno, String firstname, String lastname) {
		super();
		this.regno = regno;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	@XmlElement(name="reg-num")
	private int regno;
	
	@XmlElement(name="first-name")
	private String firstname;
	
	@XmlElement(name="last-name")
	private String lastname;

	public int getRegno() {
		return regno;
	}
	public void setRegno(int regno) {
		this.regno = regno;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
	public String toString() {
		return "StudentInfo [regno=" + regno + ", firstname=" + firstname + ", lastname=" + lastname + "]" + "\n";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + regno;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (regno != other.regno)
			return false;
		return true;
	}
}
