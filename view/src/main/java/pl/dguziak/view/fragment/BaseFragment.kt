package pl.dguziak.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import pl.dguziak.view.LayoutProvideable

abstract class BaseFragment: Fragment(), LayoutProvideable {

    abstract override fun provideLayoutId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(provideLayoutId(), container, false)
    }
}