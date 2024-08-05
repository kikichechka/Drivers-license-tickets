package com.example.driverslicensetickets.fragments

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.driverslicensetickets.databinding.ItemAnswerBinding
import com.example.driverslicensetickets.model.Answer

class TestingAdapter(
    private val click: (position: Int) -> Unit,
    private var list: List<Answer>
) : RecyclerView.Adapter<TestingAdapter.TestingViewHolder>() {

    fun changeList(newList: List<Answer>) {
        list = newList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestingViewHolder {
        return TestingViewHolder(ItemAnswerBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: TestingViewHolder, position: Int) {
        val item = list[position]
        holder.binding.sequenceNumber.text = (position + 1).toString()
        holder.binding.answer.text = item.answerText
        holder.binding.root.setOnClickListener {
            click(position)
        }
    }

    class TestingViewHolder(val binding: ItemAnswerBinding) : ViewHolder(binding.root)
}