package com.example.livecodekotlinandroid.screen.transaction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.SurfaceControl
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.room.Transaction
import com.example.livecodekotlinandroid.R
import com.example.livecodekotlinandroid.bank.Bank
import com.example.livecodekotlinandroid.bank.BankViewModel
import kotlinx.android.synthetic.main.fragment_amount.*
import kotlinx.android.synthetic.main.fragment_recipient.*
import java.text.DateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class AmountFragment : Fragment(), View.OnClickListener {

    val bankViewModel by activityViewModels<BankViewModel>()
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
        val user_owner_id = arguments?.getString("user_owner_id")
        val destination = arguments?.getString("destination")
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val formatted = current.format(formatter)
        when (v) {
            button_next_amount -> {
                val transaction = Bank(
                    user_owner_id = user_owner_id!!.toInt(),
                    destination = destination.toString(),
                    trans_date = formatted,
                    amount = amount_input.text.toString().toInt(),
                    description = description_input.text.toString()
                )
                bankViewModel.saveTransaction(transaction)
                navController.navigate(
                    R.id.action_amountFragment_to_confirmationFragment,
                    bundleOf(
                        "description" to description_input.text.toString())
                )
            }
        }
    }
}
