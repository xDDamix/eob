package pl.dguziak.splashscreen.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.dguziak.listscreen.fragment.ListScreenFragment
import pl.dguziak.navigateable.FragmentChangeData
import pl.dguziak.navigateable.FragmentTransactionType
import pl.dguziak.navigateable.NavigateableActivityViewModel
import pl.dguziak.splashscreen.R
import pl.dguziak.splashscreen.databinding.FragmentSplashscreenBinding
import pl.dguziak.splashscreen.viewmodel.SplashscreenViewModel
import pl.dguziak.view.fragment.BaseFragment

class SplashscreenFragment : BaseFragment<FragmentSplashscreenBinding>() {

    private val splashscreenViewModel: SplashscreenViewModel by viewModel()
    private val navigateableActivityViewModel: NavigateableActivityViewModel by sharedViewModel()

    override fun setupObservers() {
        super.setupObservers()
        splashscreenViewModel.navigateNextLiveEvent.observe(viewLifecycleOwner, {
            navigateableActivityViewModel.navigateTo(
                FragmentChangeData(ListScreenFragment(), FragmentTransactionType.REPLACE, false)
            )
        })
    }

    override val viewBindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSplashscreenBinding =
        FragmentSplashscreenBinding::inflate
}