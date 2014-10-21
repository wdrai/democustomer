package democustomer


class Customer implements CompanyOwned, java.io.Serializable {

    static constraints = {
	}
	
	String uid
	
	String firstName
	
	String lastName
	
	Company company
	
	Integer numberOfLogons = 0
	
	def beforeValidate() {
		if (uid == null)
			uid = java.util.UUID.randomUUID().toString();
			
		if (numberOfLogons == null)
			numberOfLogons = 0;
	}
}
