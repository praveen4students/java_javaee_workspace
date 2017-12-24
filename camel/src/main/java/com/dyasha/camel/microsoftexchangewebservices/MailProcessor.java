package com.dyasha.camel.microsoftexchangewebservices;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.enumeration.property.WellKnownFolderName;
import microsoft.exchange.webservices.data.core.enumeration.service.ConflictResolutionMode;
import microsoft.exchange.webservices.data.core.service.item.EmailMessage;
import microsoft.exchange.webservices.data.core.service.item.Item;
import microsoft.exchange.webservices.data.core.service.schema.EmailMessageSchema;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.property.complex.InternetMessageHeaderCollection;
import microsoft.exchange.webservices.data.search.FindItemsResults;
import microsoft.exchange.webservices.data.search.ItemView;
import microsoft.exchange.webservices.data.search.filter.SearchFilter;

public class MailProcessor implements Processor {

	private boolean isOrderIdPresent;
	private String orderID;
	private ExchangeService service;
	private final String SAP_HEADER_ORDERID = "SAP_ORDER_ID";

	public void process(Exchange exchange) throws Exception {
		
		init();
		
		System.out.println("Reading the Mail from the Inbox ");

		ItemView view = new ItemView(50);
		FindItemsResults<Item> findResults;
		SearchFilter itemFilter = new SearchFilter.IsEqualTo(EmailMessageSchema.IsRead, false);

		do {
			findResults = service.findItems(WellKnownFolderName.Inbox, itemFilter, view);
			for (Item item : findResults.getItems()) {
				item.load();

				EmailMessage em = (EmailMessage) item;

				// Reading Header
				isOrderIdPresent = isOrderIdPresentInHeader(item.getInternetMessageHeaders());

				if (isOrderIdPresent) {
					System.out.println("Making SAP RFC Call ");
					// rfcUtil.makeSAPCall(orderID,
					// "https://owa.hmhpub.com/OWA/"+em.getWebClientReadFormQueryString());
					// rfcUtil.makeSAPCall("709642",
					// "https://owa.hmhpub.com/OWA/"+em.getWebClientReadFormQueryString());
					System.out.println(
							"************" + "https://owa.hmhpub.com/OWA/" + em.getWebClientReadFormQueryString());
					System.out.println("Successfully Made SAP RFC Call ");
				}

				em.setIsRead(true);
				em.update(ConflictResolutionMode.AlwaysOverwrite);
			}

			int i = view.getOffset();
			i += 50;
			view.setOffset(i);
		} while (findResults.isMoreAvailable());
	}

	public void init() {
		try {
			service = new ExchangeService(ExchangeVersion.Exchange2010_SP2);
			// service.setTraceEnabled(true);
			ExchangeCredentials credentials = new WebCredentials("praveen4examples@gmail.com", "Qwerty@1234");
			service.setCredentials(credentials);
//			service.setUrl(new URI("https://owa.hmhpub.com/EWS/Exchange.asmx"));
//			https://outlook.office365.com/owa/?realm=dyasha.onmicrosoft.com&exsvurl=1&ll-cc=1033&modurl=0
			service.autodiscoverUrl("praveen4examples@gmail.com");
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
	}

	private boolean isOrderIdPresentInHeader(InternetMessageHeaderCollection headers) {
		return true;
		/*
		 * //Reading Header for(InternetMessageHeader header : headers) {
		 * System.out.println("Header Name: "+header.getName()+" Header Value: "+header.
		 * getValue() );
		 * 
		 * if(header.getName().equalsIgnoreCase(SAP_HEADER_ORDERID)){ orderID =
		 * header.getValue(); break; } }//End of for
		 * 
		 * return isOrderIdPresentInHeader(orderID);
		 */
	}

	private boolean isOrderIdPresentInHeader(String orderId) {
		if (orderId == null || orderId.equals("")) {
			return false;
		}

		try {
			Integer.parseInt(orderId);
			return true;

		} catch (NumberFormatException e) {
			return false;
		}

		// To Test : Keep as of Now. Need to be removed
		/*
		 * processor.setRFCcallRequired(true); processor.setOrderID("709642"); return
		 * false;
		 */

	}// End of isOrderIdNotPresent()

}// End of Class
