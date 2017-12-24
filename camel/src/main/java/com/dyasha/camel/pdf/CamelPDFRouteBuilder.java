package com.dyasha.camel.pdf;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class CamelPDFRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("file:E:\\tools\\camel_workspace\\data_files?noop=true")
		.process(new Processor() {
            public void process(Exchange exchange) throws Exception {
           	 System.out.println("***************************************");
                System.out.println( exchange.getIn().getBody());
           	 System.out.println("***************************************");
            }
        })
//		.to("pdf:create");
		.to("fop:application/pdf");
		
	}//End of configure

}//End of Class
