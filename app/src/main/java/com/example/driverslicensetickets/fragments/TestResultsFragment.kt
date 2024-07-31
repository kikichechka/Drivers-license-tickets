package com.example.driverslicensetickets.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.driverslicensetickets.databinding.FragmentTestResultsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TestResultsFragment : Fragment() {
    private var _binding: FragmentTestResultsBinding? = null
    private val binding: FragmentTestResultsBinding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTestResultsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.progressIndicator.progress = 90
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
