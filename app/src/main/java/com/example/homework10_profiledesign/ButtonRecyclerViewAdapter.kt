package com.example.homework10_profiledesign

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework10_profiledesign.databinding.ItemButtonRecyclerViewBinding
import com.example.homework10_profiledesign.databinding.ItemSwitchButtonRecyclerViewBinding

class ButtonRecyclerViewAdapter :
    ListAdapter<Button, RecyclerView.ViewHolder>(object :
        DiffUtil.ItemCallback<Button>() {
        override fun areItemsTheSame(oldItem: Button, newItem: Button): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Button, newItem: Button): Boolean {
            return oldItem == newItem
        }
    }) {

    companion object {
        const val NORMAL_BUTTON_TYPE = 1
        const val SWITCH_BUTTON_TYPE = 2
    }

    fun setData(buttons: List<Button>) {
        submitList(buttons)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == NORMAL_BUTTON_TYPE) {
            return NormalButtonViewHolder(
                ItemButtonRecyclerViewBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )
        } else {
            return SwitchButtonViewHolder(
                ItemSwitchButtonRecyclerViewBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is NormalButtonViewHolder -> holder.bind()
            is SwitchButtonViewHolder -> holder.bind()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (currentList[position].type == ButtonType.NORMAL) {
            NORMAL_BUTTON_TYPE
        } else {
            SWITCH_BUTTON_TYPE
        }
    }

    inner class NormalButtonViewHolder(private val binding: ItemButtonRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val buttons = currentList[adapterPosition]
            binding.apply {
                btn.setCompoundDrawables(buttons.icon, null, R.drawable.ic_arrow_right.toDrawable(), null)
                btn.text = buttons.name
            }
        }
    }

    inner class SwitchButtonViewHolder(private val binding: ItemSwitchButtonRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val buttons = currentList[adapterPosition]
            binding.apply {
                btnSwitch.setCompoundDrawablesWithIntrinsicBounds(buttons.icon, null, null, null)
                btnSwitch.text = buttons.name
            }
        }
    }
}