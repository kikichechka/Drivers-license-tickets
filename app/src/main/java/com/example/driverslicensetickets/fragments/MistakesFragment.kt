package com.example.driverslicensetickets.fragments

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.driverslicensetickets.databinding.FragmentMistakesBinding
import com.example.driverslicensetickets.model.ListInCorrectTickets
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MistakesFragment : Fragment() {
    private var _binding: FragmentMistakesBinding? = null
    private val binding: FragmentMistakesBinding
        get() = _binding!!
    private var paramTask: ListInCorrectTickets? = null
    private var selectedIndex = 0
    private lateinit var adapter: InCorrectAnswerAdapter

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            paramTask = if (Build.VERSION.SDK_INT >= 33)
                it.getParcelable(ARG_PARAM_TASK_MISTAKES, ListInCorrectTickets::class.java)
            else
                it.getParcelable(ARG_PARAM_TASK_MISTAKES)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMistakesBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        paramTask?.list?.first()?.let {
            adapter = InCorrectAnswerAdapter(
                it.inCorrectAnswer,
                it.answers
            )
        }

        binding.recycler.adapter = adapter
        showTicket()

        binding.buttonNext.setOnClickListener {
            if (selectedIndex + 1 <= (paramTask?.list?.size?.minus(1) ?: 0)) {
                selectedIndex++
                showTicket()
            }
        }

        binding.buttonBack.setOnClickListener {
            if (selectedIndex - 1 >= 0) {
                selectedIndex--
                showTicket()
            }
        }

        binding.topAppBar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showTicket() {
        paramTask?.list?.getOrNull(selectedIndex)?.let {
            with(binding) {
                val uri = Uri.parse("${URI_STRING}${it.image.substring(1)}")
                Glide.with(root.context)
                    .load(uri)
                    .fitCenter()
                    .into(image)
                countTicket.text = "${selectedIndex + 1}. "
                question.text = it.question
                val inCorrectAnswerAdapter = InCorrectAnswerAdapter(
                    it.inCorrectAnswer,
                    it.answers
                )
                recycler.adapter = inCorrectAnswerAdapter
                answerTip.text = it.answerTip
            }
            changeListAdapter()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun changeListAdapter() {
        paramTask?.list?.getOrNull(selectedIndex)?.let {
            adapter.changeList(it.answers)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val ARG_PARAM_TASK_MISTAKES = "ARG_PARAM_TASK_MISTAKES"
        private const val URI_STRING = "https://comandosfru.xyz/pdd/"
    }
}
