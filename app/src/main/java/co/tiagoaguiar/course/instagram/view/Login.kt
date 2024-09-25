package co.tiagoaguiar.course.instagram.view

import co.tiagoaguiar.course.instagram.view.common.BasePresenter
import co.tiagoaguiar.course.instagram.view.common.BaseView

interface Login {

    //Camada de View: Ações desse caso de uso
    interface View: BaseView<Presenter> {
        fun showProgress(enabled: Boolean)
        fun displayEmailFailure(emailError: Int?)
        fun displayPasswordFailure(passwordError: Int?)
        fun onUserAuthenticated()
        fun onUserUnauthorized()
    }

    interface Presenter: BasePresenter {
        fun login(email: String, password: String)
    }
}