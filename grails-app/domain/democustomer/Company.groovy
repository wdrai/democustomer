package democustomer


class Company implements java.io.Serializable {

    static constraints = {
	}
	
	String uid
	
	String name
	
	def beforeValidate() {
		if (uid == null)
			uid = java.util.UUID.randomUUID().toString();
	}
}
