package co.tiagoaguiar.course.instagram.view.view

interface Login {

    //Camada de View: Ações desse caso de uso
    interface View {
        fun showProgress(enabled: Boolean)
        fun displayEmailFailure(emailError: Int?)
        fun displayPasswordFailure(passwordError: Int?)
        fun onUserAuthenticated()
        fun onUserUnauthorized()
    }
}