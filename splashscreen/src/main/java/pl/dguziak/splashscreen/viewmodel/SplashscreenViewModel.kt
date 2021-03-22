package pl.dguziak.splashscreen.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pl.dguziak.core.BaseViewModel

private const val SPLASHSCREEN_VISIBILITY_MS = 1000L

class SplashscreenViewModel: BaseViewModel() {

    //todo: Add wrapper to prevent multiple events shoting (eg. onResume() re-send of event)
    private val _navigateNextLiveEvent: MutableLiveData<Nothing> by lazy {
        MutableLiveData()
    }

    val navigateNextLiveEvent: LiveData<Nothing>
        get() = _navigateNextLiveEvent

    init {
        Log.d("EOApp", "SplashscreenViewModel init ")
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                delay(SPLASHSCREEN_VISIBILITY_MS)
                _navigateNextLiveEvent.postValue(null)
            }
        }
    }
}