package com.example.intern.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.intern.TheProject
import com.example.intern.UserViewModel
import com.example.intern.databinding.FragmentHomeBinding
import com.example.intern.rv_adapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var mUserViewModel:UserViewModel
    private lateinit var rv:RecyclerView
    var set = 0;
    private var length = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root




        rv = binding.rvHome

        rv.layoutManager = LinearLayoutManager(requireContext())


        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        mUserViewModel.readData.observe(viewLifecycleOwner, Observer { data ->
            rv.adapter = rv_adapter(data)
            length = data.size
        })

        val add = binding.btnHome
        add.setOnClickListener {
            insertData()
        }






        return root
    }

    private fun insertData() {
        val content = mutableListOf<String>("Hello","Hi","See you soon","How are you","Bye Bye","Yes","No")
        val data = TheProject(0,content.random().toString())
        mUserViewModel.add(data)
        length += 1
        Toast.makeText(requireContext(),"Data added",Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}