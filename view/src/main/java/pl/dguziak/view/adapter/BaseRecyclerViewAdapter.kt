package pl.dguziak.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import pl.dguziak.view.LayoutProvideable
import pl.dguziak.view.fragment.ViewBindingInflater

abstract class BaseRecyclerViewAdapter<DATA_ITEM, VIEW_BINDING : ViewBinding>(
    private var dataset: MutableList<DATA_ITEM>
) : RecyclerView.Adapter<BaseRecyclerViewAdapter.BaseViewHolder<DATA_ITEM, VIEW_BINDING>>(),
    ViewBindingInflater<VIEW_BINDING> {

    abstract fun provideViewHolder(viewBinding: VIEW_BINDING): BaseViewHolder<DATA_ITEM, VIEW_BINDING>

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<DATA_ITEM, VIEW_BINDING> {
        val viewBinding = viewBindingInflater(LayoutInflater.from(parent.context), parent, false)
        return provideViewHolder(viewBinding)
    }

    fun changeDataset(dataset: List<DATA_ITEM>) {
        this.dataset = dataset.toMutableList()
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: BaseViewHolder<DATA_ITEM, VIEW_BINDING>, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount(): Int = dataset.count()

    abstract class BaseViewHolder<DATA_ITEM, VIEW_BINDING : ViewBinding>(
        itemBinding: VIEW_BINDING
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        abstract fun bind(data: DATA_ITEM)
    }
}