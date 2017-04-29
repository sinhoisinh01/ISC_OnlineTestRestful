package isc.intake2.online_test.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;

import isc.intake2.online_test.configurations.CORSFilter;
 
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
 
	 private static String REALM = "MY_OAUTH_REALM";
	    
	    
	 	@Autowired
	    private TokenStore tokenStore;
	 
	    @Autowired
	    private UserApprovalHandler userApprovalHandler;
	 
	    @Autowired
	    @Qualifier("authenticationManagerBean")
	    private AuthenticationManager authenticationManager;
	 
	    @Override
	    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
	    	
	        clients.inMemory()
	            .withClient("my-trusted-client")
	            .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
	            .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
	            .scopes("read", "write", "trust")
	            .secret("secret")
	            .accessTokenValiditySeconds(3600).//Access token is only valid for 60 minutes.
	            refreshTokenValiditySeconds(7200);//Refresh token is only valid for 120 minutes.
	    }
	 
	    @Override
	    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
	        endpoints.tokenStore(tokenStore).userApprovalHandler(userApprovalHandler)
	                .authenticationManager(authenticationManager).tokenEnhancer(tokenEnhancer());
	    }
	    
	    @Bean
	    @Primary
	    public AuthorizationServerTokenServices tokenServices(){
	    	DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
	    	defaultTokenServices.setTokenEnhancer(tokenEnhancer());
	    	defaultTokenServices.setTokenStore(tokenStore);
	    	
	    	return defaultTokenServices;
	    }
	    
	    @Bean
	    public TokenEnhancer tokenEnhancer() {
			// TODO Auto-generated method stub
			return new CustomTokenEnhancer();
		}

		@Override
	    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
	        oauthServer.realm(REALM + "/client");
	    }
 
}