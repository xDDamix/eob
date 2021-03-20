package pl.dguziak.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecycleViewViewHolder<DATA_ITEM>(item: View): RecyclerView.ViewHolder(item) {

    abstract fun initViewHolder()
    abstract fun bind(data: DATA_ITEM)
}