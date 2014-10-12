package democustomer


class Customer implements java.io.Serializable {

    static constraints = {
	}
	
	String uid
	
	String firstName
	
	String lastName
	
	Integer numberOfLogons = 0
	
	def beforeValidate() {
		if (uid == null)
			uid = java.util.UUID.randomUUID().toString();
			
		if (numberOfLogons == null)
			numberOfLogons = 0;
	}
}
