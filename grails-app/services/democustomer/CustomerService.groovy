package democustomer

import org.granite.tide.annotations.TideEnabled;
import org.springframework.transaction.annotation.Transactional;
import grails.plugin.springsecurity.annotation.Secured
import org.granite.tide.data.DataEnabled;

@TideEnabled
@Transactional
@Secured(['ROLE_USER'])
@DataEnabled(topic="customerTopic", publish=DataEnabled.PublishMode.ON_SUCCESS)
class CustomerService {
	
	def list(Object filter, int first, int max, String[] order, boolean[] desc) {
		if (max <= 0)
			max = 36
				
		def resultList = (order && order.length > 0) 
			? Customer.list(sort: order[0], order: desc[0] ? "desc" : "asc") 
			: Customer.list()
		
		def resultCount = Customer.count()
		
		[ resultList: resultList, resultCount: resultCount, firstResult: first, maxResults: max ]
    }
    
    def find(Object id) {
    	def customer = Customer.get(id)
    	return customer
    }

	def save(Object customer) {
		customer = customer.merge(flush:true)
		return customer
	}
	
	def remove(Object id) {
		def customer = Customer.get(id)
		if (customer)
			customer.delete()
	}
	
}
