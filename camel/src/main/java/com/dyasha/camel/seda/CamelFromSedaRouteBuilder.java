package com.dyasha.camel.seda;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class CamelFromSedaRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("seda:camelSedaExample")
		.process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				System.out.println("SEDA Msg :- "+ exchange.getIn().getBody(String.class) );
			}
		});
		
	}//End of configure

}//End of Class
