import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){
    var timeCount = 0
    val startVal = 25
    var timeCountDown = flow<Int>{
        var currentVal = startVal

        emit(currentVal)
        while (currentVal > 0){
            delay(1000L)
            currentVal--
            emit(currentVal)
        }
    }

    var saved = flow{
        emit(startVal)
    }



}