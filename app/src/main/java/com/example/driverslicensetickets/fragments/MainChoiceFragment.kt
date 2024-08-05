package com.example.driverslicensetickets.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.driverslicensetickets.R
import com.example.driverslicensetickets.ViewModelsFactory
import com.example.driverslicensetickets.databinding.FragmentMainChoiceBinding
import com.example.driverslicensetickets.model.ListTickets
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainChoiceFragment : Fragment() {
    private var _binding: FragmentMainChoiceBinding? = null
    private val binding: FragmentMainChoiceBinding
        get() = _binding!!

    @Inject
    lateinit var viewModelsFactory: ViewModelsFactory
    private val viewModel: MainChoiceViewModel by viewModels { viewModelsFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainChoiceBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadingTicketsCategoryA()
        loadingTicketsCategoryB()

        binding.categoryA.setIcon(resources.getDrawable(R.drawable.icon_frames, null))
        binding.categoryA.setTitle(resources.getString(R.string.category_a))

        binding.categoryB.setIcon(resources.getDrawable(R.drawable.icon_frames_car, null))
        binding.categoryB.setTitle(resources.getString(R.string.category_b))
    }

    private fun loadingTicketsCategoryA() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.ticketsCategoryA.collect {
                it?.let {
                    val listTickets = ListTickets(NAME_CATEGORY_A, it)
                    with(binding.categoryA) {
                        isClickable = true
                        setOnClickListener {
                            val bundle = Bundle().apply {
                                putParcelable(TestingFragment.ARG_PARAM_TASK, listTickets)
                            }
                            findNavController().navigate(
                                R.id.action_mainChoiceFragment_to_testingFragment,
                                bundle
                            )
                        }
                    }
                }
                if (it == null) {
                    binding.categoryA.setOnClickListener {
                        Toast.makeText(
                            requireContext(),
                            getString(R.string.check_your_internet_connection),
                            Toast.LENGTH_SHORT
                        ).show()
                        viewModel.loadData()
                    }
                }
            }
        }
    }

    private fun loadingTicketsCategoryB() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.ticketsCategoryB.collect {
                it?.let {
                    val listTickets = ListTickets(NAME_CATEGORY_B, it)
                    with(binding.categoryB) {
                        isClickable = true
                        setOnClickListener { _ ->
                            val bundle = Bundle().apply {
                                putParcelable(TestingFragment.ARG_PARAM_TASK, listTickets)
                            }
                            findNavController().navigate(
                                R.id.action_mainChoiceFragment_to_testingFragment,
                                bundle
                            )
                        }
                    }
                }

                if (it == null) {
                    binding.categoryB.setOnClickListener {
                        Toast.makeText(
                            requireContext(),
                            getString(R.string.check_your_internet_connection),
                            Toast.LENGTH_SHORT
                        ).show()
                        viewModel.loadData()
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object{
        private const val NAME_CATEGORY_A = "А"
        private const val NAME_CATEGORY_B = "В"
    }
}
