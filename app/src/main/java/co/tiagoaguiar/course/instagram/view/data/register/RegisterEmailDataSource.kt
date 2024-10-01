package co.tiagoaguiar.course.instagram.view.data.register

interface RegisterEmailDataSource {

    fun create(email: String, callback: RegisterCallback)
}