package democustomer

import org.granite.tide.data.DataEnabled;
import org.springframework.transaction.annotation.Transactional;

@DataEnabled(topic="customerTopic", publish=DataEnabled.PublishMode.ON_COMMIT, useInterceptor=true)
class RandomLogonGeneratorService {

    def generateLogon() {
		int count = Customer.count()
		if (count == 0)
			return;
		
		int id = new java.util.Random().nextInt(count) + 1;
		
		Customer customer = Customer.get(id);
		if (customer != null) {
			println "Update customer " + customer.id + " (version " + customer.version + ")"
			customer.numberOfLogons++;
			customer.save(flush: true);
		}
    }
}
