package pl.dguziak.navigateable

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import pl.dguziak.core.BaseViewModel

class NavigateableActivityViewModel : BaseViewModel() {

    private val _navigationLiveData: MutableLiveData<FragmentChangeData> by lazy {
        MutableLiveData<FragmentChangeData>()
    }
    val navigationLiveData: LiveData<FragmentChangeData>
        get() = _navigationLiveData

    fun navigateTo(fragmentChangeData: FragmentChangeData) {
        _navigationLiveData.postValue(fragmentChangeData)
    }
}
