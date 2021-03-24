package pl.dguziak.listscreen.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.dguziak.detailsscreen.arg.toArgs
import pl.dguziak.detailsscreen.fragment.DetailsScreenFragment
import pl.dguziak.domain.model.Todo
import pl.dguziak.listscreen.adapter.DataListAdapter
import pl.dguziak.listscreen.databinding.FragmentListScreenBinding
import pl.dguziak.listscreen.viewmodel.ListScreenViewModel
import pl.dguziak.navigateable.FragmentChangeData
import pl.dguziak.navigateable.FragmentTransactionType
import pl.dguziak.navigateable.NavigateableActivityViewModel
import pl.dguziak.view.fragment.BaseFragment

//todo: LayoutProvideable to delete
class ListScreenFragment : BaseFragment<FragmentListScreenBinding>() {

    private val listScreenViewModel: ListScreenViewModel by viewModel()
    private val navigateableActivityViewModel: NavigateableActivityViewModel by sharedViewModel()

    private val listRecyclerViewAdapter: DataListAdapter = DataListAdapter(this::navigateToDetails, mutableListOf())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.itemsListRecyclerView.adapter = listRecyclerViewAdapter
        binding.itemsListRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        listScreenViewModel.fetchData()
    }

    override fun setupObservers() {
        super.setupObservers()
        listScreenViewModel.dataReceivedLiveData.observe(viewLifecycleOwner, {
            listRecyclerViewAdapter.changeDataset(it)
        })
    }

    private fun navigateToDetails(todo: Todo) {
        navigateableActivityViewModel.navigateTo(FragmentChangeData(DetailsScreenFragment.newInstance(todo.toArgs()), FragmentTransactionType.REPLACE, true))
    }

    override val viewBindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentListScreenBinding =
        FragmentListScreenBinding::inflate
}