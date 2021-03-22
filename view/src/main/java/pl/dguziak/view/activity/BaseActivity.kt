package pl.dguziak.view.activity

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.dguziak.navigateable.FragmentChangeData
import pl.dguziak.navigateable.NavigateableActivityViewModel
import pl.dguziak.view.LayoutProvideable

abstract class BaseActivity : FragmentActivity(), LayoutProvideable, ContainerProvideable,
    NavigateableActivity {

    private val navigateableActivityViewModel: NavigateableActivityViewModel by viewModel()

    abstract override fun provideLayoutId(): Int
    abstract override fun provideContentContainer(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(provideLayoutId())

        Log.d("EOApp", " BaseActivity onCreate $navigateableActivityViewModel")

        setupListeners()
    }

    private fun setupListeners() {
        navigateableActivityViewModel.navigationLiveData.observe(this, {
            changeFragment(it)
        })
    }

    override fun changeFragment(fragmentChangeData: FragmentChangeData) {
        changeFragment(
            fragment = fragmentChangeData.fragment,
            containerId = provideContentContainer(),
            transactionType = fragmentChangeData.transactionType,
            withBackStack = fragmentChangeData.withBackStack
        )
    }

    //todo: apply
    fun changeFragment(
        fragment: Fragment,
        containerId: Int,
        transactionType: pl.dguziak.navigateable.FragmentTransactionType,
        withBackStack: Boolean = true,
        fragmentTag: String? = fragment::class.simpleName
    ) {
        val transaction = supportFragmentManager.beginTransaction()
        if (transactionType == pl.dguziak.navigateable.FragmentTransactionType.ADD) {
            transaction.add(containerId, fragment, fragmentTag)
        } else if (transactionType == pl.dguziak.navigateable.FragmentTransactionType.REPLACE) {
            transaction.replace(containerId, fragment, fragmentTag)
        }

        if (withBackStack) {
            transaction.addToBackStack(fragmentTag)
        }

        transaction.commit()
    }
}

