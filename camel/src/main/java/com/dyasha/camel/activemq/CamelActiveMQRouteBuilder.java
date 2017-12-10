package com.dyasha.camel.activemq;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class CamelActiveMQRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {

		 from("activemq:queue:praveenQueue?jmsMessageType=Text")
		 //.convertBodyTo(String.class)
         .process(new Processor() {
             public void process(Exchange exchange) throws Exception {
            	 System.out.println("***************************************");
                 System.out.println( exchange.getIn().getBody());
            	 System.out.println("***************************************");
             }
         })
         .to("file:E://data/activemq/?fileExist=Append&fileName=ActiveMQMsg-${date:now:yyyyMMdd}.txt");
	}

}
