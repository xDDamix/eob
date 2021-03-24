package pl.dguziak.splashscreen.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pl.dguziak.core.BaseViewModel

private const val SPLASHSCREEN_VISIBILITY_MS = 5000L

class SplashscreenViewModel: BaseViewModel() {

    //todo: Add wrapper to prevent possible multiple events shoting (eg. onResume() re-send of event)
    private val _navigateNextLiveEvent: MutableLiveData<Nothing> by lazy {
        MutableLiveData()
    }
    val navigateNextLiveEvent: LiveData<Nothing>
        get() = _navigateNextLiveEvent

    private val _changeProgressBarOverTime: MutableLiveData<Long> by lazy {
        MutableLiveData()
    }
    val changeProgressBarOverTime: LiveData<Long>
        get() = _changeProgressBarOverTime

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                _changeProgressBarOverTime.postValue(SPLASHSCREEN_VISIBILITY_MS)
                delay(SPLASHSCREEN_VISIBILITY_MS)
                _navigateNextLiveEvent.postValue(null)
            }
        }
    }
}