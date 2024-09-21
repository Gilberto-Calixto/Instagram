package co.tiagoaguiar.course.instagram.view.view.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.course.instagram.R
import co.tiagoaguiar.course.instagram.databinding.ActivityLoginBinding
import co.tiagoaguiar.course.instagram.databinding.FragmentProfileBinding

class FragmentProfile: Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val rv = binding.rcvProfile
        rv.layoutManager = GridLayoutManager(requireContext(), 3)
        rv.adapter = PostAdapter()


    }

    private class PostAdapter(): RecyclerView.Adapter<PostAdapter.PostViewHolder>(){
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): PostAdapter.PostViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_profile_grid, parent, false)
            return PostViewHolder(view)
        }

        override fun onBindViewHolder(holder: PostAdapter.PostViewHolder, position: Int) {
            holder.bind(R.drawable.ic_insta_add)
        }

        override fun getItemCount(): Int {
            return 30
        }

        inner class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

            fun bind(image: Int) {
                itemView.findViewById<ImageView>(R.id.item_rcv_grid_profile).setImageResource(image)
            }
        }


    }
}