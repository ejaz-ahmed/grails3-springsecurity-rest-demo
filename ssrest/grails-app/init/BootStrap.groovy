import demo.Book
import demo.auth.Role
import demo.auth.User
import demo.auth.UserRole

class BootStrap {

    def init = { servletContext ->
        def adminRole = new Role('ROLE_ADMIN').save(failOnError: true)
        def userRole = new Role('ROLE_USER').save(failOnError: true)

        def testUser1 = new User('his', 'his').save(failOnError: true)
        def testUser2 = new User('her', 'her').save(failOnError: true)

        UserRole.create testUser1, adminRole, true
        UserRole.create testUser2, adminRole, true

        new Book(title: "Book1", price: 223.1).save(failOnError: true)
        new Book(title: "Book2", price: 23.1).save(failOnError: true)
    }
    def destroy = {
    }
}
