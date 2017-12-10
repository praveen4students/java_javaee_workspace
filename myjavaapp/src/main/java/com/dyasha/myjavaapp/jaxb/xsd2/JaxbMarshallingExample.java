package com.dyasha.myjavaapp.jaxb.xsd2;

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
		
		JAXBContext ctx = JAXBContext.newInstance(CollegeInfo.class);
		System.out.println(ctx.getClass().getName());
		Marshaller marshaller = ctx.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(GenerateData.generate(), System.out);
		//marshaller.marshal(GenerateData.generate(), new File("D:\\CollegeData.xml"));
	}
}
