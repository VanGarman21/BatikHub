package com.armand.batikhub.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.armand.batikhub.BatikItem
import com.armand.batikhub.databinding.FragmentRiwayatBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class HistoryFragment : Fragment() {

    private var _binding: FragmentRiwayatBinding? = null
    private val binding get() = _binding!!
    private lateinit var database: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRiwayatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        database = FirebaseDatabase.getInstance().getReference("batik")

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        loadData()
    }

    private fun loadData() {
        val currentUser = FirebaseAuth.getInstance().currentUser
        val userId = currentUser?.uid

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val batikList = mutableListOf<BatikItem>()
                for (snapshot in dataSnapshot.children) {
                    val batik = snapshot.getValue(BatikItem::class.java)
                    if (batik?.userId == userId) {  // Filter berdasarkan userId
                        if (batik != null) {
                            batikList.add(batik)
                        }
                    }
                }
                if (_binding != null) {
                    binding.recyclerView.adapter = BatikAdapter(batikList)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle possible errors
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}