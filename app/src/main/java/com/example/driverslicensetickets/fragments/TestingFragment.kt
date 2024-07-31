package com.example.driverslicensetickets.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.R
import androidx.navigation.fragment.findNavController
import com.example.driverslicensetickets.databinding.FragmentTestingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TestingFragment : Fragment() {

    private var _binding: FragmentTestingBinding? = null
    private val binding: FragmentTestingBinding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTestingBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.iconCardView.setOnClickListener {
//            findNavController().navigate(R.id.action_testingFragment_to_testResultsFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
