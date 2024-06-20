package com.armand.batikhub.ui.home

import HomeViewModel
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.armand.batikhub.LoginActivity
import com.armand.batikhub.R
import com.armand.batikhub.adapter.HomeAdapter
import com.google.firebase.auth.FirebaseAuth

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: HomeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as? AppCompatActivity)?.supportActionBar?.hide()
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), android.R.color.white)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            requireActivity().window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = HomeAdapter { batik ->
            val intent = batik.id?.let { DetailActivity.newIntent(context, it) }
            if (intent != null) {
                startActivity(intent)
            }
        }

        viewModel.batikList.observe(viewLifecycleOwner, Observer { batikList ->
            (recyclerView.adapter as HomeAdapter).setBatikList(batikList)
        })

        viewModel.message.observe(viewLifecycleOwner, Observer { message ->
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        })

        val btnInfo: ImageView = view.findViewById(R.id.btn_info)
        btnInfo.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_Page1Fragment)
        }

        val logoutButton: ImageView = view.findViewById(R.id.logout_btn)
        logoutButton.setOnClickListener {
            performLogout()
        }

        val searchButton = view.findViewById<Button>(R.id.btn_search)
        searchButton.setOnClickListener {
            val searchText = view.findViewById<EditText>(R.id.et_query).text.toString()
            viewModel.searchBatikByName(searchText)
        }

        viewModel.fetchBatik()
    }

    private fun performLogout() {
        FirebaseAuth.getInstance().signOut()
        Toast.makeText(context, "Logout successful", Toast.LENGTH_SHORT).show()
        val intent = Intent(context, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
    }
}