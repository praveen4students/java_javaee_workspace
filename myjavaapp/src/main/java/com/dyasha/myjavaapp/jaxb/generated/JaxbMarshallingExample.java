package com.dyasha.myjavaapp.jaxb.generated;

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
		marshaller.marshal(GenerateData.generate(), new File("D:\\CollegeData-EclipseXSD.xml"));
	}
}
