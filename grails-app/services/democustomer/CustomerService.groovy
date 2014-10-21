package democustomer

import org.granite.tide.annotations.TideEnabled;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

import grails.plugin.springsecurity.annotation.Secured

import org.granite.tide.data.DataEnabled;

@TideEnabled
@Transactional
@Secured(['ROLE_USER'])
@DataEnabled(topic="customerTopic", publish=DataEnabled.PublishMode.ON_COMMIT, params=CompanyFilter.class, useInterceptor=true)
class CustomerService {
	
	def list(Object filter, int first, int max, String[] order, boolean[] desc) {
		if (max <= 0)
			max = 36
		
		Company company = SecurityContextHolder.getContext().getAuthentication().getPrincipal().company
		
		def resultList = (order && order.length > 0) 
			? Customer.findAllByCompany(company, [ offset: first, max: max, sort: order[0], order: desc[0] ? "desc" : "asc" ]) 
			: Customer.findAllByCompany(company, [ offset: first, max: max ])
		
		def resultCount = Customer.countByCompany(company)
		
		[ resultList: resultList, resultCount: resultCount, firstResult: first, maxResults: max ]
    }
    
	@PostAuthorize("hasPermission(returnObject, read)")
    def find(Object id) {
    	def customer = Customer.get(id)
    	return customer
    }
	
	@PreAuthorize("hasPermission(#customer, write)")
	def save(Object customer) {
		if (customer.id == null && customer.company == null)
			customer.company = SecurityContextHolder.getContext().getAuthentication().getPrincipal().company
		
		customer = customer.merge(flush:true)
		return customer
	}
	
	@PreAuthorize("hasPermission(#customer, delete)")
	def remove(Object customer) {
		customer = Customer.get(customer.id)
		if (customer)
			customer.delete()
	}
	
}
