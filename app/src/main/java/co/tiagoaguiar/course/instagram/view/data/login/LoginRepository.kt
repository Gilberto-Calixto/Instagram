package co.tiagoaguiar.course.instagram.view.data.login

class LoginRepository(private val dataSource: LoginDataSource) {

    fun login(email: String, passwor: String, callback: LoginCallback) {
        dataSource.login(email, passwor, callback)

    }
}