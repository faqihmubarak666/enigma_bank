package com.example.livecodekotlinandroid.screen.transaction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.livecodekotlinandroid.R
import com.example.livecodekotlinandroid.bank.Bank
import com.example.livecodekotlinandroid.bank.BankViewModel
import kotlinx.android.synthetic.main.fragment_amount.*
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_recipient.*

class RecipientFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    val bankViewModel by activityViewModels<BankViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        button_next_recipient.setOnClickListener(this)

    }


    override fun onClick(v: View?) {
        when (v) {
            button_next_recipient -> {
                navController.navigate(
                    R.id.action_recipientFragment_to_amountFragment,
                    bundleOf(
                        "user_owner_id" to id_transaction_input.text.toString(),
                        "destination" to destination_input.text.toString()
                    )
                )
            }
        }
    }
}