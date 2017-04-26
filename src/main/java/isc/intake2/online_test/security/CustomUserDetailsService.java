package isc.intake2.online_test.security;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import isc.intake2.online_test.entities.User;
import isc.intake2.online_test.entities.UserType;
import isc.intake2.online_test.services.IUserService;

@Service("customUserDetailsService")

public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private IUserService userService;
	
	public CustomUserDetailsService(){};
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user = userService.findByName(username);
		if(user == null){
			throw new UsernameNotFoundException("Username not found!");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getUserEncPassword(),true,true,true,true,getGrantedAuthorities(user));
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(User user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		UserType userType = user.getUserType();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + userType.getUserTypeName()));
		return authorities;
	}
}
