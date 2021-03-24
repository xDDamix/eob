package pl.dguziak.listscreen.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pl.dguziak.core.BaseViewModel
import pl.dguziak.domain.model.Todo
import pl.dguziak.domain.usecase.GetTodosUseCase

class ListScreenViewModel(
    private val getTodosUseCase: GetTodosUseCase
) : BaseViewModel() {

    private val _dataReceivedLiveData: MutableLiveData<List<Todo>> by lazy {
        MutableLiveData<List<Todo>>()
    }
    val dataReceivedLiveData: LiveData<List<Todo>>
        get() = _dataReceivedLiveData

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                _dataReceivedLiveData.postValue(getTodosUseCase.execute())
            }
        }
    }
}