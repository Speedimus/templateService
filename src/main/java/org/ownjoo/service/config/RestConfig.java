/**
 * Created by jwar0 on 2/20/17.
 */
package org.ownjoo.service.config;

import org.ownjoo.service.Application;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@ComponentScan(basePackages = "org.ownjoo")
public class RestConfig extends SpringBootServletInitializer
{
    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean()
    {
        return new LocalValidatorFactoryBean();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(Application.class);
    }
}
