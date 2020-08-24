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
        val detination = arguments?.getString("destination")
        val trans_date = arguments?.getString("trans_date")
        when (v) {
            button_next_amount -> {
                val transaction = Bank(
                    destination = detination.toString(),
                    trans_date = trans_date.toString(),
                    amount = amount_input.text.toString(),
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
