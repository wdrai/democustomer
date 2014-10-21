import democustomer.Person
import democustomer.Authority
import democustomer.PersonAuthority
import democustomer.Customer
import democustomer.Company
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit
import java.util.concurrent.Callable

class BootStrap {
	
	def randomLogonGeneratorService
	
	def persistenceInterceptor

    def init = { servletContext ->
		
		println "Init users"
		def company_example1 = new Company(name:"example1").save(flush:true)
		def company_example2 = new Company(name:"example2").save(flush:true)
		
		def user_admin = new Person(company:company_example1, username:"admin", password:"admin", enabled:true).save(flush:true)
		
		def user_user = new Person(company:company_example1, username:"user", password:"user", enabled:true).save(flush:true)
		
		def user_norole = new Person(company:company_example1, username:"norole", password:"norole", enabled:true).save(flush:true)

		def user_user2 = new Person(company:company_example2, username:"user2", password:"user2", enabled:true).save(flush:true)
		
		def role_admin = new Authority(description:"Admin", authority:"ROLE_ADMIN").save(flush:true)
		def role_user = new Authority(description:"User", authority:"ROLE_USER").save(flush:true)
		
		new PersonAuthority(person:user_admin, authority:role_admin).save(flush:true)
		new PersonAuthority(person:user_admin, authority:role_user).save(flush:true)
		new PersonAuthority(person:user_user, authority:role_user).save(flush:true)
		new PersonAuthority(person:user_user2, authority:role_user).save(flush:true)
		
		println "Init db"
        new Customer(company:company_example1, firstName: "Justin", lastName: "Hill").save(flush:true);
        new Customer(company:company_example1, firstName: "Pan", lastName: "Li").save(flush:true);
		new Customer(company:company_example2, firstName: "William", lastName: "Drai").save(flush:true);
		
		println "Start logon generator"
		ScheduledThreadPoolExecutor scheduledExecutor = new ScheduledThreadPoolExecutor(1);
		scheduledExecutor.scheduleAtFixedRate({
			persistenceInterceptor.init()
			try {
				randomLogonGeneratorService.generateLogon()
			} 
			finally {
				persistenceInterceptor.flush()
				persistenceInterceptor.destroy()
			}
		} as Runnable, 10, 10, TimeUnit.SECONDS)
    }
	
    def destroy = {
    }
}
