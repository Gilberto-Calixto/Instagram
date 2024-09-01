package co.tiagoaguiar.course.instagram.view.view.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.tiagoaguiar.course.instagram.databinding.FragmentRegisterUploadPhotoBinding
import co.tiagoaguiar.course.instagram.databinding.FragmentRegisterWelcomeBinding
import co.tiagoaguiar.course.instagram.view.common.CustomDialog

class RegisterPhotoFragment: Fragment() {

    private lateinit var binding: FragmentRegisterUploadPhotoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterUploadPhotoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val customDialog = CustomDialog(requireContext())
        customDialog.show()

    }
}