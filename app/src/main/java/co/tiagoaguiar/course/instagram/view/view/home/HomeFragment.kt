package co.tiagoaguiar.course.instagram.view.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.course.instagram.R

class HomeFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //Config rcv
        val rcv = view.findViewById<RecyclerView>(R.id.rv_home_posts)
        rcv.layoutManager = LinearLayoutManager(requireContext())
        rcv.adapter = HomeAdapter()
    }

    private class HomeAdapter: RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): HomeAdapter.HomeViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_list_post, parent, false)
            return HomeViewHolder(view)
        }

        override fun onBindViewHolder(holder: HomeAdapter.HomeViewHolder, position: Int) {
            holder.bind(R.drawable.ic_insta_add)
        }

        override fun getItemCount() = 30

        inner class HomeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

            fun bind(image: Int) {

            }
        }

    }
}