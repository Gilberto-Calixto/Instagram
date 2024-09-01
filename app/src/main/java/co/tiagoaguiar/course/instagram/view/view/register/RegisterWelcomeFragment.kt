package co.tiagoaguiar.course.instagram.view.view.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.tiagoaguiar.course.instagram.databinding.FragmentRegisterWelcomeBinding

class RegisterWelcomeFragment: Fragment() {

    private lateinit var binding: FragmentRegisterWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }
}