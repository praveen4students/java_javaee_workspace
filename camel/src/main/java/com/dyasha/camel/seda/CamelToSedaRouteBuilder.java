package com.dyasha.camel.seda;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class CamelToSedaRouteBuilder extends RouteBuilder{

	private int counter = 1;
	
	@Override
	public void configure() throws Exception {
		
		from("timer://myTimer?fixedRate=true&period=60000")
		.log("Sending Message to SEDA ...")
		.process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				exchange.getIn().setBody("Seda Message "+counter);
				counter++;
			}
		})
		.to("seda:camelSedaExample");
		
	}//End of configure

}//End of Class
