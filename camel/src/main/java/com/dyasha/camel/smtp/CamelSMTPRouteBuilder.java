package com.dyasha.camel.smtp;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.util.ByteArrayDataSource;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;


public class CamelSMTPRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("ftp://ftp_user@localhost:21?delay=30s&delete=true&binary=true&password=qwerty&reconnectDelay=30000")
		.log("Uploading file ${file:name}")
//		.convertBodyTo(String.class)
		.process(new Processor() {
            public void process(Exchange exchange) throws Exception {
           	 System.out.println("***************************************");
                System.out.println( exchange.getIn().getBody());
                exchange.getIn().setHeader("Subject", "Praveen E-Mail !!!");
                exchange.getIn().setBody("This is the TEST Mail ....");
                System.out.println( exchange.getIn().getBody());
           	 System.out.println("***************************************");
            }
        })
		/*.process(new Processor() {
			
        	public void process(Exchange exchange) throws Exception { 
        		// the API is a bit clunky so we need to loop 
        		Map<String, DataHandler> attachments = exchange.getIn().getAttachments(); 
        		if (attachments.size() > 0) { 
        			for (String name : attachments.keySet()) { 
        				DataHandler dh = attachments.get(name); // get the file name 
        				String filename = dh.getName(); // get the content and convert it to byte[] 
        				byte[] data = exchange.getContext().getTypeConverter().convertTo(byte[].class, dh.getInputStream()); 
        				// write the data to a file 
        				FileOutputStream out = new FileOutputStream(filename); 
        				out.write(data); 
        				out.flush(); 
        				out.close(); 
        				} 
        			} 
        		}
        })*/
		.process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				Message in = exchange.getIn();
			    String fileBody = in.getBody(String.class);
			    String fileId = in.getHeader("CamelFileName",String.class);
			    in.addAttachment(fileId, new DataHandler(new ByteArrayDataSource(fileBody, "text/plain")));
			}
		})
		.process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				Message in = exchange.getIn();
				in.addAttachment("xml-attachment.xml", new DataHandler(new FileDataSource("E:\\tools\\camel_workspace\\data_files\\some-data.xml")));  
			    in.addAttachment("text-attachment.txt", new DataHandler(new FileDataSource("E:\\tools\\camel_workspace\\data_files\\some-data.txt"))); 
			}
		})
		.to("smtps://smtp.gmail.com:465?username=praveen4examples@gmail.com&password=Qwerty@1234&to=ultimatepravee@gmail.com");
	}//End of configure
}//End of Class
