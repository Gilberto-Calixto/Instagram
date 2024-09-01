package co.tiagoaguiar.course.instagram.view.view.login

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import co.tiagoaguiar.course.instagram.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = binding.loginTextEmail
        val password = binding.loginTextPassword

        email.addTextChangedListener(watcher)
        password.addTextChangedListener(watcher)

        val btnEnter: LoadingButton = binding.loginBtnEnter
        btnEnter.setOnClickListener {
            btnEnter.showProgress(true)


            email.error = "E-mail inválido"
            password.error = "Senha inválida"

            Handler(Looper.getMainLooper()).postDelayed({
                btnEnter.showProgress(false)
            }, 2000)
        }

    }

    private val watcher = object: TextWatcher{
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            binding.loginBtnEnter.isEnabled = p0.toString().isNotEmpty()
        }

        override fun afterTextChanged(p0: Editable?) {
        }

    }
}