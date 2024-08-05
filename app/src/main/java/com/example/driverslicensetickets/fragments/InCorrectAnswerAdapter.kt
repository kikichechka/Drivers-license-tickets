package com.example.driverslicensetickets.fragments

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.driverslicensetickets.R
import com.example.driverslicensetickets.databinding.ItemAnswerBinding
import com.example.driverslicensetickets.model.Answer

class InCorrectAnswerAdapter(private val mistakePosition: Int, private var list: List<Answer>) :
    RecyclerView.Adapter<InCorrectAnswerAdapter.InCorrectAnswerViewHolder>() {

    fun changeList(newList: List<Answer>) {
        list = newList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InCorrectAnswerViewHolder {
        return InCorrectAnswerViewHolder(ItemAnswerBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: InCorrectAnswerViewHolder, position: Int) {
        val item = list[position]
        with(holder.binding) {
            if (position == mistakePosition) {
                card.setCardBackgroundColor(root.context.getColor(R.color.red))
                setColorMistakePosition(holder)
            }

            if (item.isCorrect) {
                card.setCardBackgroundColor(root.context.getColor(R.color.green))
                setColorMistakePosition(holder)
            }
            sequenceNumber.text = (position + 1).toString()
            answer.text = item.answerText
        }
    }

    private fun setColorMistakePosition(holder: InCorrectAnswerViewHolder) {
        with(holder.binding) {
            sequenceNumber.setTextColor(root.context.getColor(R.color.white))
            separator.setTextColor(root.context.getColor(R.color.white))
            answer.setTextColor(root.context.getColor(R.color.white))
        }
    }

    class InCorrectAnswerViewHolder(val binding: ItemAnswerBinding) : ViewHolder(binding.root)
}
