package com.example.to_do_list_iclub.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.to_do_list_iclub.adapters.TaskAdapter
import com.example.to_do_list_iclub.Models.Taskmodel
import com.example.to_do_list_iclub.R
import com.example.to_do_list_iclub.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    var list = listOf<Taskmodel>(
        Taskmodel(false,"data Structure lecture1"),
        Taskmodel(true,"lecture 2"),
        Taskmodel(false,"lecture 3"),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding=DataBindingUtil.inflate<FragmentHomeBinding>(inflater,R.layout.fragment_home,container,false);
        var adapter=TaskAdapter()
        binding.RVLIST.adapter=adapter
        adapter.submitList(list)
        return binding.root
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


}