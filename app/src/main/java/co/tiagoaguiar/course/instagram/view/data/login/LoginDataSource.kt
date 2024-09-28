package co.tiagoaguiar.course.instagram.view.data.login

interface LoginDataSource {
    fun login(email: String, password: String, callback: LoginCallback )
}