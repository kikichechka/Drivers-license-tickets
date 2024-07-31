package com.example.driverslicensetickets

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.FrameLayout
import com.example.driverslicensetickets.databinding.CustomCardItemCategoryBinding
import javax.inject.Inject

class CustomCardItemCategory @Inject constructor(
    context: Context,
    attributeSet: AttributeSet? = null
) :
    FrameLayout(context, attributeSet) {
    private val binding: CustomCardItemCategoryBinding

    init {
        val inflatedView = inflate(
            context,
            R.layout.custom_card_item_category,
            this
        )
        binding = CustomCardItemCategoryBinding.bind(inflatedView)
    }

    fun setIcon(icon: Drawable) {
        binding.icon.setImageDrawable(icon)
    }

    fun setTitle(title: String) {
        binding.titleCategory.text = title
    }
}
