package com.example.driverslicensetickets.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.driverslicensetickets.R
import com.example.driverslicensetickets.ViewModelsFactory
import com.example.driverslicensetickets.databinding.FragmentMainChoiceBinding
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
        binding.categoryA.setIcon(resources.getDrawable(R.drawable.icon_frames, null))
        binding.categoryA.setTitle(resources.getString(R.string.category_a))

        binding.categoryB.setIcon(resources.getDrawable(R.drawable.icon_frames_car, null))
        binding.categoryB.setTitle(resources.getString(R.string.category_b))

        viewLifecycleOwner.lifecycleScope.launch {
//            viewModel.ticketsCategoryA.collect {
//                binding.categoryA.setOnClickListener {
//                    findNavController().navigate(R.id.action_mainChoiceFragment_to_testingFragment)
//                }
//            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
//            viewModel.ticketsCategoryB.collect {
//                binding.categoryB.setOnClickListener {
//                    findNavController().navigate(R.id.action_mainChoiceFragment_to_testingFragment)
//                }
//            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
