package com.dyasha.myjavaapp.jaxb.xsd;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * Hello world!
 *
 */
public class JaxbMarshallingExample {
	
	public static void main(String[] args) throws JAXBException {
		
		JAXBContext ctx = JAXBContext.newInstance(College.class);
		Marshaller marshaller = ctx.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(GenerateData.generate(), System.out);
		System.out.println("=========================================");
		marshaller.marshal(GenerateData.generate2(), System.out);
		//marshaller.marshal(GenerateData.generate(), new File("D:\\CollegeData.xml"));
	}
}
