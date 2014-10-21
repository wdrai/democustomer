package democustomer

import org.springframework.security.core.GrantedAuthority;

import grails.plugin.springsecurity.userdetails.GrailsUser;

class CompanyUser extends GrailsUser {
	
	final Company company
	
	CompanyUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired,
		boolean accountNonLocked, Collection<GrantedAuthority> authorities, long id, Company company) {
		
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities, id)

		this.company = company
	}
}
