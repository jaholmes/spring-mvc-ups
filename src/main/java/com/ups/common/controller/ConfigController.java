package com.ups.common.controller;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ups.common.config.AppConfig;
import com.ups.common.config.WebServiceInfo;

@Controller
public class ConfigController {

	@Autowired
	AppConfig appConfig;
	
	@Autowired
	Properties cloudProperties;

	@RequestMapping(value="config", method = RequestMethod.GET)
	//public @ResponseBody String getConfig(@PathVariable String name) {
	public @ResponseBody String getConfig() {

		System.out.println("appconfig.url: " + appConfig.getUrl());
		System.out.println("appconfig.url2: " + appConfig.getUrl2());
		System.out.println("web service: " + getWebServiceInfo().toString());
		System.out.println("web service uri: " + getWebServiceInfo().getUri());
	    return "serviceInfo.uri: " + getWebServiceInfo().getUri();

	}
	
    public WebServiceInfo getWebServiceInfo() {
        CloudFactory cloudFactory = new CloudFactory();
        Cloud cloud = cloudFactory.getCloud();
        WebServiceInfo serviceInfo = (WebServiceInfo) cloud.getServiceInfo("my-ups");
        return serviceInfo; 
    }
	
}
