package co.tiagoaguiar.course.instagram.view.view.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.tiagoaguiar.course.instagram.databinding.ActivityLoginBinding
import co.tiagoaguiar.course.instagram.view.common.TxtWatch
import co.tiagoaguiar.course.instagram.view.Login
import co.tiagoaguiar.course.instagram.view.presentation.login.LoginPresenter

class LoginActivity : AppCompatActivity(), Login.View {

    private lateinit var binding: ActivityLoginBinding
    override lateinit var presenter: Login.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = LoginPresenter(this)

        val email = binding.loginTextEmail
        val password = binding.loginTextPassword

        email.addTextChangedListener(watcher)
        email.addTextChangedListener(TxtWatch{
            displayEmailFailure(null)
        })

        password.addTextChangedListener(watcher)
        password.addTextChangedListener(TxtWatch{
            displayPasswordFailure(null)
        })

        val btnEnter: LoadingButton = binding.loginBtnEnter
        btnEnter.setOnClickListener {

            //Chamar o presenter
            presenter.login(email.toString(), password.toString())
        }

    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    private val watcher = TxtWatch {
        binding.loginBtnEnter.isEnabled = binding.loginTextEmail.text.toString().isNotEmpty()
                && binding.loginTextPassword.text.toString().isNotEmpty()
    }

    override fun showProgress(enabled: Boolean) {
        binding.loginBtnEnter.showProgress(enabled)
    }

    override fun displayEmailFailure(emailError: Int?) {
        binding.loginTextEmail.error = emailError?.let { getString(it) }
    }

    override fun displayPasswordFailure(passwordError: Int?) {
        binding.loginTextPassword.error = passwordError?.let { getString(it) }
    }

    override fun onUserAuthenticated() {
        //Ir para a tela principal

    }

    override fun onUserUnauthorized() {
        //Mostrar um Alerta
    }

}