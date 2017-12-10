package com.dyasha.myjavaapp.jaxb.generated;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

public class JaxbUnmarshallingExample {
	
	public static void main(String[] args) throws Exception {
	
		JAXBContext ctx = JAXBContext.newInstance(College.class);

		Unmarshaller unmarshal = ctx.createUnmarshaller();
		College data = (College)unmarshal.unmarshal(new File("D:\\CollegeData-EclipseXSD.xml"));
		
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(new File("C:\\Users\\Praveen\\College-Info-Eclipse1.xsd"));
		unmarshal.setSchema(schema);
		unmarshal.setEventHandler(new CollegeValidationEventHandler());
		
		System.out.println("College Name :- "+data.getCollegeName());
		for(StudentInfo stu : data.getStudentsData().getStudents()) {
			System.out.println("Reg. No. :- "+stu.getRegno());
			System.out.println("First Name :- "+stu.getFirstName());
			System.out.println("Last Name :- "+stu.getLastName());
		}
		
	}//End of Main
	
}//End of Class
