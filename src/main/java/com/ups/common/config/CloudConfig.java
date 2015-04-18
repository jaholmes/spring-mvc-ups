package com.ups.common.config;

import java.util.Properties;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.config.java.CloudScan;
import org.springframework.cloud.config.java.ServiceScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@CloudScan
@ServiceScan
@Profile({"cloud","local"})
public class CloudConfig extends AbstractCloudConfig {

	@Bean
	public Properties cloudProperties() {
		return properties();
	}

}
