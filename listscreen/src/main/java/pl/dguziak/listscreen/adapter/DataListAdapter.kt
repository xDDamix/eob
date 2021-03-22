package pl.dguziak.listscreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import pl.dguziak.domain.model.Todo
import pl.dguziak.listscreen.databinding.ItemListElementBinding
import pl.dguziak.sharedresources.util.StatusConverter
import pl.dguziak.view.adapter.BaseRecyclerViewAdapter

class DataListAdapter(private val onClickAction: (Todo) -> Unit, dataset: MutableList<Todo>) :
    BaseRecyclerViewAdapter<Todo, ItemListElementBinding>(dataset) {

    override val viewBindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> ItemListElementBinding =
        ItemListElementBinding::inflate

    override fun provideViewHolder(viewBinding: ItemListElementBinding) =
        DataListViewHolder(viewBinding, onClickAction)

    class DataListViewHolder(
        private val viewBinding: ItemListElementBinding,
        private val onClickAction: (Todo) -> Unit
    ) :
        BaseViewHolder<Todo, ItemListElementBinding>(viewBinding) {

        override fun bind(data: Todo) {
            viewBinding.apply {
                user.text = data.userId.toString()
                itemNo.text = data.id.toString()
                title.text = data.title
                status.text = StatusConverter.convertBooleanToStatus(viewBinding.root.context.resources, data.completed)

                itemLayout.setOnClickListener {
                    onClickAction.invoke(data)
                }
            }
        }
    }
}