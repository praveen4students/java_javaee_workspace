package com.dyasha.camel.ftp;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class CamelFTPRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("ftp://ftp_user@localhost:21?delay=30s&delete=true&binary=true&password=qwerty&reconnectDelay=30000")
		.log("Uploading file ${file:name}")
//		.convertBodyTo(String.class)
		.process(new Processor() {
            public void process(Exchange exchange) throws Exception {
           	 System.out.println("***************************************");
                System.out.println( exchange.getIn().getBody());
           	 System.out.println("***************************************");
            }
        })
        .to("file:E:\\tools\\camel_workspace\\ftp_files?fileExist=Append&fileName=FTPfile-${date:now:yyyyMMdd}.txt");
	}//End of configure
}//End of Class
