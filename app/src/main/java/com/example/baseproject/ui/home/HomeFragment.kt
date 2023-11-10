package com.example.baseproject.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.baseproject.databinding.FragmentHomeBinding
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        binding.apply {
            rvCategory.layoutManager = GridLayoutManager(context, 2)
            rvCategory.setHasFixedSize(true)
            val adapter = CategoryAdapter(requireContext())
            rvCategory.adapter = adapter
            adapter.updateData(getCategoryList())
        }
    }

    private fun getCategoryList(): List<Category> {
        val list = mutableListOf<Category>()
        list.add(Category("Clothing & Apparel"))
        list.add(Category("Footwear & Shoes"))
        list.add(Category("Electronics & Gadgets"))
        list.add(Category("Games & Toys"))
        list.add(Category("Veterinary & Pet Items"))
        list.add(Category("Stationery"))
        list.add(Category("Hand & Power Tools"))
        list.add(Category("Tupperware"))
        list.add(Category("Furniture"))
        list.add(Category("Sports Products"))
        list.add(Category("Health & Beauty"))
        list.add(Category("Books"))
        list.add(Category("Art & Crafting"))
        return list
    }

    companion object {

        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}
