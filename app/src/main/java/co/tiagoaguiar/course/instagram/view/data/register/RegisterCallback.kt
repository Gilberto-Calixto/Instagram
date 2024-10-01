package co.tiagoaguiar.course.instagram.view.data.register

interface RegisterCallback {
    fun onSucess(email: String)
    fun onFailure(message: String)
    fun onComplete()
}