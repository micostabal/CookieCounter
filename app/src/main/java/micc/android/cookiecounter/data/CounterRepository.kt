package micc.android.cookiecounter.data

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CounterRepository(private val counterDao: CounterDao) {

    val allEmployees = MutableLiveData<List<Counter>>()
    val foundEmployee = MutableLiveData<Counter>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun addCounter(newCounter: Counter) {
        coroutineScope.launch(Dispatchers.IO) {
            counterDao.addCounter(newCounter)
        }
    }

    fun getCounter(counterId: String): Counter {
        return counterDao.findCounterById(counterId)
    }
}