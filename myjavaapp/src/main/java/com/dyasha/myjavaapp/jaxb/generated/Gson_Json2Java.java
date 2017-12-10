package com.dyasha.myjavaapp.jaxb.generated;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.google.gson.Gson;

public class Gson_Json2Java {
	public static void main(String[] args) {
		Gson gson = new Gson();

		try (Reader reader = new FileReader("College2.json")) {
			// Convert JSON to Java Object
			College data = gson.fromJson(reader, College.class);
			System.out.println("College Name :- "+data.getCollegeName());
			for(StudentInfo stu : data.getStudentsData().getStudents()) {
				System.out.println("Reg. No. :- "+stu.getRegno());
				System.out.println("First Name :- "+stu.getFirstName());
				System.out.println("Last Name :- "+stu.getLastName());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}// End of main
}// End of Class
