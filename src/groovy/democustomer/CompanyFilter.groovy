package democustomer

import grails.plugin.springsecurity.SpringSecurityUtils;
import grails.plugin.springsecurity.userdetails.GrailsUser;

import org.granite.tide.data.DataObserveParams;
import org.granite.tide.data.DataPublishParams;
import org.granite.tide.data.DataTopicParams;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

class CompanyFilter implements DataTopicParams {

	@Override
	public void observes(DataObserveParams params) {
		if (SecurityContextHolder.getContext() == null)
			return;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication()
		if (authentication != null && authentication.principal != null)
			params.addValue("companyId", String.valueOf(authentication.principal.company?.id))
	}
	
	@Override
	public void publishes(DataPublishParams params, Object entity) {
		if (entity instanceof CompanyOwned)
			params.setValue("companyId", entity.company ? String.valueOf(entity.company.id) : "");
	}

}
