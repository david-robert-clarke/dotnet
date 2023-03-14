package com.cdshop.services;
import org.apache.turbine.util.TurbineConfig;

public class CdshopListener implements javax.servlet.ServletContextListener {
    public void contextDestroyed(javax.servlet.ServletContextEvent sce) {
    }

    public void contextInitialized(javax.servlet.ServletContextEvent sce) {
	TurbineConfig tc = new TurbineConfig("../webapps/cdshop",
					     "TurbineResources.properties");
	tc.init();
	
    }
}
