package com.ups.common.config;

import org.springframework.cloud.cloudfoundry.CloudFoundryServiceInfoCreator;
import org.springframework.cloud.cloudfoundry.Tags;

import java.util.Map;

public class WebServiceInfoCreator extends CloudFoundryServiceInfoCreator<WebServiceInfo> {

    public static final String WS_TAG = "ws1";

    public WebServiceInfoCreator() {
        super(new Tags(WS_TAG));
    }

    @Override
    public boolean accept(Map<String, Object> serviceData) {
    	System.out.println("accept...");
        Map<String, Object> credentials = getCredentials(serviceData);
        String tag = (String) credentials.get("tag");
    	System.out.println("tag: " + tag);
        return super.accept(serviceData) || WS_TAG.equals(tag);
    }

    @Override
    public WebServiceInfo createServiceInfo(Map<String, Object> serviceData) {
        String id = (String) serviceData.get("name");

        Map<String, Object> credentials = getCredentials(serviceData);
        String uri = getStringFromCredentials( credentials, "uri", "url");

    	System.out.println("uri: " + uri);
        return new WebServiceInfo(id, uri);
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> getCredentials(Map<String, Object> serviceData) {
        return (Map<String, Object>) serviceData.get("credentials");
    }
}
