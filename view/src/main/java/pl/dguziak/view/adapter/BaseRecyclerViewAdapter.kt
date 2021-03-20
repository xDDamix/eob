package pl.dguziak.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.dguziak.view.LayoutProvideable

abstract class BaseRecyclerViewAdapter<DATA_ITEM>(
    private var dataset: MutableList<DATA_ITEM>
) : RecyclerView.Adapter<BaseRecycleViewViewHolder<DATA_ITEM>>(), LayoutProvideable {

    abstract override fun provideLayoutId(): Int
    abstract fun provideViewHolder(view: View): BaseRecycleViewViewHolder<DATA_ITEM>

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecycleViewViewHolder<DATA_ITEM> {
        val view = LayoutInflater.from(parent.context).inflate(provideLayoutId(), parent, false)

        return provideViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseRecycleViewViewHolder<DATA_ITEM>, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount(): Int = dataset.count()
}