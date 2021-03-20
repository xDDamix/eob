package pl.dguziak.splashscreen.fragment

import android.os.Bundle
import android.view.View
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.dguziak.splashscreen.R
import pl.dguziak.splashscreen.viewmodel.SplashscreenViewModel
import pl.dguziak.view.fragment.BaseFragment

//todo: Add navigation feature
class SplashscreenFragment : BaseFragment() {

    private val splashscreenViewModel: SplashscreenViewModel by viewModel()

    override fun provideLayoutId(): Int = R.layout.fragment_splashscreen

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        splashscreenViewModel.navigateNextLiveEvent.observe(viewLifecycleOwner, {

        })
    }
}