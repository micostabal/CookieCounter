package micc.android.cookiecounter.data

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CounterRepository(private val counterDao: CounterDao) {

    val allCounters = MutableLiveData<List<Counter>>()
    val foundCounters = MutableLiveData<Counter>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun addCounter(newCounter: Counter) {
        coroutineScope.launch(Dispatchers.IO) {
            counterDao.addCounter(newCounter)
        }
    }

    fun getAllCounters() {
        coroutineScope.launch(Dispatchers.IO) {
            allCounters.postValue(counterDao.getAllCounters());
        }
    }

    fun getCounter(counterId: String) {
        counterDao.findCounterById(counterId)
    }
}