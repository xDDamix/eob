package pl.dguziak.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VIEW_BINDING : ViewBinding> : Fragment(),
    ViewBindingInflater<VIEW_BINDING> {

    private var _binding: VIEW_BINDING? = null
    protected val binding get() = _binding!!

    open fun setupObservers() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = viewBindingInflater(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupObservers()
        super.onViewCreated(view, savedInstanceState)
    }
}