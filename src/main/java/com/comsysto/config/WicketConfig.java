package com.comsysto.config;

import com.comsysto.WicketApplication;
import org.springframework.context.annotation.*;

/**
 * @author sekibomazic
 */

@Configuration
@Import({JpaConfig.class})
@ComponentScan(basePackages = "com.comsysto")
public class WicketConfig {

    @Bean
    public WicketApplication webApplication() {
        return new WicketApplication();
    }

}