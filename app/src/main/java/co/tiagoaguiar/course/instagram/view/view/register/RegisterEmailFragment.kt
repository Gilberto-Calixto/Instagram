package co.tiagoaguiar.course.instagram.view.view.register

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import co.tiagoaguiar.course.instagram.R
import co.tiagoaguiar.course.instagram.databinding.FragmentRegisterEmailBinding

class RegisterEmailFragment: Fragment(R.layout.fragment_register_email) {

    private lateinit var binding: FragmentRegisterEmailBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentRegisterEmailBinding.inflate(layoutInflater)

        binding.texteLogin.setOnClickListener {

        }
    }

}