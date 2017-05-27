package isc.intake2.online_test.configurations;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.CharSet;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonInclude;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "isc.intake2.online_test")
public class RestApiConfig extends WebMvcConfigurerAdapter {
	
    @Bean(name = "multipartResolver")
    public StandardServletMultipartResolver resolver() {
        return new StandardServletMultipartResolver();
    }
	
}
