package isc.intake2.online_test.security;

import javax.servlet.Filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

import org.springframework.security.web.access.channel.ChannelProcessingFilter;

import isc.intake2.online_test.configurations.CORSFilter;
 
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
 
    private static final String RESOURCE_ID = "my_rest_api";
     
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID).stateless(false);
    }
 
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.anonymous().disable()
        .requestMatchers().antMatchers("/api/**")
        .and().authorizeRequests()
        .antMatchers("/api/**").permitAll()
        .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
 
}