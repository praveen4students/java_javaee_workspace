package com.dyasha.camel.microsoftexchangewebservices;

import org.apache.camel.builder.RouteBuilder;

public class CamelMicrosoftEWSRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("timer://myTimer?fixedRate=true&period=60000")
		.process(new MailProcessor());
		
	}//End of configure

}//End of Class
