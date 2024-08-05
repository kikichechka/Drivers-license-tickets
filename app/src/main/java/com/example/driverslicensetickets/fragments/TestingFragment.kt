package com.example.driverslicensetickets.fragments

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.driverslicensetickets.R
import com.example.driverslicensetickets.databinding.FragmentTestingBinding
import com.example.driverslicensetickets.model.IncorrectTicket
import com.example.driverslicensetickets.model.ListInCorrectTickets
import com.example.driverslicensetickets.model.ListTickets
import com.example.driverslicensetickets.model.Ticket
import com.example.driverslicensetickets.model.mapToInCorrect
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TestingFragment : Fragment() {
    private lateinit var adapter: TestingAdapter
    private val listIncorrectAnswers = mutableListOf<IncorrectTicket>()

    private var _binding: FragmentTestingBinding? = null
    private val binding: FragmentTestingBinding
        get() = _binding!!
    private var paramTask: ListTickets? = null
    private val listTestTickets: MutableList<Ticket> = mutableListOf()

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            if (it != null) {
                paramTask = if (Build.VERSION.SDK_INT >= 33)
                    it.getParcelable(ARG_PARAM_TASK, ListTickets::class.java)
                else
                    it.getParcelable(ARG_PARAM_TASK)
                paramTask?.list?.let { it1 -> listTestTickets.addAll(it1) }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTestingBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.topAppBar.title = "${binding.topAppBar.title} ${paramTask?.nameCategory}"
        adapter = TestingAdapter(click = { position -> defineAnswer(position) }, listOf())
        binding.recycler.adapter = adapter
        binding.topAppBar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }
        showTicket()
    }

    private fun showTicket() {
        val uri = Uri.parse("$URI_STRING${listTestTickets.first().image.substring(1)}")
        Glide.with(requireContext())
            .load(uri)
            .fitCenter()
            .into(binding.image)
        binding.question.text = listTestTickets.first().question
        changeListAdapter()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun changeListAdapter() {
        adapter.changeList(listTestTickets.first().answers)
        adapter.notifyDataSetChanged()
    }

    private fun defineAnswer(position: Int) {
        if (listTestTickets.isNotEmpty() && !listTestTickets.first().answers[position].isCorrect)
            listIncorrectAnswers.add(listTestTickets.first().mapToInCorrect(position))
        Log.d("@@@", listIncorrectAnswers.size.toString())
        listTestTickets.removeFirstOrNull()
        if (listTestTickets.isNotEmpty()) {
            showTicket()
        } else {
            val listInCorrectTickets = ListInCorrectTickets(listIncorrectAnswers)
            val bundle = Bundle().apply {
                putParcelable(
                    TestResultsFragment.ARG_PARAM_TASK_RESULT,
                    listInCorrectTickets
                )
            }
            findNavController().navigate(R.id.action_testingFragment_to_testResultsFragment, bundle)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val ARG_PARAM_TASK = "ARG_PARAM_TASK"
        const val URI_STRING = "https://comandosfru.xyz/pdd/"
    }
}
