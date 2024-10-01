package co.tiagoaguiar.course.instagram.view.view.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.tiagoaguiar.course.instagram.R
import co.tiagoaguiar.course.instagram.databinding.FragmentRegisterEmailBinding
import co.tiagoaguiar.course.instagram.view.cases.RegisterEmail
import co.tiagoaguiar.course.instagram.view.common.TxtWatch

class RegisterEmailFragment: Fragment(R.layout.fragment_register_email), RegisterEmail.View {

    override lateinit var presenter: RegisterEmail.Presenter
    private var binding: FragmentRegisterEmailBinding? = null

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
                }

                emailRegisterUser?.addTextChangedListener(watcher)
                emailRegisterUser?.addTextChangedListener(TxtWatch{
                    displayEmailFailure(null)
                })
            }
        }

    }

    override fun displayEmailFailure(message: Int?) {

    }

    private val watcher = TxtWatch {
        binding?.registerEditEmail?.isEnabled = binding?.registerEditEmail?.text.toString().isNotEmpty()
//                && binding.loginTextPassword.text.toString().isNotEmpty()
    }

    override fun onDestroy() {
        //presenter.onDestroy()
        binding = null
        super.onDestroy()

    }


}