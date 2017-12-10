package com.dyasha.myjavaapp.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JaxbUnmarshallingExample {
	
	public static void main(String[] args) throws JAXBException {
	
		JAXBContext ctx = JAXBContext.newInstance(StudentInfo.class);
		Unmarshaller unmarshal = ctx.createUnmarshaller();
		StudentInfo data = (StudentInfo)unmarshal.unmarshal(new File("StudentData.xml"));
		System.out.println(data);
	}//End of Main
	
}//End of Class
