package pl.dguziak.listscreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import pl.dguziak.domain.model.Todo
import pl.dguziak.listscreen.R
import pl.dguziak.listscreen.databinding.ItemListElementBinding
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
                status.text = convertTaskStatus(data.completed)

                itemLayout.setOnClickListener {
                    onClickAction.invoke(data)
                }
            }
        }

        private fun convertTaskStatus(isCompleted: Boolean): String =
            viewBinding.root.context.getString(
                if (isCompleted) R.string.task_status_completed else R.string.task_status_pending
            )
    }
}