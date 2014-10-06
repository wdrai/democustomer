package democustomer

import org.granite.tide.annotations.TideEnabled;
import org.springframework.transaction.annotation.Transactional;
import grails.plugin.springsecurity.annotation.Secured
import org.granite.tide.data.DataEnabled;

@TideEnabled
@Transactional
@Secured(['ROLE_USER'])
@DataEnabled(topic="customerTopic", publish=DataEnabled.PublishMode.ON_SUCCESS)
class CustomerController {
	
    def index() { }
	
	def scaffold = Customer
}
