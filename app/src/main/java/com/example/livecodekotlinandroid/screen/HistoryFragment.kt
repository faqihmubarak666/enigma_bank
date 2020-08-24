package com.example.livecodekotlinandroid.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.livecodekotlinandroid.R
import com.example.livecodekotlinandroid.bank.BankViewModel
import com.example.livecodekotlinandroid.recycle_view.HistoryRecycleAdapter
import kotlinx.android.synthetic.main.fragment_history.*

class HistoryFragment : Fragment() {

    val bankViewModel by activityViewModels<BankViewModel>()
    lateinit var historyRecycleAdapter: HistoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        historyRecycleView.layoutManager = LinearLayoutManager(this.context)

        bankViewModel.allTransaction.observe(viewLifecycleOwner, Observer {
            historyRecycleAdapter = HistoryRecycleAdapter(it)
            historyRecycleView.adapter = historyRecycleAdapter
        })
        bankViewModel.getAllTransaction()
    }

}