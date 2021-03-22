package pl.dguziak.eob.activity

import android.os.Bundle
import pl.dguziak.eob.R
import pl.dguziak.navigateable.FragmentTransactionType
import pl.dguziak.splashscreen.fragment.SplashscreenFragment
import pl.dguziak.view.activity.BaseActivity

class MainActivity: BaseActivity() {

    override fun provideLayoutId(): Int = R.layout.activity_main
    override fun provideContentContainer(): Int = R.id.main_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        changeFragment(SplashscreenFragment(), R.id.main_container, FragmentTransactionType.REPLACE, false)
    }
}