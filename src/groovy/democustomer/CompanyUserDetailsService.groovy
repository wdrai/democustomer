package democustomer

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import grails.plugin.springsecurity.userdetails.GormUserDetailsService;

class CompanyUserDetailsService extends GormUserDetailsService {

	protected UserDetails createUserDetails(Person person, Collection<GrantedAuthority> authorities) {
		
		new CompanyUser(person.username, person.password, person.enabled, !person.accountExpired, !person.passwordExpired,
				!person.accountLocked, authorities, person.id, person.company)
	}
}
