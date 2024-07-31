package com.example.driverslicensetickets.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.driverslicensetickets.databinding.FragmentMistakesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MistakesFragment : Fragment() {
    private var _binding: FragmentMistakesBinding? = null
    private val binding: FragmentMistakesBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMistakesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
