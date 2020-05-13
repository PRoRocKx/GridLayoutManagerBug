package ru.example.gridlayoutmanagerbug

import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class SimpleAdapter : RecyclerView.Adapter<SimpleAdapter.SimpleViewHolder>() {

    var items = listOf<String>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        Button(parent.context)
            .let(::SimpleViewHolder)

    override fun getItemCount() = items.count()

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        holder.onBind(items[position])
    }

    inner class SimpleViewHolder(private val button: Button) : RecyclerView.ViewHolder(button) {

        fun onBind(item: String) {
            button.text = item
        }
    }
}