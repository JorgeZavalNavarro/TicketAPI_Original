package com.enlacetpe.ticketapi.caService.serviceDesk;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:webServiceConection.properties"})
public interface AppProps extends Config {

	@Key("ca.user")
	String user();
	
	@Key("ca.pass")
	String pass();
	
}
