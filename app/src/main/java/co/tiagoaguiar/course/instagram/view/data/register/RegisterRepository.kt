package co.tiagoaguiar.course.instagram.view.data.register

class RegisterRepository(private val dataSource: RegisterEmailDataSource) {

    fun createUser(email: String, callback: RegisterCallback) {
        dataSource.create(email, callback)
    }
}
