package com.example.to_do_list_iclub.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.to_do_list_iclub.R
import com.example.to_do_list_iclub.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    lateinit var binding:FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.login.setOnClickListener(View.OnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        })
         return binding.root

       // return inflater.inflate(R.layout.fragment_login, container, false)
    }

}