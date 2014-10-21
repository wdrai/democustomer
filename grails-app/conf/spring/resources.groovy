import democustomer.CompanyPermissionEvaluator;
import democustomer.CompanyUserDetailsService;

// Place your Spring DSL code here
beans = {
	xmlns graniteds:"http://www.graniteds.org/config"
	graniteds."messaging-destination"('id': 'customerTopic', "no-local": true, 'session-selector': true)
	
	userDetailsService(CompanyUserDetailsService) {
		grailsApplication = ref('grailsApplication')
	}
	
	permissionEvaluator(CompanyPermissionEvaluator) {
	}	
}
