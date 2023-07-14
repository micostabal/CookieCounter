package micc.android.cookiecounter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import micc.android.cookiecounter.data.Counter
import micc.android.cookiecounter.data.CounterRepository
import javax.inject.Inject


@HiltViewModel
class CounterViewModel @Inject constructor(private val counterRepository: CounterRepository) :
    ViewModel() {

    fun getAllCounters() {
        counterRepository.getAllCounters()
    }

    fun saveCounter(counter: Counter) {
        counterRepository.addCounter(counter)
        getAllCounters()
    }

    fun setCount(counter: Counter, newCount: Int) {
        counterRepository.setCount(counter, newCount)
        getAllCounters()
    }

    fun deleteCounter(counter: Counter) {
        counterRepository.deleteCounter(counter)
        getAllCounters()
    }

    val counterList: LiveData<List<Counter>> = counterRepository.allCounters
}