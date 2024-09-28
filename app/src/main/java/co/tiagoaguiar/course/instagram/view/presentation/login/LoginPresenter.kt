package co.tiagoaguiar.course.instagram.view.presentation.login

import android.util.Patterns
import co.tiagoaguiar.course.instagram.R
import co.tiagoaguiar.course.instagram.view.Login
import co.tiagoaguiar.course.instagram.view.data.login.LoginCallback
import co.tiagoaguiar.course.instagram.view.data.login.LoginRepository
import java.util.regex.Pattern

class LoginPresenter(
    var view: Login.View?,
    private val repository: LoginRepository
): Login.Presenter {
    override fun login(email: String, password: String) {

        val trimEmail = email.trim()
        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(trimEmail).matches()
        val isPasswordValid = password.length >= 8

        //Validação
        if (!isEmailValid) {
            view?.displayEmailFailure(R.string.invalid_email)
        } else {
            view?.displayEmailFailure(null)
        }

        if (password.length < 8) {
            view?.displayPasswordFailure(R.string.invalid_password)
        } else {
            view?.displayPasswordFailure(null)
        }

        //exibir resultado
        if (isEmailValid && isPasswordValid) {
            view?.showProgress(true)

            repository.login(email, password, object: LoginCallback{
                override fun onSucess() {
                    //informar que o user está autprizado
                    view?.onUserAuthenticated()
                }

                override fun onFailure(message: String) {
                    view?.onUserUnauthorized(message)
                }

                override fun onComplete() {
                    view?.showProgress(false)
                }

            })
        }

    }

    override fun onDestroy() {
        view = null
    }
}