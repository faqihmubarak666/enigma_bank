package com.example.livecodekotlinandroid.screen.transaction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.livecodekotlinandroid.R
import kotlinx.android.synthetic.main.fragment_amount.*
import kotlinx.android.synthetic.main.fragment_recipient.*

class AmountFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        button_next_amount.setOnClickListener(this)

    }


    override fun onClick(v: View?) {
        when (v) {
            button_next_amount -> {
                navController.navigate(R.id.action_amountFragment_to_confirmationFragment)
            }
        }
    }
}