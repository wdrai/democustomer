package democustomer

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import grails.plugin.springsecurity.userdetails.GormUserDetailsService;

class CompanyPermissionEvaluator implements PermissionEvaluator {
	
	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
		Company company = authentication.principal.company;		
		if (targetDomainObject instanceof CompanyOwned) {
		 	if (targetDomainObject.companyId != null)
			 	return targetDomainObject.companyId == company.id
			else
				return targetDomainObject.id == null	// null company allowed only for new objects
		}
		
		return true;
	}
	
	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
		return true;
	}
	
}
