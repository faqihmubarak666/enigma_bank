package com.example.livecodekotlinandroid.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.livecodekotlinandroid.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), View.OnClickListener {

    lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController= Navigation.findNavController(view)

        button_transaction.setOnClickListener(this)
        button_history.setOnClickListener(this)
        button_phone.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            button_transaction -> {navController.navigate(R.id.action_homeFragment_to_recipientFragment)}
            button_history -> {navController.navigate(R.id.action_homeFragment_to_historyFragment)}
            button_phone -> {}

        }
    }

}