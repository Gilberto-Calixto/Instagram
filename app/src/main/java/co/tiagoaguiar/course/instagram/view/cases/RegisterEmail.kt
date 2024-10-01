package co.tiagoaguiar.course.instagram.view.cases

import androidx.annotation.StringRes
import co.tiagoaguiar.course.instagram.view.common.BasePresenter
import co.tiagoaguiar.course.instagram.view.common.BaseView

interface RegisterEmail {

    interface View: BaseView<Presenter> {
        fun showProgress(enable: Boolean)
        fun displayEmailFailure(@StringRes message: Int?)
        fun onEmailFailure(message: String)
        fun goToPassworScreen(email: String)
    }

    interface Presenter: BasePresenter {
        fun create(email: String)

    }
}