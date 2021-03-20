package pl.dguziak.view.activity

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import pl.dguziak.view.LayoutProvideable
import pl.dguziak.view.fragment.BaseFragment

abstract class BaseActivity : FragmentActivity(), LayoutProvideable {

    abstract override fun provideLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(provideLayoutId())
    }

    //todo: apply
    fun changeFragment(
        fragment: BaseFragment,
        containerId: Int,
        transactionType: FragmentTransactionType,
        withBackStack: Boolean = true,
        fragmentTag: String? = fragment::class.simpleName
    ) {
        supportFragmentManager.beginTransaction().apply {
            if (transactionType == FragmentTransactionType.ADD) {
                add(containerId, fragment, fragmentTag)
            } else if (transactionType == FragmentTransactionType.REPLACE) {
                replace(containerId, fragment, fragmentTag)
            }

            if(withBackStack) {
                addToBackStack(fragmentTag)
            } else {
                addToBackStack(null)
            }

            commit()
        }
    }
}

enum class FragmentTransactionType {
    REPLACE,
    ADD
}