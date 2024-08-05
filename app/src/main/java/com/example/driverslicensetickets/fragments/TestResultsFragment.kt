package com.example.driverslicensetickets.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.example.driverslicensetickets.R
import com.example.driverslicensetickets.databinding.FragmentTestResultsBinding
import com.example.driverslicensetickets.model.ListInCorrectTickets
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TestResultsFragment : Fragment() {
    private var _binding: FragmentTestResultsBinding? = null
    private val binding: FragmentTestResultsBinding
        get() = _binding!!

    private var paramTask: ListInCorrectTickets? = null

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            paramTask = if (Build.VERSION.SDK_INT >= 33)
                it.getParcelable(ARG_PARAM_TASK_RESULT, ListInCorrectTickets::class.java)
            else
                it.getParcelable(ARG_PARAM_TASK_RESULT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTestResultsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        paramTask?.list?.size?.let {
            binding.countCorrectAnswers.text = (20 - it).toString()
            binding.progressIndicator.progress = (20 - it).times(5)
        }


        paramTask?.let {
            binding.myMistakes.setOnClickListener { _ ->
                val bundle = Bundle().apply {
                    putParcelable(MistakesFragment.ARG_PARAM_TASK_MISTAKES, it)
                }
                findNavController().navigate(
                    R.id.action_testResultsFragment_to_mistakesFragment,
                    bundle
                )
            }
        }
        binding.buttonRepeatTest.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val ARG_PARAM_TASK_RESULT = "ARG_PARAM_TASK_RESULT"
    }
}
