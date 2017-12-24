package com.dyasha.camel.gmail;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gae.mail.GMailBinding;
//This is NOT WORKING !!!
public class CamelGMailRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("timer://myTimer?fixedRate=true&period=60000")
		.setHeader(GMailBinding.GMAIL_SUBJECT, constant("Hello"))
		.setHeader(GMailBinding.GMAIL_TO, constant("praveen4students@gmail.com"))
		.process(new Processor() {
            public void process(Exchange exchange) throws Exception {
           	 System.out.println("***************************************");
                System.out.println( exchange.getIn().getBody());
                
                exchange.getIn().setBody("This is the TEST Mail ....");
                
                System.out.println( exchange.getIn().getBody());
                
//                exchange.getIn().addAttachment("xml-attachment.xml", new DataHandler(new FileDataSource("E:\\tools\\camel_workspace\\data_files\\some-data.xml")));  
//			    exchange.getIn().addAttachment("text-attachment.txt", new DataHandler(new FileDataSource("E:\\tools\\camel_workspace\\data_files\\some-data.txt"))); 
			    
           	 System.out.println("***************************************");
            }
        })
		.to("gmail://praveen4examples@gmail.com");
		
	}//End of configure

}//End of Class
