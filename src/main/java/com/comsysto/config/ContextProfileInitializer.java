package com.comsysto.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.context.ConfigurableWebApplicationContext;

/**
 * @author sekibomazic
 */
public class ContextProfileInitializer implements ApplicationContextInitializer<ConfigurableWebApplicationContext> {

    @Override
    public void initialize(ConfigurableWebApplicationContext applicationContext) {

        ConfigurableEnvironment environment = applicationContext.getEnvironment();

        // add some logic to decide which profile should be active
        String[] profiles = getProfiles();

        environment.setActiveProfiles(profiles);
    }

    // Change this as you need
    private String[] getProfiles() {
        return new String[] { "dev" };
    }

}