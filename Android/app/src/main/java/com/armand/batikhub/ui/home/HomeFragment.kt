package com.armand.batikhub.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.armand.batikhub.R
import com.armand.batikhub.adapter.HomeAdapter
import com.armand.batikhub.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnInfo: ImageView = view.findViewById(R.id.btn_info)
        btnInfo.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_Page1Fragment)
        }

        // Inisialisasi RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = HomeAdapter() // Ganti dengan adapter Anda
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}