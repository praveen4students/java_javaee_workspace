package com.dyasha.myjavaapp.jaxb.generated;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

public class JaxbSchemaValidationExample {
	
	public static void main(String[] args) throws Exception {

		String xsd ="C:\\Users\\Praveen\\College-Info-Eclipse1.xsd";
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
        Schema schema = sf.newSchema(new File(xsd)); 
 
        JAXBContext jc = JAXBContext.newInstance(College.class);
 
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        unmarshaller.setSchema(schema);
//        unmarshaller.setEventHandler(new CollegeValidationEventHandler());
        College data = (College) unmarshaller.unmarshal(new File("d:\\CollegeData-EclipseXSD.xml"));
        System.out.println(data);
        
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setSchema(schema);
//        marshaller.setEventHandler(new CollegeValidationEventHandler());
        marshaller.marshal(GenerateData.generate(), System.out);
        
	}//End of Main
	
}//End of Class
