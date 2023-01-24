import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){
    var timeCount = 0
    val startVal = 10
    val timeCountDown = flow<Int>{
        var currentVal = startVal

        emit(currentVal)
        while (currentVal > 0){
            delay(1500L)
            emit(currentVal)
        }
    }

     fun flowRun(){
      viewModelScope.launch {
        timeCountDown.collect {
            time -> timeCount = time
        }
      }
    }
}