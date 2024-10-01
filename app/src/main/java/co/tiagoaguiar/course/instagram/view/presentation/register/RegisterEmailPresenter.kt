package co.tiagoaguiar.course.instagram.view.presentation.register

import android.util.Patterns
import co.tiagoaguiar.course.instagram.R
import co.tiagoaguiar.course.instagram.view.cases.RegisterEmail
import co.tiagoaguiar.course.instagram.view.data.register.RegisterCallback
import co.tiagoaguiar.course.instagram.view.data.register.RegisterRepository

class RegisterEmailPresenter(
    var view: RegisterEmail.View?,
    private val repository: RegisterRepository
): RegisterEmail.Presenter {

    //chamar o repo. caso de sucesso
    override fun create(email: String) {
        //Validação dos campos
        val emailRegister = Patterns.EMAIL_ADDRESS.matcher(email).matches()

        when {

            !emailRegister -> { view?.displayEmailFailure(R.string.invalid_email) }
            emailRegister -> { repository.createUser(email, object: RegisterCallback{
                override fun onSucess(email: String) {
                    view?.goToPassworScreen(email)
                }

                override fun onFailure(message: String) {
                    view?.onEmailFailure(message)
                }

                override fun onComplete() {
                    view?.showProgress(false)
                }

            }) }
            else -> view?.displayEmailFailure(null)
        }

        //Chamar repository para criar user
    }

    override fun onDestroy() {
        view = null
    }
}