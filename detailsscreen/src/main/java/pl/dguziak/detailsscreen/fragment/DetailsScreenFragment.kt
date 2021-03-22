package pl.dguziak.detailsscreen.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import pl.dguziak.detailsscreen.arg.TODO_ARGS
import pl.dguziak.detailsscreen.arg.TodoArgs
import pl.dguziak.detailsscreen.databinding.FragmentDetailsScreenBinding
import pl.dguziak.sharedresources.util.StatusConverter
import pl.dguziak.view.fragment.BaseFragment

class DetailsScreenFragment : BaseFragment<FragmentDetailsScreenBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireArguments().getParcelable<TodoArgs>(TODO_ARGS)?.apply {
            binding.itemNo.text = id.toString()
            binding.user.text = userId.toString()
            binding.title.text = title
            binding.status.text = StatusConverter.convertBooleanToStatus(resources, completed)
        }
    }

    override val viewBindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailsScreenBinding =
        FragmentDetailsScreenBinding::inflate

    companion object {

        fun newInstance(todo: TodoArgs) = DetailsScreenFragment().apply {
            arguments = bundleOf(TODO_ARGS to todo)
        }
    }
}