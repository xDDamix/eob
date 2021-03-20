package pl.dguziak.eob.activity

import android.os.Bundle
import pl.dguziak.eob.R
import pl.dguziak.splashscreen.fragment.SplashscreenFragment
import pl.dguziak.view.activity.BaseActivity
import pl.dguziak.view.activity.FragmentTransactionType

class MainActivity: BaseActivity() {

    override fun provideLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        changeFragment(SplashscreenFragment(), R.id.main_container, FragmentTransactionType.REPLACE)
    }
}