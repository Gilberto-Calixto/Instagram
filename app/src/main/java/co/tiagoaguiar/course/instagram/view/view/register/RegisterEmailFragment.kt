package co.tiagoaguiar.course.instagram.view.view.register

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import co.tiagoaguiar.course.instagram.R
import co.tiagoaguiar.course.instagram.databinding.FragmentRegisterEmailBinding
import co.tiagoaguiar.course.instagram.view.cases.RegisterEmail
import co.tiagoaguiar.course.instagram.view.common.DependencyInjector
import co.tiagoaguiar.course.instagram.view.common.TxtWatch
import co.tiagoaguiar.course.instagram.view.presentation.register.RegisterEmailPresenter

class RegisterEmailFragment: Fragment(R.layout.fragment_register_email), RegisterEmail.View {

    override lateinit var presenter: RegisterEmail.Presenter
    private var binding: FragmentRegisterEmailBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        presenter = RegisterEmailPresenter(this, DependencyInjector.registerEmailRepository())
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentRegisterEmailBinding.bind(view)
        binding?.let{
            with(it) {
                texteLogin.setOnClickListener {
                    activity?.finish()
                }

                val emailRegisterUser = binding?.registerEditEmail

                btnRegisterEmail.setOnClickListener {
                    presenter.create(emailRegisterUser?.text.toString())
                    goToPassworScreen(emailRegisterUser?.text.toString())
                }

                emailRegisterUser?.addTextChangedListener(watcher)
                emailRegisterUser?.addTextChangedListener(TxtWatch{
                    displayEmailFailure(null)
                })
            }
        }

    }

    override fun showProgress(enable: Boolean) {
        binding?.btnRegisterEmail?.showProgress(true)
    }

    override fun displayEmailFailure(message: Int?) {
        binding?.registerEditEmail?.error = message?.let { getString(it) }
    }

    override fun onEmailFailure(message: String) {
        binding?.registerEditEmail?.error = message
    }

    override fun goToPassworScreen(email: String) {
        val intent = Intent(requireContext(), RegisterPasswordFragment::class.java)
        intent.putExtra("emailRegister", email)
        startActivity(intent)
    }

    private val watcher = TxtWatch {
        binding?.btnRegisterEmail?.isEnabled = binding?.registerEditEmail?.text.toString().isNotEmpty()
//                && binding.loginTextPassword.text.toString().isNotEmpty()
    }

    override fun onDestroy() {
        //presenter.onDestroy()
        binding = null
        super.onDestroy()

    }


}