package co.tiagoaguiar.course.instagram.view.view.login

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import co.tiagoaguiar.course.instagram.databinding.ActivityLoginBinding
import co.tiagoaguiar.course.instagram.databinding.ActivityMainBinding
import co.tiagoaguiar.course.instagram.view.common.TxtWatch
import co.tiagoaguiar.course.instagram.view.view.Login

class LoginActivity : AppCompatActivity(), Login.View {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = binding.loginTextEmail
        val password = binding.loginTextPassword

        email.addTextChangedListener(watcher)
        password.addTextChangedListener(watcher)

        val btnEnter: LoadingButton = binding.loginBtnEnter
        btnEnter.setOnClickListener {
            //Chamar o presenter
        }

    }

    private val watcher = TxtWatch {
        binding.loginBtnEnter.isEnabled = it.isNotEmpty()
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