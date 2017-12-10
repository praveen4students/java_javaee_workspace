package com.dyasha.myjavaapp.jaxb.generated;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonMarshallingExample {
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("D:\\college-info.json"), 
		GenerateData.generate());

		ObjectMapper mapper2 = new ObjectMapper();
		College data = mapper2.readValue(new File("D:\\college-info.json"), 
		College.class);

		System.out.println("College Name :- "+data.getCollegeName());
		for(StudentInfo stu : data.getStudentsData().getStudents()) {
			System.out.println("Reg. No. :- "+stu.getRegno());
			System.out.println("First Name :- "+stu.getFirstName());
			System.out.println("Last Name :- "+stu.getLastName());
		}
	}
}
