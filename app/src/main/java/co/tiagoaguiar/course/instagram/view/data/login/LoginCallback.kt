package co.tiagoaguiar.course.instagram.view.data.login

interface LoginCallback {
    fun onSucess()
    fun onFailure(message: String)
    fun onComplete()
}