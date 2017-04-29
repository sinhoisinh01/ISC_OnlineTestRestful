package isc.intake2.online_test.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import isc.intake2.online_test.services.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;


public class CustomTokenEnhancer implements TokenEnhancer{
	
	@Autowired
	private UserServiceImpl userService;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		// TODO Auto-generated method stub
		isc.intake2.online_test.entities.User user = userService.findByName(((User) authentication.getPrincipal()).getUsername());
		final Map<String, Object> additionalInfo = new HashMap<String, Object>();
		additionalInfo.put("userId",user.getId());
		additionalInfo.put("fullName", user.getUserFirstName() + " " + user.getUserLastName());
		additionalInfo.put("userRole", user.getUserType().getUserTypeName());
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
		return accessToken;
	}

}
