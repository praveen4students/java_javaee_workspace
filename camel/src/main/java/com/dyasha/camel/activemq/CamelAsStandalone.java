package com.dyasha.camel.activemq;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CamelAsStandalone {

	public static void main(String[] args) throws Exception {
		runCamelUsingRouteBuilders();
//		runCamelUsingXMLConfig();
	}
	
	public static void runCamelUsingRouteBuilders() throws Exception {

		CamelContext context = new DefaultCamelContext();
	    context.addRoutes(new CamelActiveMQRouteBuilder());
	    context.start();
		
	}//End of Main
	
	
	public static void runCamelUsingXMLConfig() throws Exception {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("camel-config.xml");
		context.start();
		//context.stop(); //Optional if you want to stop the Context
		
	}//End of runCamelUsingXMLConfig
	
}//End of Class
