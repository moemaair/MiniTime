import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class MainViewModel : ViewModel(){
    val startVal = 10
    val timeCountDown = flow<Int>{
       var currentVal = startVal

        emit(currentVal)
        while (currentVal > 0){
            delay(1500L)
            currentVal--
            emit(currentVal)
        }
    }

}