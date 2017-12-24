package com.dyasha.camel.common;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.main.Main;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dyasha.camel.activemq.CamelActiveMQRouteBuilder;
import com.dyasha.camel.ftp.CamelFTPRouteBuilder;
import com.dyasha.camel.microsoftexchangewebservices.CamelMicrosoftEWSRouteBuilder;
import com.dyasha.camel.smtp.CamelSMTPRouteBuilder;

public class CamelAsStandalone {

	public static void main(String[] args) throws Exception {
        Main main = new Main();
        
        /*main.addRouteBuilder(new CamelFTPRouteBuilder());
        main.addRouteBuilder(new CamelActiveMQRouteBuilder());
        main.addRouteBuilder(new CamelSMTPRouteBuilder());*/
//        main.addRouteBuilder(new CamelGMailRouteBuilder());
        main.addRouteBuilder(new CamelMicrosoftEWSRouteBuilder());

        main.run();
    }
	
	public static void main2(String[] args) throws Exception {
		runCamelUsingRouteBuilders();
//		runCamelUsingXMLConfig();
	}
	
	public static void runCamelUsingRouteBuilders() throws Exception {

		CamelContext context = new DefaultCamelContext();
//	    context.addRoutes(new CamelActiveMQRouteBuilder());
	    context.addRoutes(new CamelFTPRouteBuilder());
	    context.start();
		
	}//End of Main
	
	
	public static void runCamelUsingXMLConfig() throws Exception {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("camel-config.xml");
		context.start();
		//context.stop(); //Optional if you want to stop the Context
		
	}//End of runCamelUsingXMLConfig
	
}//End of Class
